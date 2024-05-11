package A_Card_Game;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YouLose extends JFrame {
    static Font customFont;
    static MyFrame myFrame = new MyFrame();
    public static void displayResult() throws Exception{

        myFrame.getContentPane().setBackground(new Color(26, 145, 85));
        // add Gameover frame
        JPanel textFrame = createText();
        myFrame.add(textFrame);
        // add button Frame
        JPanel buttonFrame = createButtonFrame();
        myFrame.add(buttonFrame);
        myFrame.setVisible(true);


    }
    private static JPanel createText() throws Exception {
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("A_Card_Game/Fonts/Moul-Regular.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel textFrame = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        textFrame.setBounds(300, 280, 750, 159);
        textFrame.setBackground(new Color(26, 145, 85));
                
        JLabel gameOverLabel = new JLabel("GAME OVER", JLabel.CENTER);
        gameOverLabel.setFont(customFont);
        gameOverLabel.setForeground(new Color(158, 39, 39));

        // JLabel youWinLabel = new JLabel("YOU WIN!!!", JLabel.CENTER);
        // youWinLabel.setFont(customFont);
        // youWinLabel.setForeground(new Color(243, 184, 184));

        // JLabel tieLabel = new JLabel("YOU TIE!!!", JLabel.CENTER);
        // tieLabel.setFont(customFont);
        // tieLabel.setForeground(Color.WHITE);

        textFrame.add(gameOverLabel);
        return textFrame;
    }
    private static JPanel createButtonFrame() throws Exception {
        JPanel buttonFrame = new JPanel();
        buttonFrame.setLayout(new BoxLayout(buttonFrame, BoxLayout.PAGE_AXIS));
        buttonFrame.setBounds(400, 480, 500, 100);
        buttonFrame.setBackground(new Color(26, 145, 85));

        // Add playAgain button
        JButton playAgain = new JButton("PLAY AGAIN");
        playAgain.setFont(new Font("Tahoma", Font.BOLD, 30)); // Fix: Use Font.PLAIN instead of Font.SANS_SERIF
        playAgain.setBorder(null);
        playAgain.setBackground(Color.WHITE);
        playAgain.setPreferredSize(new Dimension(200, 70));
        playAgain.setMaximumSize(playAgain.getPreferredSize()); // Set maximum size

        playAgain.setForeground(new Color(159, 0, 0));
        playAgain.setFocusPainted(false);
        playAgain.setEnabled(true);
        playAgain.setOpaque(true);
        playAgain.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center

        buttonFrame.add(playAgain);
        // Add a vertical gap
        buttonFrame.add(Box.createVerticalStrut(20)); // Creates a 20-pixel high gap
        // Add exitButton button
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        exitButton.setBorder(null);
        exitButton.setBackground(new Color(159, 0, 0));
        exitButton.setPreferredSize(new Dimension(100,70));
        exitButton.setMaximumSize(playAgain.getPreferredSize()); // Set maximum size
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.setEnabled(true);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center

        exitButton.setOpaque(true);

        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose(); // Close the current frame
                try {
                    new Game();  
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // dispose the screen
                myFrame.dispose();
            }
        });

        
        buttonFrame.add(exitButton);
        return buttonFrame;
    } 
    // C Ha run thu cai nay de xem frame cung dc ne
    // public static void main(String[] args) throws Exception{
    //     displayResult();
    // }
}
