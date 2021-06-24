package br.univali.cc.prog3.f4.Entities;

import java.awt.Color;
import java.awt.Graphics;

import br.univali.cc.prog3.f4.Main.Game;

public class Bullet extends Entity {

	private int direction;
	private int life = 32;
	
	public Bullet(int x, int y, int d) {
		super(x, y, 3, 3, 4);
		this.direction = d;
	}

	public void update()
	{
		posX += direction * speed;
		life--;
		if(life <= 0)
		{
			Game.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillOval(posX, posY, width, height);
	}
}
