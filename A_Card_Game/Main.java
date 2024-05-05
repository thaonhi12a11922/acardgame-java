package A_Card_Game;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Test.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
