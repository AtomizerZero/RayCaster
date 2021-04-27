package com.atomizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "TITLE HERE";
	public final static int windowWidth = 1280;
	public final static int windowHeight = 720;
	public static int updates = 0;
	public static int frames = 0;
	public static long timer = System.currentTimeMillis();
	public static int FPS = 0;
	public static int timing = 0;
	public static boolean running = false;
	private Thread thread;
	static JFrame frame = null;
	public static float delta = 0.0f;
	public static BufferStrategy bs;
	public BufferedImage image;

	public static int x = 0;
	public static int y = 0;
	public static int scale = 8;
	public static boolean showBlackBorders = false;
	public static Dimension dimension = new Dimension(windowWidth, windowHeight);

	public float px, py, pdx, pdy, pa;
	public int mapX = 8, mapY = 8, mapS = 64;
	public int[] map;
	///public float pi = 3.1415926535f;
	public float pi = (float) Math.PI;
	
	public static double frameRate = 60.0;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setSize(dimension);
		frame = new JFrame(TITLE);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				if ((e.getNewState() & Frame.MAXIMIZED_BOTH) != Frame.MAXIMIZED_BOTH) {
					System.out.println("not_maximized");
					setScale(8);
					showBlackBorders = false;
				} else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
					System.out.println("maximized");
					setScale(16);
					showBlackBorders = true;
				}
			}
		});

		// frame.setLocation(600, 300);
		frame.setUndecorated(true);
		frame.add(main);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(TITLE);
		frame.setVisible(true);
		frame.requestFocusInWindow();
		frame.getContentPane().setBackground(Color.BLACK);
		main.start();	

	}
	
	public void init() throws FontFormatException, IOException {
		requestFocus();
		
		image = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_ARGB);
		px = 300;
		py = 300;
		pa=0;
		pdx=(float) (Math.cos(pa)*5);
		pdy=(float) (Math.sin(pa)*5);
		
		map = new int[]{
			1,1,1,1,1,1,1,1,
			1,0,1,0,0,0,0,1,
			1,0,1,0,0,0,0,1,
			1,0,0,0,0,0,0,1,
			1,0,0,0,0,0,0,1,
			1,0,0,0,0,1,0,1,
			1,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1
			};
		
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
		addMouseWheelListener(new MouseInput(this));
	}
	
	public void drawMap2D(Graphics2D g) {
		int x, y, xo, yo;
		for (y = 0; y < mapY; y++) {
			for (x = 0; x < mapX; x++) {
				if (map[y*mapX+x] == 1) {
					g.setColor(Color.WHITE);
				}
				else {
					g.setColor(Color.BLACK);
				}
				xo = x * mapS;
				yo = y * mapS;
				g.fillRect(xo, yo, mapS, mapS);
							
			}
		}
	}
	
	public void update() {
		
		if(KeyInput.keyA) {
			pa -=0.1;
			if(pa < 0) {
				pa +=2*pi;
			}
			pdx=(float) (Math.cos(pa)*5);
			pdy=(float) (Math.sin(pa)*5);
		}
		if(KeyInput.keyD) {
			pa +=0.1;
			if(pa > 2*pi) {
				pa -=2*pi;
			}
			pdx=(float) (Math.cos(pa)*5);
			pdy=(float) (Math.sin(pa)*5);
		}
		if(KeyInput.keyW) {
			px +=pdx;
			py +=pdy;
		}
		if(KeyInput.keyS) {
			px -= pdx;
			py -= pdy;
		}

	}
	
	public synchronized void render() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		//g.clearRect(0, 0, windowWidth, windowHeight);
		g.setColor(Color.DARK_GRAY);
		g.drawImage(image, 0, 0, Color.DARK_GRAY, null);
		
		
		drawMap2D(g);
		drawPlayer(g);
		drawRays3D(g);
		
		
		g.dispose();
		bs.show();
	}
	
	public void drawPlayer(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)px, (int)py, 8, 8);
		g.drawLine((int)px+4, (int)py+4, (int)px+(int)pdx*5, (int)py+(int)pdy*5);
	}
	
	public void drawRays3D(Graphics2D g) {
		int r= 0, mx =0, my =0, mp =0, dof =0;
		float rx = 0, ry = 0, ra, xo = 0, yo = 0;
		ra=pa;
		for (r=0; r < 1; r++) 
		{
			dof = 0;
			float aTan = (float) (-1/Math.tan(ra));
			if (ra > pi) {
				ry = (float) ((((int)py>>6)<<6)-0.0001);
				rx = (py-ry)*aTan+px; yo=-64; xo=-yo*aTan;
			}
			if (ra < pi) {
				ry = (float) ((((int)py>>6)<<6)+64);
				rx = (py-ry)*aTan+px; yo=-64; xo=-yo*aTan;
			}
			if (ra==0 || ra==pi) {
				rx = px; ry=py; dof=8;
			}
			while (dof<8)
			{
				mx = (int)(rx) >>6; my=(int)(ry)>>6; mp=my*mapX+mx;
				if(mp < ((mapX*mapY)) && map[mp]==1) {
					dof=8;
				}
				else {
					rx += xo; ry += yo; dof +=1;
				}
			}
			g.setColor(Color.green);
			g.drawLine((int)px, (int)py, (int)rx, (int)ry);
			g.scale(2, 2);
			g.drawString("r" + r + 
					" mx" + mx + 
					" my" + my +
					" mp" + mp +
					" dof" + dof + 
					" xo" + xo +
					" yo" + yo +
					" rx" + rx +
					" ry" + ry + 
					" ra" + ra +
					" xo" + xo +
					" yo" + yo, 0, 16);
		}
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

	}
	@Override
	public void run() {
		try {
			init();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long lastTime = System.nanoTime();
		delta = 0.0f;

		double ns = 1000000000.0 / getFrameRate();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0f) {
				update();
				updates++;
				delta--;
			}

			render();

			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				FPS = updates;
				updates = 0;
				frames = 0;
			}
		}
		
	}
	
	public static void setScale(int a) {
		scale = a;
	}

	public int getScale() {
		return scale;
	}
	
	public static double getFrameRate() {
		return frameRate;
	}

	public static void setFrameRate(double frameRate) {
		Main.frameRate = frameRate;
	}

}
