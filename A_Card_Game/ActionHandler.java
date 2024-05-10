package A_Card_Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    Game game;

    public ActionHandler(Game game){
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);

        switch (command) {
            case "START":
                try {
                    game.menuToGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "RULE":
                game.menuToRule();
            case "GUIDE":
                game.menuToGuide();
                break;
            case "BACK":
                game.backtoMenu();
                break;
            default:
                break;
        }
    }

}
