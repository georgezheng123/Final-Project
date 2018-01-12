import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

class ChessBoard extends JFrame implements ActionListener {

    private JButton[][] tiles; 
    private Pieces[][] pieces;
    private JPanel panel;

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



    public static void main(String[] args){
        ChessBoard a = new ChessBoard();
    }


    public ChessBoard() {
        this.tiles = new JButton[8][8];
        this.pieces = new Pieces[8][8];
        this.panel = new JPanel(new GridLayout(8, 8));

        guiSetup();
    }

    public void guiSetup(){
        for (int x=0; x<8; x++){
            for (int y=0; y<8; y++){
                tiles[x][y] = new JButton();
                tiles[x][y].addActionListener(this);
                emptySquare(x, y);
                panel.add(tiles[x][y]);
                pieces[x][y] = null;
            }
        }
        this.add(panel);
        this.setSize(800, 800);
        this.setVisible(true);

    public final void initializeGui() {
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setTitle("PLAY CHESS");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
	   //starting to layout the sections of the chessboard
       pane = this.getContentPane();
       Location = new Pieces[8][8];
       pane.setLayout(new GridLayout(8,8));
       //code for chessboard
       
       
       

        chessBoard.add(new JLabel(""));        
    }

    public final JComponent getChessBoard() {
        return chessBoard;

    }

    private void emptySquare(int row, int col) {
        if ((row + col) % 2 == 1){
            tiles[row][col].setBackground(Color.BLACK);
            tiles[row][col].setOpaque(true);
        }else{
            tiles[row][col].setBackground(Color.WHITE);
            tiles[row][col].setOpaque(true);
        }
    }


    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        int col = -1;
        int row = -1;

        for (int x=0; x<8; x++) {
          for (int y=0; y<8; y++) {
            if (tiles[x][y] == pressed) {
              row = x;
              col = y;
          }
      }
  }
}
}


    public static void main(String[] args) {
       Chessboard c = new Chessboard();
       c.setVisible(true);
       c.setSize(new Dimension(1000,1000));
       c.setDefaultCloseOperation(EXIT_ON_CLOSE);
       }
}

