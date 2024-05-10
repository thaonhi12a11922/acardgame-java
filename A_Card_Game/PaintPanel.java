package A_Card_Game;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PaintPanel extends JPanel implements ActionListener {
    UI ui;
    BufferedImage bg_img;
    float alphaValue = 0f;
    String image_name;

    public PaintPanel(UI ui, String image_name){
        this.ui = ui;
        
        //add image to the frame
        try {
            bg_img = ImageIO.read(getClass().getClassLoader().getResource("A_Card_Game\\IMAGE\\" + image_name));

        } catch (IOException e){
            e.getMessage();
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);	
		g.drawImage(bg_img,0,0,644*2 - 20, 411*2 - 58,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        String command = e.getActionCommand();
        System.out.println(command);
    }
    
}
