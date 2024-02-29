package org.example;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = "E:\\Editing\\Qz. Pchelina - 21-01-2024\\Music\\Nine Lives - Unicorn Heads.wav";

        Main player = new Main();
        player.playMusic(filePath);
    }

    public void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);
            clip.start();

            System.out.println("Playing music. Press enter to stop.");
            new Scanner(System.in).nextLine();  // Wait for user input
            clip.stop();
            clip.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}