package gamemain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	
	private int timer = 50;
	private int timer2 = 50;
	Random r = new Random();
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		velX = 0;
		velY = 2;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
			return new Rectangle((int)x,(int)y,96,96);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		
		if(timer <= 0) {
			velY = 0;
		} else timer --;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			
			if(velX == 0) velX = 2;
			
			if(velX > 0) velX += 0.005f;
			else if(velX <0) velX -= 0.005f;
			
			velX = Game.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if (spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48,(int)y + 48, ID.BasicEnemy, handler));
			
		}
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 100) velX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,96,96,0.2f,handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}




}
