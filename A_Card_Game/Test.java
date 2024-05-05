package A_Card_Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import A_Card_Game.Graphics.RoundedPanel;
import A_Card_Game.Function.draw_random;

public class Test {
    static JLabel p1_first_card = new JLabel();
    static JLabel p1_second_card = new JLabel();

    public static void startGame() throws Exception {
        MyFrame myFrame = new MyFrame();
        myFrame.getContentPane().setBackground(new Color(26, 145, 85));

        JPanel round = createRoundPanel();
        myFrame.add(round);

        JPanel player2 = createPlayer2Panel();
        myFrame.add(player2);

        JPanel player1 = createPlayer1Panel();
        myFrame.add(player1);

        JPanel buttonFrame = createButtonFrame();
        myFrame.add(buttonFrame);

        JPanel mainSection = new JPanel();
        mainSection.setBounds(233, 200, 820, 400);
        mainSection.setBackground(new Color(26, 145, 85));
        myFrame.add(mainSection);

        myFrame.setVisible(true);
    }

    private static JPanel createRoundPanel() throws Exception {
        JPanel round = new JPanel(new BorderLayout());
        round.setBackground(new Color(1, 2, 2, 200));

        JLabel roundText = new JLabel("Round 1", JLabel.CENTER);
        roundText.setForeground(Color.WHITE);
        // File fontFile = new File("Fonts/Moul-Regular.ttf");
        // Font roundFont = Font.createFont(Font.TRUETYPE_FONT,
        // fontFile).deriveFont(Font.PLAIN, 48);
        roundText.setFont(new Font("Tahoma", Font.BOLD, 18));

        round.add(roundText, BorderLayout.CENTER);
        round.setBounds(42, 22, 216, 87);
        return round;
    }

    private static JPanel createPlayer2Panel() throws Exception {
        ImageIcon red_card = new ImageIcon("A_Card_Game/Img/red_card.png");
        JPanel player2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player2.setBounds(476, 30, 1000, 170);
        player2.setBackground(new Color(26, 145, 85));

        JLabel p2_first_card = new JLabel(red_card);
        JLabel p2_second_card = new JLabel(red_card);
        player2.add(p2_first_card);
        player2.add(p2_second_card);

        JLabel p2_name = new JLabel("Player 2", JLabel.CENTER);
        p2_name.setForeground(Color.WHITE);

        p2_name.setFont(new Font("Tahoma", Font.BOLD, 18));

        JLabel p2_score = new JLabel("$800", JLabel.CENTER);
        p2_score.setForeground(Color.WHITE);
        p2_score.setFont(new Font("Tahoma", Font.BOLD, 18));

        JPanel p2_info = new JPanel(new GridLayout(2, 1));
        p2_info.setBackground(new Color(0, 0, 0, 0));
        p2_info.add(p2_name);
        p2_info.add(p2_score);

        player2.add(p2_info);
        return player2;
    }

    private static JPanel createPlayer1Panel() throws Exception {
        ImageIcon white_card = new ImageIcon("A_Card_Game/Img/white_card.png");
        JPanel player1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player1.setBounds(476, 600, 1000, 170);
        player1.setBackground(new Color(26, 145, 85));

        p1_first_card.setIcon(white_card);
        p1_second_card.setIcon(white_card);

        player1.add(p1_first_card);
        player1.add(p1_second_card);

        JLabel p1_name = new JLabel("You - Player 1", JLabel.CENTER);
        p1_name.setForeground(Color.WHITE);

        Font nameFont = new Font("Tahoma", Font.BOLD, 18);
        p1_name.setFont(nameFont);

        JLabel p1_score = new JLabel("$1000", JLabel.CENTER);
        p1_score.setForeground(Color.WHITE);
        p1_score.setFont(nameFont);

        JPanel p1_info = new JPanel(new GridLayout(2, 1));
        p1_info.setBackground(new Color(0, 0, 0, 0));
        p1_info.add(p1_name);
        p1_info.add(p1_score);

        player1.add(p1_info);
        return player1;
    }

    private static JPanel createButtonFrame() throws Exception {
        JPanel buttonFrame = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        buttonFrame.setBounds(476, 200, 1000, 170);
        buttonFrame.setBackground(new Color(26, 145, 85));

        JButton bet = new JButton("BET");
        bet.setFont(new Font("Tahoma", Font.BOLD, 18));
        bet.setEnabled(true);
        bet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_random random = new draw_random();
                random.getRandomCards();
                String card1 = random.card_1[0]; // get the first card
                String card2 = random.card_1[1]; // get the second card
                System.out.println(card1);

                ImageIcon new_card1 = new ImageIcon("A_Card_Game/Card Image/" + card1 + ".png");
                ImageIcon new_card2 = new ImageIcon("A_Card_Game/Card Image/" + card2 + ".png");
                System.out.println(new_card1);
                p1_first_card.setIcon(new_card1);
                p1_second_card.setIcon(new_card2);
            }
        });

        buttonFrame.add(bet);
        return buttonFrame;
    }
}
