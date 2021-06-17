package br.univali.cc.prog3.f4.Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import br.univali.cc.prog3.f4.Entities.*;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 417897709572947194L;
	public static JFrame frame;
	
	private Thread thread;
	private boolean is_running = true; 
	
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 4;
	
	public static List<Entity> entities;
	public static List<Bullet> bullets;
	
	public static Player player;
	
	public Game() {
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		
		entities = new ArrayList<>();
		bullets = new ArrayList<>();
		
		player = new Player(0,0,16,16);
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
		
	}
	
	public void render()
	{
		
	}

	@Override
	public void run() {
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
