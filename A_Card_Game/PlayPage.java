package A_Card_Game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import A_Card_Game.Function.draw_random;


public class PlayPage {
    static JLabel p1_first_card = new JLabel();
    static JLabel p1_second_card = new JLabel();
    public static void main(String[] args) throws Exception{

        MyFrame myFrame = new MyFrame();
        
        myFrame.getContentPane().setBackground(new Color(26, 145, 85));
        
        //Round title
        JPanel round = new JPanel();
        round.setLayout(new BorderLayout());
        round.setBackground(new Color(0, 0, 0, 0));

        JLabel roundText = new JLabel();
        roundText.setBackground(new Color(0, 0, 0, 0));
        roundText.setText("Round 1");
        roundText.setHorizontalAlignment(JLabel.CENTER);
        roundText.setVerticalAlignment(JLabel.CENTER);
        roundText.setForeground(Color.WHITE);
        File fontFile = new File("A_Card_Game/Fonts/Moul-Regular.ttf");
        Font roundFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        roundFont = roundFont.deriveFont(Font.PLAIN, 48);
        roundText.setFont(roundFont);

        round.add(roundText, BorderLayout.CENTER);
        round.setBounds(42, 22, 216, 87);

        myFrame.add(round);

        ImageIcon red_card = new ImageIcon("A_Card_Game/Img/red_card.png");
        ImageIcon white_card = new ImageIcon("A_Card_Game/Img/white_card.png");
        
        //Player 2
        JPanel player2 = new JPanel();
        player2.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player2.setBounds(476, 30, 1000, 170);
        player2.setBackground(new Color(26, 145, 85));

        JLabel p2_first_card = new JLabel();
        p2_first_card.setIcon(red_card);
        p2_first_card.setBounds(476, 30, 119, 159);

        JLabel p2_second_card = new JLabel();
        p2_second_card.setIcon(red_card);
        p2_second_card.setBounds(648, 30, 119, 159);

        player2.add(p2_first_card);
        player2.add(p2_second_card);

        JLabel p2_name = new JLabel();
        p2_name.setText("Player 2");
        p2_name.setForeground(Color.WHITE);

        Font nameFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        nameFont = nameFont.deriveFont(Font.PLAIN, 22);
        p2_name.setFont(nameFont);

        JLabel p2_score = new JLabel();
        p2_score.setText("$800");
        p2_score.setForeground(Color.WHITE);
        p2_score.setFont(nameFont);
        p2_score.setHorizontalAlignment(JLabel.CENTER);

        JPanel p2_info = new JPanel();
        p2_info.setBackground(new Color(0, 0, 0, 0));
        p2_info.setBounds(0, 0, 500, 170);
        p2_info.setLayout(new GridLayout(2, 1));

        p2_info.add(p2_name);
        p2_info.add(p2_score);

        player2.add(p2_info);

        myFrame.add(player2);

        //Play 1 - you
        JPanel player1 = new JPanel();
        player1.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player1.setBounds(476, 600, 1000, 170);
        player1.setBackground(new Color(26, 145, 85));

        // JLabel p1_first_card = new JLabel();
        p1_first_card.setIcon(white_card);
        p1_first_card.setBounds(476, 600, 119, 159);

        // JLabel p1_second_card = new JLabel();
        p1_second_card.setIcon(white_card);
        p1_second_card.setBounds(648, 600, 119, 159);

        player1.add(p1_first_card);
        player1.add(p1_second_card);

        JLabel p1_name = new JLabel();
        p1_name.setText("You - Player 1");
        p1_name.setForeground(Color.WHITE);
        p1_name.setFont(nameFont);

        JLabel p1_score = new JLabel();
        p1_score.setText("$1000");
        p1_score.setForeground(Color.WHITE);
        p1_score.setFont(nameFont);
        p1_score.setHorizontalAlignment(JLabel.CENTER);

        JPanel p1_info = new JPanel();
        p1_info.setBackground(new Color(0, 0, 0, 0));
        p1_info.setBounds(0, 0, 500, 170);
        p1_info.setLayout(new GridLayout(2, 1));

        p1_info.add(p1_name);
        p1_info.add(p1_score);

        player1.add(p1_info);

        myFrame.add(player1);

        ImageIcon border = new ImageIcon("A_Card_Game/Img/rounded_edge_rect.png");
        JLabel border_graphic = new JLabel();
        border_graphic.setIcon(border);

        JLabel pot = new JLabel();
        pot.setText("POT $250");
        pot.setHorizontalAlignment(JLabel.CENTER);
        pot.setVerticalAlignment(JLabel.CENTER);

        JPanel mainSection = new JPanel();
        mainSection.setBounds(233, 200, 820, 400);
        mainSection.setBackground(new Color(26, 145, 85));
        // Button frame
        JPanel buttonFrame = new JPanel();
        buttonFrame.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
        buttonFrame.setBounds(476, 200, 1000, 170);
        buttonFrame.setBackground(new Color(26, 145, 85));

        JButton bet = new JButton("BET");
        bet.setFont(nameFont);
        bet.setEnabled(true);
        bet.addActionListener(new Bet());

        buttonFrame.add(bet);
        myFrame.add(buttonFrame);

        myFrame.add(mainSection);

        myFrame.setVisible(true);
        
    }
    private static class Bet implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
            draw_random random = new draw_random();
            random.getRandomCards();
            String card1 = random.card_1[0]; // get the first card
            String card2 = random.card_1[1]; // get the second card
    
            String imagePath1 = "A_Card_Game/Card Image/" + card1 + ".png";
            String imagePath2 = "A_Card_Game/Card Image/" + card2 + ".png";
            System.out.println(imagePath1);
            System.out.println(imagePath2);

            ImageIcon new_card1 = new ImageIcon(imagePath1);
            ImageIcon new_card2 = new ImageIcon(imagePath2);
            p1_first_card.setIcon(new_card1);
            p1_first_card.setBounds(476, 600, 119, 159);
            p1_second_card.setIcon(new_card2);
            p1_second_card.setBounds(476, 30, 119, 159);            
			
		}
		
	}
}