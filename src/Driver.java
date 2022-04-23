import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class Driver {
	
	private static final String TITLE_1 = "Am I the Same Girl?";
	private static final String ARTIST_1 = "Barbara Acklin";
	private static final int[] TIME_1 = {56, 2};
	private static final Song SONG_1 = new Song(TITLE_1, ARTIST_1, TIME_1);
	
	private static final String TITLE_2 = "Kissing My Love";
	private static final String ARTIST_2 = "Bill Withers";
	private static final int[] TIME_2 = {49, 3};
	private static final Song SONG_2 = new Song(TITLE_2, ARTIST_2, TIME_2);
	
	private static final String TITLE_3 = "Feelin' Alright?";
	private static final String ARTIST_3 = "Joe Cocker";
	private static final int[] TIME_3 = {10, 4};
	private static final Song SONG_3 = new Song(TITLE_3, ARTIST_3, TIME_3);
	
	private static final String TITLE_4 = "Lean on Me";
	private static final String ARTIST_4 = "Bill Withers";
	private static final int[] TIME_4 = {17, 4};
	private static final Song SONG_4 = new Song(TITLE_4, ARTIST_4, TIME_4);
	
	private static final String TITLE_5 = "Little Wing";
	private static final String ARTIST_5 = "Stevie Ray Vaughan";
	private static final int[] TIME_5 = {49, 6};
	private static final Song SONG_5 = new Song(TITLE_5, ARTIST_5, TIME_5);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playlist playlist = new Playlist();
		
		playlist.addSong(SONG_1);
		playlist.addSong(SONG_2);
		playlist.addSong(SONG_3);
		
		System.out.println(playlist.getCapacity());
		System.out.println(playlist.getNumSongs());
		System.out.println(playlist.removeSong());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static boolean sameSong(Song song1, Song song2) {
		
		// Check that the titles are the same.
		String title1 = song1.getTitle();
		String title2 = song2.getTitle();
		if (!title1.equals(title2)) {
			return false;
		}
		
		// Check that the artists are the same.
		String artist1 = song1.getArtist();
		String artist2 = song2.getArtist();
		if (!artist1.equals(artist2)) {
			return false;
		}
		
		// Check that the times are the same (both length and elements).
		int[] time1 = song1.getDuration();	
		int[] time2 = song2.getDuration();
		if (time1.length != time2.length) {
			return false;
		}
		for (int idx = 0; idx < time1.length; ++idx) {
			if (time1[idx] != time2[idx]) {
				return false;
			}
		}
		
		// All the fields are the same, so song1 and song2 are the same Song.
		return true;
	}
	
private static boolean sameSongs(Song[] songs1, Song[] songs2) {
		
		// Check that the lengths are the same.
		if (songs1.length != songs2.length) {
			return false;
		}
		
		// Check that the corresponding elements are the same.
		for (int idx = 0; idx < songs1.length; ++idx) {
			if (!sameSong(songs1[idx], songs2[idx])) {
				return false;
			}
		}
		
		return true;
	}

}
