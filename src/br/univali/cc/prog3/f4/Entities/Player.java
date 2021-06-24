package br.univali.cc.prog3.f4.Entities;

import java.awt.Color;
import java.awt.Graphics;

import br.univali.cc.prog3.f4.Main.Game;

public class Player extends Entity {

	double life, max_life;
	private int direction;
	public boolean up, down, right, left;
	public boolean shoot;
	
	public Player(int x, int y, int w, int h) 
	{
		super(x, y, w, h, 1.4);
		direction = 1;
	}

	public void update()
	{
		if(shoot)
		{
			shoot = false;
			Game.bullets.add(new Bullet(posX, posY - (height / 2), direction));
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(0, 255, 255));
		g.fillOval(posX, posY, width, height);
	}
}
