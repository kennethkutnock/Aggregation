import java.util.Arrays;

public class Playlist {

	private Song[] songs;
	private int numSongs;
	private final static int MIN_CAPACITY = 3;
	private final static int EXPAND_THRESHOLD = 4;
	private int expandBy = 2;
	private int expandFrequency = 0;

	public Playlist() {
		songs = new Song[MIN_CAPACITY];
	}

	public Playlist(int capacity) {
		if (capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		}

		else {
			songs = new Song[capacity];
		}
	}

	public int getCapacity() {
		return songs.length;
	}

	public int getNumSongs() {
		return numSongs;
	}

	public Song getSong(int index) {
		if (index < 0 || index > numSongs - 1) {
			return null;
		}

		else {
			return songs[index];
		}
	}

	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	public boolean addSong(Song song) {
		return addSong(numSongs, song);
	}
	
	public void expand() {
		if (expandFrequency >= EXPAND_THRESHOLD) {
			expandBy = expandBy * 2;
		}
		expandFrequency = expandFrequency + 1;
		songs = Arrays.copyOf(songs, (songs.length + expandBy));
	}

	public boolean addSong(int index, Song song) {
		if (index < 0 || index > numSongs || song == null) {
			return false;
		} else {
			if (numSongs == songs.length) {
				expand();
			}

			for (int i = numSongs - 1; i >= index; --i) {
				songs[i + 1] = songs[i];
			}
			songs[index] = song;
			++numSongs;
			return true;
		}
	}

	public int addSongs(Playlist playlist) {
		if (playlist != null) {
			int a = playlist.getNumSongs();
			
			for(int i = 0; i < a; ++i)
			{
				if(playlist.getSong(i) != null) {
					addSong(playlist.getSong(i));
				}
			}
			return a;
		}
		return 0;
	}

	public Song removeSong() {
		return removeSong(numSongs-1);
	}

	public Song removeSong(int index) {
		if (songs == null || index > numSongs - 1 || index < 0 || numSongs == 0) {
			return null;
		}
			Song removedSong = songs[index];
			for (int i = index; i < numSongs -1; ++i) {
				songs[i] = songs[i + 1];
			}
			--numSongs;
			return removedSong;
	}

}
