package main;

import processing.core.PApplet;

public class Bala {
	
	private int x;
	private int y;
	private PApplet p;
	private boolean moveRight;
	
	public Bala(PApplet p, int x, int y, boolean moveRight) {
		this.x = x;
		this.y = y;
		this.p = p;
		this.moveRight = moveRight;
		
	}
	
	public void pintar(){
		p.fill(255);
		p.ellipse(this.x, this.y, 10, 10);
		
		if(moveRight) {
			x += 5;
		}else {
			x -= 5;
		}
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

	public PApplet getP() {
		return p;
	}

	public void setP(PApplet p) {
		this.p = p;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	
	

}
