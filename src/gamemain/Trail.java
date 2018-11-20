package gamemain;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float life;	//Life can be a value from 0.001 to 0.1
	
	public Trail(int x, int y, ID id,Color color,int width, int height, float life, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(alpha > life) {
			alpha -= life - 0.001f;
			
		}else handler.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g2d.setComposite(makeTransparent(1));
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
