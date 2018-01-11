import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

class ChessBoard extends JFrame implements ActionListener {

    private JButton[][] tiles; 
    private Pieces[][] pieces;
    private JPanel panel;

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

