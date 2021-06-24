package br.univali.cc.prog3.f4.Entities;

import java.awt.Color;
import java.awt.Graphics;

public class RedEnemy extends Enemy {

	public RedEnemy(int x, int y, int w, int h) 
	{
		super(x, y, w, h, 15);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Enemy clone(int x, int y) 
	{
		// TODO Auto-generated method stub
		return new RedEnemy(x, y, width, height);
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(new Color(255, 0, 0));
		g.fillRect(posX, posY, width, height);
	}

}
