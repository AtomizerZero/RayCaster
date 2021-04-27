package com.atomizer;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.atomizer.Main;

public class MouseInput extends MouseAdapter implements MouseWheelListener {

	Main game;

	public MouseInput(Main game) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mouse = e.getButton();
		
		switch (mouse) {
		case 1: System.out.println(mouse);break;
		case 2: System.out.println(mouse);break;
		case 3: System.out.println(mouse);break;
		case 4: System.out.println(mouse);break;
		case 5: System.out.println(mouse);break;
		}

		System.out.println("mX " + e.getX() + " mY " + e.getY());
	}
	
	public void mouseReleased(MouseEvent e) {
		int mouse = e.getButton();
		
		switch (mouse) {
		case 1: System.out.println(mouse);break;
		case 2: System.out.println(mouse);break;
		case 3: System.out.println(mouse);break;
		case 4: System.out.println(mouse);break;
		case 5: System.out.println(mouse);break;
		}
		System.out.println("mXr " + e.getX() + " mYr " + e.getY());

	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		int mouse = e.getWheelRotation();
		System.out.println("wheel: " + mouse);
	}

	public static int getMouseX() {
		return (int) MouseInfo.getPointerInfo().getLocation().getX();
	}
	
	public static int getMouseY() {
		return (int) MouseInfo.getPointerInfo().getLocation().getY();
	}
	
	
}
