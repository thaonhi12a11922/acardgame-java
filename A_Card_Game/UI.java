package A_Card_Game;
/*
    Description: handle all UI extends JFrame
*/

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class UI extends JFrame {
    // Menu screen
    MyButton startButton, ruleButton, backRuleButton, backGuideButton, guideButton;
    PaintPanel menu_canvas, rule_canvas, guide_canvas, stage_canvas;

    Game game;

    public UI(Game game) {
        this.game = game;

        this.setTitle("Poker hand");
        this.setSize(1280, 800);
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
        
        this.setVisible(true);
    }

    private void createMenu() {
        menu_canvas = new PaintPanel(this, "menu.png");
        menu_canvas.setBounds(0,0,1280,800);
        menu_canvas.setOpaque(false); // allow orride the background image
        

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
        this.add(menu_canvas);
    }

    private void createRule() {
        rule_canvas = new PaintPanel(this, "rule.png");
        rule_canvas.setBounds(0,0,1280,800);
        rule_canvas.setOpaque(false); // allow orride the background image

        backRuleButton = new MyButton("BACK", 70, 34 * 2 - 8);
        backRuleButton.setForeground(Color.WHITE);
        backRuleButton.addActionListener(game.aHandler);
        this.add(backRuleButton);
        this.add(rule_canvas);
    }

    private void createGuide() {
        guide_canvas = new PaintPanel(this, "guide.png");
        guide_canvas.setBounds(0,0,1280,800);
        guide_canvas.setOpaque(true); // allow orride the background image
        

        backGuideButton = new MyButton("BACK", 70, 34 * 2 - 8);
        backRuleButton.setForeground(Color.WHITE);
        backGuideButton.addActionListener(game.aHandler);
        this.add(backGuideButton);
        this.add(guide_canvas);
    }
}
