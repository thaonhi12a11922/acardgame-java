package A_Card_Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import A_Card_Game.Function.draw_random;
import A_Card_Game.Function.get_card_infor;
// import button and win screen
import A_Card_Game.UI;

public class PlayPage {
    static Font customFont;
    static JPanel round;
    static JLabel roundText;

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

    public static ImageIcon add_image(String file_name) {
        ImageIcon image = new ImageIcon("A_Card_Game/Card Image/" + file_name + ".png");
        Image img = image.getImage();
        Image scaledImage = img.getScaledInstance(119, 159, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return scaledIcon;
    }

    public static void startGame() throws Exception {
        // define random function
        randomFunction.getRandomCards();

        MyFrame myFrame = new MyFrame();

        myFrame.getContentPane().setBackground(new Color(26, 145, 85));

        JPanel round = createRoundPanel();
        myFrame.add(round);

        JPanel player2 = createPlayer2Panel();
        myFrame.add(player2);

        JPanel middleFrame = createMiddleFrame();
        myFrame.add(middleFrame);

        JPanel player1 = createPlayer1Panel();
        myFrame.add(player1);

        JPanel fiveCards = createFiveCards();
        myFrame.add(fiveCards);

        JPanel buttonFrame = createButtonFrame();
        myFrame.add(buttonFrame);

        myFrame.setVisible(true);
    }

    private static JPanel createRoundPanel() throws Exception {
        round = new JPanel(new BorderLayout());
        round.setBackground(null);

        roundText = new JLabel("Round  1", JLabel.LEFT);
        roundText.setForeground(Color.WHITE);

        // add new font
        try {
            // create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("A_Card_Game/Fonts/Moul-Regular.ttf"))
                    .deriveFont(42f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        roundText.setFont(customFont);

        round.add(roundText, BorderLayout.CENTER);
        round.setBounds(40, 8, 350, 87);
        return round;
    }

    private static JPanel createPlayer2Panel() throws Exception {
        ImageIcon red_card = new ImageIcon("A_Card_Game/Img/red_card.png");

        JPanel player2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player2.setBounds(450, 30, 1000, 170);
        player2.setBackground(new Color(26, 145, 85));

        p2_first_card.setIcon(red_card);
        p2_second_card.setIcon(red_card);

        player2.add(p2_first_card);
        player2.add(p2_second_card);

        JLabel p2_name = new JLabel("Player 2", JLabel.CENTER);
        p2_name.setForeground(Color.WHITE);

        p2_name.setFont(new Font("Tahoma", Font.BOLD, 20));

        JLabel p2_score = new JLabel("$800", JLabel.CENTER);
        p2_score.setForeground(Color.WHITE);
        p2_score.setFont(new Font("Tahoma", Font.BOLD, 20));

        JPanel p2_info = new JPanel(new GridLayout(2, 1));
        p2_info.setBackground(new Color(0, 0, 0, 0));
        p2_info.setBounds(0, 0, 500, 170);
        p2_info.add(p2_name);
        p2_info.add(p2_score);

        player2.add(p2_info);
        return player2;
    }

    private static JPanel createPlayer1Panel() throws Exception {
        JPanel player1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 0));
        player1.setBounds(450, 590, 1000, 170);
        player1.setBackground(new Color(26, 145, 85));

        // Get the first two cards of You - Player 1
        String player1_card1 = randomFunction.card_1[0];
        String player1_card2 = randomFunction.card_1[1];

        p1_first_card.setIcon(add_image(player1_card1));
        p1_second_card.setIcon(add_image(player1_card2));

        player1.add(p1_first_card);
        player1.add(p1_second_card);

        JLabel p1_name = new JLabel("You - Player 1", JLabel.CENTER);
        p1_name.setForeground(Color.WHITE);

        Font nameFont = new Font("Tahoma", Font.BOLD, 20);
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
        fiveCards.setBounds(260, 280, 750, 159);
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
        JPanel buttonFrame = new JPanel(new FlowLayout(FlowLayout.LEADING, 55, 0));
        buttonFrame.setBounds(460, 480, 500, 100);
        buttonFrame.setBackground(new Color(26, 145, 85));

        // Add BET button
        JButton bet = new JButton("BET");
        bet.setFont(new Font("Tahoma", Font.BOLD, 30));
        bet.setBorder(null);
        bet.setBackground(new Color(159, 0, 0));
        bet.setPreferredSize(new Dimension(100, 50));
        bet.setForeground(Color.WHITE);
        bet.setFocusPainted(false);
        bet.setEnabled(true);
        bet.setOpaque(true);

        // Add FOLD button
        JButton fold = new JButton("FOLD");
        fold.setFont(new Font("Tahoma", Font.BOLD, 30));
        fold.setBorder(null);
        fold.setBackground(new Color(159, 0, 0));
        fold.setPreferredSize(new Dimension(100, 50));
        fold.setForeground(Color.WHITE);
        fold.setFocusPainted(false);
        fold.setEnabled(true);
        fold.setOpaque(true);

        // Initialize a counter for the number of clicks
        final int[] clickCount = { 0 };
        bet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the cards of Computer
                String[] cards_2 = randomFunction.card_2;
                // Get the middle list
                String[] middle_cards = randomFunction.middle_list;

                // take best combination between middle card and first card
                for (String middle_card : randomFunction.card_1) {
                    System.out.println(middle_card);
                }

                String[] best_combination_1 = hand.best_combination_cards(randomFunction.card_1, middle_cards);
                String[] best_combination_2 = hand.best_combination_cards(randomFunction.card_2, middle_cards);

                hand.setHand(best_combination_1);
                String hand1_category = hand.get_category_String();
                get_card_infor best_hand2_infor = new get_card_infor();
                best_hand2_infor.setHand(best_combination_2);
                String hand2_category = best_hand2_infor.get_category_String();
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
                            first_card.setIcon(add_image(middle_cards[0]));
                            second_card.setIcon(add_image(middle_cards[1]));
                            third_card.setIcon(add_image(middle_cards[2]));
                            roundText.setText("Round  2");
                            break;
                        case 1:
                            fourth_card.setIcon(add_image(middle_cards[3]));
                            roundText.setText("Round  3");
                            break;
                        case 2:
                            fifth_card.setIcon(add_image(middle_cards[4]));
                            roundText.setText("Round  4");
                            bet.setVisible(false);
                            fold.setVisible(false);

                            // Show up two cards of Computer
                            Timer timerCard = new Timer(2000, event -> {
                                p2_first_card.setIcon(add_image(cards_2[0]));
                                p2_second_card.setIcon(add_image(cards_2[1]));
                            });

                            timerCard.setRepeats(false); // Ensure the timer only runs once
                            timerCard.start(); // Start the timer

                            Timer timer1 = new Timer(5000, event -> {
                                // Code to execute after 20 seconds
                                fifth_card.setVisible(false);
                                second_card.setVisible(false);
                                third_card.setVisible(false);
                                fourth_card.setVisible(false);
                                first_card.setVisible(false);

                                JTextArea resultTextArea = new JTextArea();
                                resultTextArea.setEditable(false);
                                resultTextArea.setLineWrap(true);

                                JScrollPane scrollPane = new JScrollPane(resultTextArea);

                                String resultText = "Game Result:\n" +
                                        result_ + "\n" +
                                        "Hand 1 is " + hand1_category + "\n" +
                                        "Hand 2 is " + hand2_category + "\n";

                                resultTextArea.setText(resultText);
                                buttonFrame.add(scrollPane);
                                buttonFrame.setLocation(null);
                                resultTextArea.setVisible(true);

                            });

                            timer1.setRepeats(false); // Set to execute only once
                            timer1.start(); // Start the timer

                            // Frame of the result

                            Timer timer2 = new Timer(5000, event -> {

                            });

                            break;
                    }
                    clickCount[0]++;
                }
            }

        });

        buttonFrame.add(bet);
        buttonFrame.add(fold);
        return buttonFrame;
    }

    private static JPanel createMiddleFrame() throws Exception {
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());
        centralPanel.setBounds(232, 200, 820, 378);
        centralPanel.setBackground(new Color(0, 0, 0, 0));
        centralPanel.setOpaque(false);

        // scale down the image
        ImageIcon originalIcon = new ImageIcon("A_Card_Game/Img/rounded_edge_rect.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(820, 350, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel centralIMG = new JLabel();
        centralIMG.setIcon(scaledIcon);

        centralPanel.add(centralIMG);

        centralPanel.setVisible(true);

        return centralPanel;
    }
}
