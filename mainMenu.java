import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
public class mainMenu extends JFrame{
	private Container pane;
	private JFrame window = new JFrame("Main Menu");
	private JFrame startPage = new JFrame("Menu");
	private JButton start = new JButton("Start");
	private JLabel background;
	
	public mainMenu(){
		pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
		
		start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    startPage.dispose();
		    new Chessboard();
		}
	    });
		
		background = new JLabel();
		background.setLayout(new FlowLayout(FlowLayout.CENTER));
		background.add(Box.createRigidArea(new Dimension(800,800)));
		background.setIcon(new ImageIcon("mainMenu.png"));
		
		start.setPreferredSize(new Dimension(200,50));
		start.setLocation(700,300);
		start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		background.add(start);
		pane.add(background);
		background.add(Box.createRigidArea(new Dimension(800,800)));
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,800);
}
		public static void main(String[] args){
			new mainMenu();
		}
	







}