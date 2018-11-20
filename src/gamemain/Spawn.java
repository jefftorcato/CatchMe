package gamemain;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scorekeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scorekeep++;
		
		if(scorekeep >= 1000) {
			scorekeep = 0;
			hud.setLevel(hud.getLevel() + 1); //Everytime the score becomes 1000 the level increments
		}
	}
}
