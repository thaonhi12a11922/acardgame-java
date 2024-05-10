package A_Card_Game;
public class Main {
    public static void main(String[] args) throws Exception{
        // new Game();
        try {
            PlayPage.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}