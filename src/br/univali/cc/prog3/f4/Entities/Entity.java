package br.univali.cc.prog3.f4.Entities;

import java.awt.Graphics;

public abstract class Entity {

	int posY, posX;
	int width, height;
	double speed;
	
	public Entity(int x, int y, int w, int h, double spd) {
		this.posX = x;
		this.posY = y;
		this.height = h;
		this.width = w;
		this.speed = spd;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
