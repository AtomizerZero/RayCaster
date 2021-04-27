package com.atomizer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.atomizer.Main;

public class KeyInput extends KeyAdapter {

	Main game;

	public static boolean keyW, keyS, keyA, keyD, keySpace, keyEscape, keyShift, keyUp, keyDown, keyLeft,
			keyRight = false;

	public KeyInput(Main game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (key == KeyEvent.VK_UP) {
			keyUp = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			keyDown = true;
		}
		if (key == KeyEvent.VK_LEFT) {
			keyLeft = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			keyRight = true;
		}
		if (key == KeyEvent.VK_Q) {
		}
		if (key == KeyEvent.VK_W) {
			keyW = true;
		}
		if (key == KeyEvent.VK_E) {

		}
		if (key == KeyEvent.VK_R) {
		}
		if (key == KeyEvent.VK_T) {
		}
		if (key == KeyEvent.VK_Y) {
		}
		if (key == KeyEvent.VK_U) {
		}
		if (key == KeyEvent.VK_I) {
		}
		if (key == KeyEvent.VK_O) {
		}
		if (key == KeyEvent.VK_P) {
		}
		if (key == KeyEvent.VK_A) {
			keyA = true;
		}
		if (key == KeyEvent.VK_S) {
			keyS = true;
		}
		if (key == KeyEvent.VK_D) {
			keyD = true;
		}
		if (key == KeyEvent.VK_F) {
		}
		if (key == KeyEvent.VK_G) {
		}
		if (key == KeyEvent.VK_H) {
		}
		if (key == KeyEvent.VK_J) {
		}
		if (key == KeyEvent.VK_K) {
		}
		if (key == KeyEvent.VK_L) {
		}
		if (key == KeyEvent.VK_Z) {
		}
		if (key == KeyEvent.VK_X) {
		}
		if (key == KeyEvent.VK_C) {
		}
		if (key == KeyEvent.VK_V) {
		}
		if (key == KeyEvent.VK_B) {
		}
		if (key == KeyEvent.VK_N) {
		}
		if (key == KeyEvent.VK_M) {
		}
		if (key == KeyEvent.VK_SHIFT) {
			keyShift = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			keySpace = true;
		}
		if (key == KeyEvent.VK_F1) {
			
		}
		if (key == KeyEvent.VK_F2) {
			if (Main.getFrameRate() == 60.0) {
				Main.setFrameRate(6000.0);
				System.out.println(Main.getFrameRate());
			}

			else if (Main.getFrameRate() == 6000.0) {
				Main.setFrameRate(60.0);
				System.out.println(Main.getFrameRate());
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (key == KeyEvent.VK_UP) {
			keyUp = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			keyDown = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			keyLeft = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			keyRight = false;
		}
		if (key == KeyEvent.VK_Q) {
		}
		if (key == KeyEvent.VK_W) {
			keyW = false;
		}
		if (key == KeyEvent.VK_E) {
		}
		if (key == KeyEvent.VK_R) {
		}
		if (key == KeyEvent.VK_T) {
		}
		if (key == KeyEvent.VK_Y) {
		}
		if (key == KeyEvent.VK_U) {
		}
		if (key == KeyEvent.VK_I) {
		}
		if (key == KeyEvent.VK_O) {
		}
		if (key == KeyEvent.VK_P) {
		}
		if (key == KeyEvent.VK_A) {
			keyA = false;
		}
		if (key == KeyEvent.VK_S) {
			keyS = false;
		}
		if (key == KeyEvent.VK_D) {
			keyD = false;
		}
		if (key == KeyEvent.VK_F) {
		}
		if (key == KeyEvent.VK_G) {
		}
		if (key == KeyEvent.VK_H) {
		}
		if (key == KeyEvent.VK_J) {
		}
		if (key == KeyEvent.VK_K) {
		}
		if (key == KeyEvent.VK_L) {
		}
		if (key == KeyEvent.VK_Z) {
		}
		if (key == KeyEvent.VK_X) {
		}
		if (key == KeyEvent.VK_C) {
		}
		if (key == KeyEvent.VK_V) {
		}
		if (key == KeyEvent.VK_B) {
		}
		if (key == KeyEvent.VK_N) {
		}
		if (key == KeyEvent.VK_M) {
		}
		if (key == KeyEvent.VK_SHIFT) {
			keyShift = false;
		}
		if (key == KeyEvent.VK_SPACE) {
			keySpace = false;
		}
	}
	
	
}