import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.border.*;
import java.util.ArrayList;

class Chessboard extends JFrame{

    private Pieces[][] pieces;
    private JPanel panel;
    //private static ArrayList<Pieces> White;
    //private static ArrayList<Pieces> Black;
    public static Border blackBorder = new LineBorder(Color.black);

    public static void main(String[] args){
        Chessboard a = new Chessboard();
        
    }

    public Chessboard() {
        this.pieces = new Pieces[8][8];
        this.panel = new JPanel(new GridLayout(8, 8));
		//Black = new ArrayList<Pieces>();
		//White = new ArrayList<Pieces>();
		boolean backGround = false;
		for (int row = 0; row < pieces.length; row++){
			for(int col = 0; col < pieces[row].length; col++){
				Pieces newpiece = new Pieces(row, col, 2);
				
				pieces[row][col] = newpiece;
				newpiece.setOpaque(true);
				newpiece.setBorder(blackBorder);
				if (col == 0){
					backGround = !backGround;
				}
				if (backGround){
					newpiece.setBackground(Color.white);
					backGround = false;
				}
				else{
					newpiece.setBackground(Color.red);
					backGround = true;
				}
				panel.add(newpiece);
			}
		}
        guiSetup();
    }

    public void guiSetup(){
        this.setTitle("CHESS");
        this.setLocation(100,100);
        this.add(panel);
        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*private void emptySquare(int row, int col) {
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
*/
}