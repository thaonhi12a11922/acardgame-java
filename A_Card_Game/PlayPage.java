package A_Card_Game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import A_Card_Game.Function.draw_random;


public class PlayPage {
    static JLabel p1_first_card = new JLabel();
    static JLabel p1_second_card = new JLabel();

    static JLabel p2_first_card = new JLabel();
    static JLabel p2_second_card = new JLabel();

    static JLabel first_card = new JLabel();
    static JLabel second_card = new JLabel();
    static JLabel third_card = new JLabel();
    static JLabel fourth_card = new JLabel();
    static JLabel fifth_card = new JLabel();

    // call random funtion
    static draw_random randomFunction = new draw_random();
    
    public static void startGame() throws Exception {
        // define random function
        randomFunction.getRandomCards();

        MyFrame myFrame = new MyFrame();
        myFrame.getContentPane().setBackground(new Color(26, 145, 85));

        JPanel round = createRoundPanel();
        myFrame.add(round);

        JPanel player2 = createPlayer2Panel();
        myFrame.add(player2);

        JPanel player1 = createPlayer1Panel();
        myFrame.add(player1);

        JPanel fiveCards = createFiveCards();
        myFrame.add(fiveCards);

        JPanel buttonFrame = createButtonFrame();
        myFrame.add(buttonFrame);

        // JPanel middleFrame = createMiddleFrame();
        // myFrame.add(middleFrame);

        myFrame.setVisible(true);
    }
    private static JPanel createRoundPanel() throws Exception {
        JPanel round = new JPanel(new BorderLayout());
        round.setBackground(new Color(1, 2, 2, 200));

        JLabel roundText = new JLabel("Round 1", JLabel.CENTER);
        roundText.setForeground(Color.WHITE);

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

        // Get the name of two cards of Player 2
        String player2_card1 = randomFunction.card_2[0]; 
        String player2_card2 = randomFunction.card_2[1]; 


        JLabel p2_name = new JLabel("Player 2", JLabel.CENTER);
        p2_name.setForeground(Color.WHITE);

        p2_name.setFont(new Font("Tahoma", Font.BOLD, 18));

        JLabel p2_score = new JLabel("$800", JLabel.CENTER);
        p2_score.setForeground(Color.WHITE);
        p2_score.setFont(new Font("Tahoma", Font.BOLD, 18));

        JPanel p2_info = new JPanel(new GridLayout(2, 1));
        p2_info.setBackground(new Color(0, 0, 0, 0));
        p2_info.setBounds(0, 0, 500, 170);
        p2_info.add(p2_name);
        p2_info.add(p2_score);

        player2.add(p2_info);
        return player2;
    }
    private static JPanel createPlayer1Panel() throws Exception {
        // ImageIcon white_card = new ImageIcon("A_Card_Game/Img/white_card.png");
        JPanel player1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player1.setBounds(476, 600, 1000, 170);
        player1.setBackground(new Color(26, 145, 85));
                
        // Get the first two cards of You - Player 1
        String player1_card1 = randomFunction.card_1[0]; 
        String player1_card2 = randomFunction.card_1[1]; 
        p1_first_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + player1_card1 + ".png"));
        p1_second_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + player1_card2 + ".png"));

        // p1_first_card.setIcon(white_card);
        // p1_second_card.setIcon(white_card);

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
    private static JPanel createFiveCards() throws Exception {
        ImageIcon red_card = new ImageIcon("A_Card_Game/Img/red_card.png");
        JPanel fiveCards = new JPanel();
        fiveCards.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 0));
        fiveCards.setBounds(276, 329, 1003, 159);
        fiveCards.setBackground(new Color(26, 145, 85));

        first_card.setIcon(red_card);
        second_card.setIcon(red_card);
        third_card.setIcon(red_card);
        fourth_card.setIcon(red_card);
        fifth_card.setIcon(red_card);

        fiveCards.add(first_card);
        fiveCards.add(second_card);
        fiveCards.add(third_card);
        fiveCards.add(fourth_card);
        fiveCards.add(fifth_card);

        return fiveCards;
    }
    private static JPanel createButtonFrame() throws Exception {
        JPanel buttonFrame = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        buttonFrame.setBounds(496, 530, 200, 170);
        buttonFrame.setBackground(new Color(26, 145, 85));

        JButton bet = new JButton("BET");
        bet.setFont(new Font("Tahoma", Font.BOLD, 18));
        bet.setEnabled(true);

        // Initialize a counter for the number of clicks
        final int[] clickCount = {0};
        bet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String[] middle_cards = randomFunction.middle_list;
        
                // Check if the click count is less than the number of cards
                if (clickCount[0] < middle_cards.length) {
                    // Use a switch statement to set the icon for the correct card
                    switch (clickCount[0]) {
                        case 0:
                            first_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + middle_cards[0] + ".png"));
                            second_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + middle_cards[1] + ".png"));
                            third_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + middle_cards[2] + ".png"));
                            break;
                        case 1:
                            fourth_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + middle_cards[3] + ".png"));
                            break;
                        case 2:
                            fifth_card.setIcon(new ImageIcon("A_Card_Game/Card Image/" + middle_cards[4] + ".png"));
                            break;
                    }
        
                    clickCount[0]++;
                }
            }
        });
        buttonFrame.add(bet);
        return buttonFrame;
    }
    private static JPanel createMiddleFrame() throws Exception {
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());
        centralPanel.setBounds(232, 220, 820, 378);
        centralPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel centralIMG = new JLabel();
        centralIMG.setIcon(new ImageIcon("A_Card_Game/Img/rounded_edge_rect.png"));

        centralPanel.add(centralIMG);

        centralPanel.setVisible(true);

        return centralPanel;
    }

    // public static void main(String[] args) throws Exception{

    //     MyFrame myFrame = new MyFrame();
        
    //     myFrame.getContentPane().setBackground(new Color(26, 145, 85));
        
    //     //Round title
    //     JPanel round = new JPanel();
    //     round.setLayout(new BorderLayout());
    //     round.setBackground(new Color(0, 0, 0, 0));

    //     JLabel roundText = new JLabel();
    //     roundText.setBackground(new Color(0, 0, 0, 0));
    //     roundText.setText("Round 1");
    //     roundText.setHorizontalAlignment(JLabel.CENTER);
    //     roundText.setVerticalAlignment(JLabel.CENTER);
    //     roundText.setForeground(Color.WHITE);
    //     File fontFile = new File("A_Card_Game/Fonts/Moul-Regular.ttf");
    //     Font roundFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    //     roundFont = roundFont.deriveFont(Font.PLAIN, 48);
    //     roundText.setFont(roundFont);

    //     round.add(roundText, BorderLayout.CENTER);
    //     round.setBounds(42, 22, 216, 87);

    //     myFrame.add(round);

    //     ImageIcon red_card = new ImageIcon("A_Card_Game/Img/red_card.png");
    //     ImageIcon white_card = new ImageIcon("A_Card_Game/Img/white_card.png");
        
    //     //Player 2
    //     JPanel player2 = new JPanel();
    //     player2.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
    //     player2.setBounds(476, 30, 1000, 170);
    //     player2.setBackground(new Color(26, 145, 85));

    //     JLabel p2_first_card = new JLabel();
    //     p2_first_card.setIcon(red_card);
    //     p2_first_card.setBounds(476, 30, 119, 159);

    //     JLabel p2_second_card = new JLabel();
    //     p2_second_card.setIcon(red_card);
    //     p2_second_card.setBounds(648, 30, 119, 159);

    //     player2.add(p2_first_card);
    //     player2.add(p2_second_card);

    //     JLabel p2_name = new JLabel();
    //     p2_name.setText("Player 2");
    //     p2_name.setForeground(Color.WHITE);

    //     Font nameFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    //     nameFont = nameFont.deriveFont(Font.PLAIN, 22);
    //     p2_name.setFont(nameFont);

    //     JLabel p2_score = new JLabel();
    //     p2_score.setText("$800");
    //     p2_score.setForeground(Color.WHITE);
    //     p2_score.setFont(nameFont);
    //     p2_score.setHorizontalAlignment(JLabel.CENTER);

    //     JPanel p2_info = new JPanel();
    //     p2_info.setBackground(new Color(0, 0, 0, 0));
    //     p2_info.setBounds(0, 0, 500, 170);
    //     p2_info.setLayout(new GridLayout(2, 1));

    //     p2_info.add(p2_name);
    //     p2_info.add(p2_score);

    //     player2.add(p2_info);

    //     myFrame.add(player2);

    //     // Play 1 - you
    //     JPanel player1 = new JPanel();
    //     player1.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
    //     player1.setBounds(476, 620, 1000, 170);
    //     player1.setBackground(new Color(26, 145, 85));

    //     // JLabel p1_first_card = new JLabel();
    //     p1_first_card.setIcon(white_card);
    //     p1_first_card.setBounds(476, 600, 119, 159);

    //     // JLabel p1_second_card = new JLabel();
    //     p1_second_card.setIcon(white_card);
    //     p1_second_card.setBounds(648, 600, 119, 159);

    //     player1.add(p1_first_card);
    //     player1.add(p1_second_card);

    //     JLabel p1_name = new JLabel();
    //     p1_name.setText("You - Player 1");
    //     p1_name.setForeground(Color.WHITE);
    //     p1_name.setFont(nameFont);

    //     JLabel p1_score = new JLabel();
    //     p1_score.setText("$1000");
    //     p1_score.setForeground(Color.WHITE);
    //     p1_score.setFont(nameFont);
    //     p1_score.setHorizontalAlignment(JLabel.CENTER);

    //     JPanel p1_info = new JPanel();
    //     p1_info.setBackground(new Color(0, 0, 0, 0));
    //     p1_info.setBounds(0, 0, 500, 170);
    //     p1_info.setLayout(new GridLayout(2, 1));

    //     p1_info.add(p1_name);
    //     p1_info.add(p1_score);

    //     player1.add(p1_info);

    //     myFrame.add(player1);
        
    //     // Button frame
    //     JPanel buttonFrame = new JPanel();
    //     buttonFrame.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 0));
    //     buttonFrame.setBounds(496, 530, 200, 170);
    //     buttonFrame.setBackground(new Color(0, 0, 0, 0));

    //     JButton bet = new JButton("BET");
    //     bet.setFont(nameFont);
    //     bet.setEnabled(true);
    //     bet.addActionListener(new Bet());

    //     buttonFrame.add(bet);
    //     myFrame.add(buttonFrame);

    //     //The rectangle in the middle of the screen

    //     JPanel centralPanel = new JPanel();
    //     centralPanel.setLayout(new BorderLayout());
    //     centralPanel.setBounds(232, 220, 820, 378);
    //     centralPanel.setBackground(new Color(0, 0, 0, 0));

    //     JLabel centralIMG = new JLabel();
    //     centralIMG.setIcon(new ImageIcon("A_Card_Game/Img/rounded_edge_rect.png"));

    //     centralPanel.add(centralIMG);

    //     centralPanel.setVisible(true);

    //     myFrame.add(centralPanel);

    //     //five cards
    //     JPanel fiveCards = new JPanel();
    //     fiveCards.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 0));
    //     fiveCards.setBounds(276, 329, 1003, 159);
    //     fiveCards.setBackground(new Color(26, 145, 85));

    //     JLabel first_card = new JLabel();
    //     first_card.setIcon(red_card);
    //     JLabel second_card = new JLabel();
    //     second_card.setIcon(red_card);
    //     JLabel third_card = new JLabel();
    //     third_card.setIcon(red_card);
    //     JLabel fourth_card = new JLabel();
    //     fourth_card.setIcon(red_card);
    //     JLabel fifth_card = new JLabel();
    //     fifth_card.setIcon(red_card);

    //     fiveCards.add(first_card);
    //     fiveCards.add(second_card);
    //     fiveCards.add(third_card);
    //     fiveCards.add(fourth_card);
    //     fiveCards.add(fifth_card);

    //     myFrame.add(fiveCards);


    //     myFrame.setVisible(true);
        
    // }

    // private static class Bet implements ActionListener{
	// 	@Override
	// 	public void actionPerformed(ActionEvent arg0) {
    //         draw_random random = new draw_random();
    //         random.getRandomCards();

    //         // Get the first two cards of You - Player 1
    //         String player1_card1 = random.card_1[0]; 
    //         String player1_card2 = random.card_1[1]; 

    //         // Get the first two cards of Player 2
    //         String player2_card1 = random.card_2[0];
    //         String player2_card2 = random.card_2[1];

    //         // Get five random cards
    //         String middle_card1 = random.middle_list[0];
    //         String middle_card2 = random.middle_list[1];
    //         String middle_card3 = random.middle_list[2];
    //         String middle_card4 = random.middle_list[3];
    //         String middle_card5 = random.middle_list[4];
    
    //         String imagePath1 = "A_Card_Game/Card Image/" + player1_card1 + ".png";
    //         String imagePath2 = "A_Card_Game/Card Image/" + player1_card2 + ".png";


    //         ImageIcon new_card1 = new ImageIcon(imagePath1);
    //         ImageIcon new_card2 = new ImageIcon(imagePath2);
    //         p1_first_card.setIcon(new_card1);
    //         p1_first_card.setBounds(476, 600, 119, 159);
    //         p1_second_card.setIcon(new_card2);
    //         p1_second_card.setBounds(476, 30, 119, 159);            
			
	// 	}
		
	// }
}
