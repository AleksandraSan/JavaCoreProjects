package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData app = new AppData();
        app.load("homework5.txt");
        System.out.println(Arrays.toString(app.getHeader()));
        System.out.println(Arrays.deepToString(app.getData()));
        app.saveFile("homework5.txt");
    }
}
