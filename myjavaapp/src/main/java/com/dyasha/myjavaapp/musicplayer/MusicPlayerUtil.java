package com.dyasha.myjavaapp.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MusicPlayerUtil {
	
	private static int numberOfSongs = MusicPlayerDB.getSongsDB().size();
	private static List<Integer> cache = new ArrayList<Integer>();
	
	private MusicPlayerUtil() {	}

	public static void printSongsList() {

		System.out.println("************ Avilable Songs  *************");
		for (int i = 1; i <= numberOfSongs; i++) {
			System.out.println(i + ". " + MusicPlayerDB.getSongsDB().get(i));
		}
		System.out.println("******************************************\n\n");
	
	}//End of printSongsList
	
	
	public static void playPerticularSong(int songId) throws Exception {
		System.out.println( "Playing the Song --> "+MusicPlayerDB.getSongsDB().get(songId) );
		Thread.currentThread().sleep(2*1000);
		System.out.println("Song Played ...\n\n");
	}//End of playPerticularSong
	
	
	public static void playAllSongs(Scanner scanner) throws Exception {
		
		String opt = "How do you want to play the Songs ... \n"
						+ "1. Random \n"
						+ "2. No Loop \n"
						+ "3. Loop All \n";
		
		switch(MusicPlayerUtil.getOptionFromUser(opt, scanner)) {
		
			case 1 :
					while(true) {
						playPerticularSong(getRandomNumber());
					}//End of while
					
			case 2 :
					for(int i=1; i<=numberOfSongs; i++) {
						playPerticularSong(i);
					}
					break;
					
			case 3 :
					while(true) {
						for(int i=1; i<=numberOfSongs; i++) {
							playPerticularSong(i);
						}
					}
		}//End of switch
	}//End of playAllSongs
	
	
	public static int getOptionFromUser(String msg, Scanner scanner) {

		System.out.println(msg);
		boolean loop = true;
		String val = null;
		
		getID : 
		while(loop) {
			val = scanner.nextLine();
			if(! isValidNumber(val, 5)) {
				continue getID;
			}
			loop = false;
		}//End of while
		
		return Integer.parseInt(val);
	}//End of getOptionFromUser
	
	
	
	private static boolean isValidNumber(String val, int limit) {
		
		int id;
		
		try {
			id = Integer.parseInt(val);
		} catch (Exception e1) {
			System.err.println("Oops !!! Please enter ONLY the \"Integer Value\" not something you like !!!");
			return false;
		}
		
		if(id > limit) {
			System.err.println("Please enter ONLY the \"Integer Value\" shown above not any arbitatry number !!! ");
			return false;
		}
		
		return true;
	}//End of isValidNumber

	private static int getRandomNumber() {
		
		Random rand = new Random(); 
		boolean loop = true;
		if(cache.size()==numberOfSongs) {
			cache.clear();
		}
		
		int no = 0;
		getRandom:
		while(loop) {
			no = rand.nextInt(numberOfSongs+1);
			no = no==0 ? ++no : no;
			if(cache.contains(no) ) {
				continue getRandom;
			}
			loop=false;
			cache.add(no);
		}
		return no;
	}
}//End of Class
