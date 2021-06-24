package br.univali.cc.prog3.f4.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	int posY, posX;
	int width, height;
	double speed;
	
	public Entity(int x, int y, int w, int h, double spd) 
	{
		this.posX = x;
		this.posY = y;
		this.height = h;
		this.width = w;
		this.speed = spd;
	}
	
	public static boolean isColliding(Entity e1, Entity e2)
	{
		Rectangle e1_Mask = new Rectangle(e1.posX, e1.posY, e1.width, e1.height);
		Rectangle e2_Mask = new Rectangle(e2.posX, e2.posY, e2.width, e2.height);
		
		return e1_Mask.intersects(e2_Mask);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
