// help from https://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class Chessboard extends JFrame {

	 private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private static Container pane;
	private Pieces[][] Location;
	public static int height = 1000;
	public static int width = 1000;


    Chessboard() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setTitle("PLAY CHESS");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
	   //starting to layout the sections of the chessboard
       pane = this.getContentPane();
       Location = new Pieces[8][8];
       pane.setLayout(new GridLayout(8,8));
       //code for chessboard
       
       
       


        
        
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
       Chessboard c = new Chessboard();
       c.setVisible(true);
       c.setSize(new Dimension(1000,1000));
       c.setDefaultCloseOperation(EXIT_ON_CLOSE);
       }
}
