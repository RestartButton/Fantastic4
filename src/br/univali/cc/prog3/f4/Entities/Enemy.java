package br.univali.cc.prog3.f4.Entities;

public abstract class Enemy extends Entity {
	
	protected double life;

	public Enemy(int x, int y, int w, int h, double life) 
	{
		super(x, y, w, h, 0.4);
		
		this.life = life;
	}
	
	protected abstract Enemy clone(int x, int y);
}
