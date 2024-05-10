package A_Card_Game;
/*
    Description: handle the game play
*/

public class Game {
    ActionHandler aHandler = new ActionHandler(this);
    UI ui = new UI(this);

    public Game(){}

    //change in frontend of menu, rule, guide, and game play
    private void statusMenu(boolean status){
        ui.menu_canvas.setVisible(status);
        ui.guideButton.setVisible(status);
        ui.ruleButton.setVisible(status);
        ui.startButton.setVisible(status);
    }
    
    private void statusGuide(boolean status){
        ui.guide_canvas.setVisible(status);
        ui.backGuideButton.setVisible(status);
    }

    private void statusRule(boolean status){
        ui.rule_canvas.setVisible(status);
        ui.backRuleButton.setVisible(status);
    }
    
    public void menuToRule(){
        statusMenu(false); //turn off menu screen
        statusRule(true); //turn on rule screen
    }

    public void menuToGuide(){
        statusMenu(false); //turn off menu screen
        statusGuide(true); //turn on guide screen
    }

    public void backtoMenu(){
        statusGuide(false); //turn off guide screen
        statusRule(false); //turn off rule screen
        statusMenu(true); //turn on menu screen
    }
    
    public void menuToGame() throws Exception{
        ui.dispose(); //turn off menu screen
        PlayPage.startGame(); //turn on game screen
    }

}
