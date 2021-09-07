package arrays.practice;

import java.util.Random;

public class ShuffleSong {

    private static void shuffle(String[] songs) {
        int n = songs.length;
        int i = 0;
        while (i < n) {
            int r = new Random().nextInt(n-i) + i;
            String song = songs[r];
            System.out.println(song);
            String t = songs[r];
            songs[r] = songs[i];
            songs[i] = t;
            i++;
        }
    }

    public static void main(String[] args) {
        String[] songs = {"a", "b", "c", "d"};
        shuffle(songs);
    }
}
