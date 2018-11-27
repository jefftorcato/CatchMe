package gamemain;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	public static void load() {
		
		try {
			
			musicMap.put("music", new Music("res/background_music.ogg"));
		} catch (SlickException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	

	
}
