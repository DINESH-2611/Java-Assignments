package Collections;

import java.util.LinkedList;

public class PlayListManagerLinkedList {
    private LinkedList<String> playlist;

    public PlayListManagerLinkedList() {
        playlist = new LinkedList<>();
    }
    public void addSong(String song) {
        playlist.add(song);
    }
    public void removeSong(String song) {
        playlist.remove(song);
    }
    public void moveSong(String song, int newPosition) {
        playlist.remove(song);
        playlist.add(newPosition, song);
    }
    public String playNextSong() {
        return playlist.poll();
    }

    public void displayPlaylist() {
        System.out.println("Current Playlist:");
        for (String song : playlist) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        PlayListManagerLinkedList manager = new PlayListManagerLinkedList();
        manager.addSong("Shape of You - Ed Sheeran");
        manager.addSong("Believer - Imagine Dragons");
        manager.addSong("Havana - Camila Cabello");
        manager.displayPlaylist();
        manager.moveSong("Believer - Imagine Dragons", 0);
        manager.removeSong("Havana - Camila Cabello");
        manager.displayPlaylist();
        System.out.println("Now playing: " + manager.playNextSong());
    }
}
