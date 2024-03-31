package interfaceandpackages;

import java.util.Scanner;

public interface Playable {
    void play();

    void pause();

    void stop();
}

class MP3Player implements Playable {
    public void play() {
        System.out.println("\t\t\tMp3 player playing");
    }

    public void pause() {
        System.out.println("\t\t\tMp3 player pause");
    }

    public void stop() {
        System.out.println("\t\t\tMp3 player stops");
    }
}

class CDPlayer implements Playable {
    public void play() {
        System.out.println("\t\t\tCD player playing");
    }

    public void pause() {
        System.out.println("\t\t\tCD player pause");
    }

    public void stop() {
        System.out.println("\t\t\tCD player stops");
    }
}

class StreamingPlayer implements Playable {
    public void play() {
        System.out.println("\t\t\tStreaming player playing");
    }

    public void pause() {
        System.out.println("\t\t\tStreaming player pause");
    }

    public void stop() {
        System.out.println("\t\t\tStreaming player stops");
    }
}

class Model {
    Scanner scanner = new Scanner(System.in);

    void init() {
        while (true) {
            System.out.println("1.MP3 player\n2.CD player\n3.Streaming player\n4.Exit\nEnter the choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    func(new MP3Player());
                    break;
                case 2:
                    func(new CDPlayer());
                    break;
                case 3:
                    func(new StreamingPlayer());
                    break;
                case 4:
                    System.out.println("\t\t\tThank you");
                    break;
                default:
                    System.out.println("\t\t\tInvalid choice ,Enter valid choice");
            }
            if (choice == 4)
                break;
        }
    }

    void func(Playable playable) {
        while (true) {
            System.out.println("1.Play\n2.Pause\n3.Stop\n4.Back to previos page\nEnter the choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playable.play();
                    break;
                case 2:
                    playable.pause();
                    break;
                case 3:
                    playable.stop();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\t\t\tInvalid choice ,Enter valid choice");
            }
            if (choice == 4)
                break;
        }
    }
}

class PlayableDriver {
    public static void main(String[] args) {
        new Model().init();
    }
}
