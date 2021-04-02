package main;

import processing.core.PApplet;

public class Avatar {

	
	private int x;
	private int y;
	private int color;
	private Main main;
	private boolean toUp = false;
	private boolean toDown = false;
	private boolean toLeft = false;
	private boolean toRight = false;
	
	public Avatar(Main main, int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.main = main;
	}
	
	public void pintar() {
		main.fill(this.color);
		main.ellipse(this.x, this.y, 50, 50);
		
		
		//arriba
		if(toUp) {
			this.y -= 2;
		}
		if(toDown) {
			this.y += 2;
		}
		if(toLeft) {
			this.x -= 2;
		}
		if(toRight) {
			this.x += 2;
		}
		
		
		
		
	}
	
	public void moveRight() {
		this.x+=5;
	}
	
	public void moveLeft() {
		this.x-=5;
	}
	public void moveUp() {
		this.y-=5;
	}
	public void moveDown() {
		this.y+=5;
	}
	
	
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void activateUpMove() {
		toUp = true;
		
	}
	
	public void desactivateUpMove() {
		toUp = false;
	}

	public void desactivateDownMove() {
		toDown = false;
	}
	
	public void activateDownMove() {
		toDown = true;
	}
	
	public void desactivateLeftMove() {
		toLeft = false;
	}
	
	public void activateLeftMove() {
		toLeft = true;
	}
	
	public void desactivateRightMove() {
		toRight = false;
	}
	
	public void activateRightMove() {
		toRight = true;
	}
	
	
	
	
	
}

