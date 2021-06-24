package br.univali.cc.prog3.f4.Entities;

import java.awt.Color;
import java.awt.Graphics;

import br.univali.cc.prog3.f4.Main.Game;

public class Spawner extends Entity {
	
	private int frames = 0;
	private int life;
	private Enemy prototype;

	public Spawner(int x, int y, int w, int h) 
	{
		super(x, y, w, h, 2);
		life = 50;
	}

	@Override
	public void update() 
	{
		
		if(frames == 600)
			Game.entities.add(spawnEnemy());
		
		if(life <= 0)
			Game.entities.remove(this);

	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.green);
		g.fillOval(posX, posY, width, height);

	}
	
	Enemy spawnEnemy()
	{
		return prototype.clone(this.posX, this.posY);
	}

}
