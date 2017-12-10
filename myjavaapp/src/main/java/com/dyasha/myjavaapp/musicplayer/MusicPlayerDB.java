package com.dyasha.myjavaapp.musicplayer;

import java.util.HashMap;
import java.util.Map;

public class MusicPlayerDB {

	private Map<Integer, String> songsDB = new HashMap<Integer, String>();
	private static MusicPlayerDB instance = new MusicPlayerDB();
	
	private MusicPlayerDB() {
		songsDB.put(1, "Song 1");
		songsDB.put(2, "Song 2");
		songsDB.put(3, "Song 3");
		songsDB.put(4, "Song 4");
		songsDB.put(5, "Song 5");
	}//End of Constructor
	
	/*private static MusicPlayerDB getInstance() {
		return instance;
	}*/

	public static Map<Integer, String> getSongsDB() {
		return instance.songsDB;
	}
	
	/*public static void addSongToPlayer(String songName) {
		getInstance().songsDB.put(key, value)
	}*/
	
}//End of Class
