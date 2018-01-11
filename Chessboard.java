// help from https://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class Chessboard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JPanel chessBoard;
    private Container contents;
    private JButton[][] Squares = new JButton[8][8];
    private final JLabel message = new JLabel(
            "PLAY CHESS");

    Chessboard() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        

        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);


        //fill the chess board
    //public Layout(){
        //contents = getContentPane();
        contents.setLayout(new GridLayout(8,8));
    
        //ButtonUsage buttonUsage = new ButtonUsage();

    // adding board stuff
    for (int i = 0; i < 8; i++){
        for (int j = 0; j < 8; j++){
        Squares[i][j] = new JButton();
        if ((i + j) % 2 != 0){
            Squares[i][j].setBackground(Color.BLACK);
        }
        contents.add(Squares[i][j]);
        //Squares[i][j].addActionListener(buttonUsage);        
    }
    
   /* private class ButtonHandler implements ActionListener{
    	public void actionPerformed(ActionEvenet e){
    		Object source = e.getSource();
    		for (int i = 0; i < 8; i++){
    		for (int j = 0; j < 8; j++){
    			if (source == Squares[i][j]){
    				processClick(i,j);
    				return;
    				}
    			}
    		}
    	}
    }*/


        
    }
}

    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Chessboard cb =
                        new Chessboard();

                JFrame f = new JFrame("PLAY CHESS");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

