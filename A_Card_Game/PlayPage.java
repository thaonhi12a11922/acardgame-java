package A_Card_Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import A_Card_Game.Function.draw_random;
import A_Card_Game.Function.get_card_infor;

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
    static JLabel result_text;

    // call random funtion
    static draw_random randomFunction = new draw_random();
    static get_card_infor hand = new get_card_infor();

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
        final int[] clickCount = { 0 };
        bet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String[] middle_cards = randomFunction.middle_list;
                // take best combination between middle card and first card
                for (String middle_card : randomFunction.card_1) {
                    System.out.println(middle_card);
                }

                String[] best_combination_1 = hand.best_combination_cards(randomFunction.card_1, middle_cards);
                String[] best_combination_2 = hand.best_combination_cards(randomFunction.card_2, middle_cards);

                hand.setHand(best_combination_1);
                get_card_infor best_hand2_infor = new get_card_infor();
                best_hand2_infor.setHand(best_combination_2);
                int result = hand.compare_to(best_hand2_infor);
                String result_;
                // Printing the result
                if (result > 0) {
                    result_ = "You win!";
                } else if (result < 0) {
                    result_ = "You lose!";
                } else {
                    result_ = "It's a tie!";
                }

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

                            Timer timer = new Timer(5000, event -> {
                                // Code to execute after 20 seconds
                                fifth_card.setVisible(false);
                                second_card.setVisible(false);
                                third_card.setVisible(false);
                                fourth_card.setVisible(false);
                                first_card.setVisible(false);
                                // Create a new JLabel for game result
                                result_text = new JLabel("Game Result"); // Center-align the text
                                buttonFrame.add(result_text);
                                System.out.println(result_);
                                result_text.setText(result_);
                                result_text.setFont(new Font("Tahoma", Font.BOLD, 18));
                                result_text.setEnabled(true);
                                result_text.setVisible(true);

                            });

                            timer.setRepeats(false); // Set to execute only once
                            timer.start(); // Start the timer

                            // Frame of the result

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

}
