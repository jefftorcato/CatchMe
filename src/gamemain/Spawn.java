package gamemain;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scorekeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scorekeep++;
		
		if(scorekeep >= 100) {
			scorekeep = 0;
			hud.setLevel(hud.getLevel() + 1); //if the score becomes 1000 the level increments
		
			if(hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			} else if(hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}else if(hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
			}else if(hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}
		}
	}
}
