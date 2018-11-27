package gamemain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import gamemain.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game,HUD hud, Handler handler) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			
		
		//Play Button
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
			handler.clearEnemies();
		
			//handler.addObject(new Player(WIDTH/2-64,HEIGHT/2-32, ID.Player2));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			
		}
		
		//Quit button
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			System.exit(1);

		}
			
		//Help button
		if(mouseOver(mx, my, 210, 250, 200, 64)) {
			game.gameState = STATE.Help;

		}
	}
		//Back Button
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 400, 350, 100, 50)) {
				game.gameState = STATE.Menu;

			}
		}
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
			
				//handler.addObject(new Player(WIDTH/2-64,HEIGHT/2-32, ID.Player2));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));

			}
		}
	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1 ,50);
		Font fnt2 = new Font("arial", 1 ,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 240, 70);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 275, 190);
		
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 275, 290);
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 275, 390);
	}else if(game.gameState == STATE.Help){
		
		Font fnt = new Font("arial", 1 ,30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("You've been bamboozeled", 100, 70);
		
		Font fnt2 = new Font("arial", 1 ,25);
		
		g.setFont(fnt2);
		g.drawRect(400, 350, 100, 50);
		g.drawString("Back", 419, 385);
	}else if(game.gameState == STATE.End){
		
		Font fnt = new Font("arial", 1 ,50);
		Font fnt2 = new Font("arial", 1 ,30);
		Font fnt3 = new Font("arial", 1 ,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 180, 70);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Your score is: "+ hud.getScore(), 200, 200);
		
		g.setFont(fnt3);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again", 265, 390);
	}
		
	}
}
