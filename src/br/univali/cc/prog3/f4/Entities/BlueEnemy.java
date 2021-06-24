package br.univali.cc.prog3.f4.Entities;

import java.awt.Color;
import java.awt.Graphics;

public class BlueEnemy extends Enemy {

	public BlueEnemy(int x, int y, int w, int h) 
	{
		super(x, y, w, h, 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Enemy clone(int x, int y) 
	{
		// TODO Auto-generated method stub
		return new BlueEnemy(x, y, width, height);
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(new Color(0, 0, 255));
		g.fillRect(posX, posY, width, height);
	}

}
