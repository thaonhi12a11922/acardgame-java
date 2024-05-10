package A_Card_Game;
/*
    Description: handle all UI extends JFrame
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton extends JButton{
    String text;
    int x, y;
    Game game;
    Font customFont;

    public MyButton(String text, int x, int y){
        this.setText(text);
        this.setBounds(x, y, 200, 50);
        this.setBorder(null);
        this.setBackground(new Color(159,0,0));
        this.setFocusPainted(false);
        this.setForeground(Color.black);
        this.setVisible(false);
        
        this.setActionCommand(text);

        //add new font
        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("A_Card_Game/Fonts/horizon.otf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        //set font to the text
        this.setFont(customFont);
    }   
}

public class UI extends JFrame{
    //Menu screen
    JButton startButton, ruleButton, backRuleButton, backGuideButton, guideButton;
    PaintPanel menu_canvas, rule_canvas, guide_canvas, stage_canvas;
    
    Game game;
    
    public UI(Game game){
        this.game = game;
        this.setTitle("Poker hand");
        this.setSize(1280,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);

        ImageIcon icon_image = new ImageIcon("A_Card_Game/IMAGE/icon.png"); // create an imageicon
        this.setIconImage(icon_image.getImage()); // change the default icon into new icon
        
        createMenu();
        createRule();
        createGuide();
        createPlayPage();
        
        this.setVisible(true);

    }

    private void createMenu() {
        menu_canvas = new PaintPanel(this, "menu.png");
        menu_canvas.setBounds(0,0,1280,800);
        menu_canvas.setOpaque(true); // allow orride the background image
        this.add(menu_canvas);

        startButton = new MyButton("START", 520, 450);
        startButton.addActionListener(game.aHandler);

        ruleButton = new MyButton("RULE", 520, 500 + 20);
        ruleButton.addActionListener(game.aHandler);

        guideButton = new MyButton("GUIDE", 520, 550 + 40);
        guideButton.addActionListener(game.aHandler);

        startButton.setVisible(true);
        ruleButton.setVisible(true);
        guideButton.setVisible(true);
        
        this.add(startButton);
        this.add(ruleButton);
        this.add(guideButton);
    }

    private void createRule(){
        rule_canvas = new PaintPanel(this, "rule.png");
        rule_canvas.setBounds(0,0,1280,800);
        rule_canvas.setOpaque(true); // allow orride the background image
        this.add(rule_canvas);
        
        backRuleButton = new MyButton("BACK", 70, 34*2 - 8);
        backRuleButton.addActionListener(game.aHandler);
        this.add(backRuleButton);
    }

    private void createGuide(){
        guide_canvas = new PaintPanel(this, "guide.png");
        guide_canvas.setBounds(0,0,1280,800);
        guide_canvas.setOpaque(true); // allow orride the background image
        this.add(guide_canvas);

        backGuideButton = new MyButton("BACK", 70, 34*2 - 8);
        backGuideButton.addActionListener(game.aHandler);
        this.add(backGuideButton);
    }

    private void createPlayPage(){
        // menu_canvas = new PaintPanel(this, "menu.png");
        // menu_canvas.setBounds(0,0,1280,800);
        // menu_canvas.setOpaque(false);
        // this.add(menu_canvas);
    }

}
