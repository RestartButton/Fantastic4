package br.univali.cc.prog3.f4.Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import br.univali.cc.prog3.f4.Entities.*;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 417897709572947194L;
	public static JFrame frame;
	
	private Thread thread;
	private boolean is_running = true; 
	private BufferedImage image;
	
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 4;
	
	public static List<Entity> entities;
	public static List<Bullet> bullets;
	
	public static Player player;
	public static Spawner spawner;
	
	public Game() 
	{
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<>();
		bullets = new ArrayList<>();
		
		player = new Player(0,0,16,16);
		entities.add(player);
		spawner = new Spawner(WIDTH - 16, HEIGHT - 16, 16, 16);
		entities.add(spawner);
	}
	
	public void initFrame()
	{
		frame = new JFrame("Quarteto Fantastico");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void start()
	{
		thread = new Thread(this);
		is_running = true;
		thread.start();
	}
	
	public void stop()
	{
		is_running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		for(Entity e : entities)
		{
			e.update();
		}
		for(Bullet b : bullets)
		{
			b.update();
		}
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(Entity e : entities)
		{
			e.render(g);
		}
		for(Bullet b : bullets)
		{
			b.render(g);
		}
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		bs.show();
		
	}

	@Override
	public void run() 
	{
		long last_time = System.nanoTime();
		double FPS = 60.0;
		double ns = 1000000000 / FPS;
		double delta = 0;
		double timer = System.currentTimeMillis();
		while(is_running)
		{
			long now = System.nanoTime();
			delta += (now - last_time) / ns;
			last_time = now;
			if(delta >= 1) 
			{
				update();
				render();
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000)
			{
				timer += 1000;
			}
			
		}
		stop();
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
