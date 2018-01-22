import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class mainMenu extends JFrame {
    private Container pane;
    private JFrame window = new JFrame("Main Menu");
    private JButton start = new JButton("Start");
    private JLabel backImage;
	
    public mainMenu() {
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    window.dispose();
		    new Chessboard();
		}
	    });

	backImage = new JLabel();
	backImage.setLayout(new FlowLayout(FlowLayout.CENTER));
	backImage.add(Box.createRigidArea(new Dimension(1000,475)));

	backImage.setIcon(new ImageIcon("mainMenu.png"));

	start.setPreferredSize(new Dimension(200,50));
	
	start.setLocation(450,525);

	start.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	backImage.add(start);
	backImage.add(Box.createRigidArea(new Dimension(800,800)));
	pane.add(backImage);
	this.pack();
	this.setVisible(true);
	

	this.setTitle("CHESS");
	this.setSize(800,800);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
	new mainMenu();
    }
}
