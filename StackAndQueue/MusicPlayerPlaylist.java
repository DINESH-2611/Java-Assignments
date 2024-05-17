package StackAndQueue;

import java.util.LinkedList;

class Song {
    String title;
    String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}

public class MusicPlayerPlaylist {
    LinkedList<Song> playlist;
    Song currentSong;

    public MusicPlayerPlaylist() {
        playlist = new LinkedList<>();
        currentSong = null;
    }

    public void addSong(Song song) {
        playlist.add(song);
        if (currentSong == null) {
            currentSong = song;
        }
    }

    public void removeSong(Song song) {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        playlist.remove(song);
        if (currentSong == song) {
            if (!playlist.isEmpty()) {
                currentSong = playlist.getFirst();
            } else {
                currentSong = null;
            }
        }
    }

    public void playCurrentSong() {
        if (currentSong == null) {
            System.out.println("No song is currently selected.");
        } else {
            System.out.println("Playing: " + currentSong.title + " by " + currentSong.artist);
        }
    }

    public void skipToNextSong() {
        if (!playlist.isEmpty()) {
            int currentIndex = playlist.indexOf(currentSong);
            if (currentIndex != -1 && currentIndex < playlist.size() - 1) {
                currentSong = playlist.get(currentIndex + 1);
                System.out.println("Skipping to next song: " + currentSong.title);
            } else {
                System.out.println("No next song available.");
            }
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    public static void main(String[] args) {
        MusicPlayerPlaylist playlist = new MusicPlayerPlaylist();

        playlist.addSong(new Song("Song1", "Artist1"));
        playlist.addSong(new Song("Song2", "Artist2"));
        playlist.addSong(new Song("Song3", "Artist3"));

        playlist.playCurrentSong();

        playlist.skipToNextSong();

        playlist.removeSong(new Song("Song2", "Artist2"));

        playlist.playCurrentSong();
    }
}
