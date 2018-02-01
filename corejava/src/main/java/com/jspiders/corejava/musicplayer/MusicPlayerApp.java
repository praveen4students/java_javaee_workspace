package com.jspiders.corejava.musicplayer;

import java.util.Scanner;

public class MusicPlayerApp {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		MusicPlayerUtil.printSongsList();
		
		String opt1 = "Please Choose One of the Below Options ... \n"
						  + "Option 1:- Do you want to Play a Perticular Song ? \n"
						  + "Option 2:- Do you want to Play ALL Songs ? ";
		
		switch(MusicPlayerUtil.getOptionFromUser(opt1, scanner)) {
			case 1 : 
					 String opt2 = " Please enter the Song Number (from the above list) you want me to Play ...";
					 MusicPlayerUtil.playPerticularSong(MusicPlayerUtil.getOptionFromUser(opt2,scanner) );
					 break;
					 
			case 2 : MusicPlayerUtil.playAllSongs(scanner);
					 break;
		}//End of switch
	
	}//End of Main
	
}//End of Class
