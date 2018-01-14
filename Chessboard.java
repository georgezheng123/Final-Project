import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Chessboard extends JFrame implements MouseListener, MouseMotionListener
{
    JLayeredPane newPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int moveX;
    int moveY;

    public Chessboard()
    {
        Dimension boardSize = new Dimension(600, 600);

        //layered Pane so you can add MouseListener

        newPane = new JLayeredPane();
        newPane.setPreferredSize( boardSize );
        newPane.addMouseListener( this );
        newPane.addMouseMotionListener( this );
        getContentPane().add(newPane);

        // making a new JPanel

        chessBoard = new JPanel();
        chessBoard.setLayout( new GridLayout(8, 8));
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        newPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);

        //  Build the Chess Board squares

        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                JPanel square = new JPanel( new BorderLayout() );
                if((row+col) % 2 == 0){
                	square.setBackground(Color.red);
                }
                else{
                	square.setBackground(Color.white);
                }
                chessBoard.add( square );
            }
        }

		//White Rook
        ImageIcon WhiteRook = new ImageIcon("./Pieces/WhiteRook.png"); 
        JLabel WhiteRookPiece = new JLabel(WhiteRook);
        JPanel WhiteRookPanel = (JPanel)chessBoard.getComponent( 56 );
        WhiteRookPanel.add(WhiteRookPiece);
        WhiteRookPiece = new JLabel(WhiteRook);
        WhiteRookPanel = (JPanel)chessBoard.getComponent( 63 );
        WhiteRookPanel.add(WhiteRookPiece);
        //White Knight
        ImageIcon WhiteKnight = new ImageIcon("./Pieces/WhiteKnight.png"); 
        JLabel WhiteKnightPiece = new JLabel(WhiteKnight);
        JPanel WhiteKnightPanel = (JPanel)chessBoard.getComponent( 57 );
        WhiteKnightPanel.add(WhiteKnightPiece);
        WhiteKnightPiece = new JLabel(WhiteKnight);
        WhiteKnightPanel = (JPanel)chessBoard.getComponent( 62 );
        WhiteKnightPanel.add(WhiteKnightPiece);
        //White Pawns
         ImageIcon WhitePawn = new ImageIcon("./Pieces/WhitePawn.png"); 
        JLabel  WhitePawnPiece = new JLabel( WhitePawn);
        JPanel WhitePawnPanel = (JPanel)chessBoard.getComponent( 48 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 49 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 50 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 51 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 52 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 53 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 54 );
        WhitePawnPanel.add( WhitePawnPiece);
        WhitePawnPiece = new JLabel( WhitePawn);
        WhitePawnPanel = (JPanel)chessBoard.getComponent( 55 );
        WhitePawnPanel.add( WhitePawnPiece);
        //White Queen
        ImageIcon WhiteQueen = new ImageIcon("./Pieces/WhiteQueen.png"); 
        JLabel WhiteQueenPiece = new JLabel(WhiteQueen);
        JPanel WhiteQueenPanel = (JPanel)chessBoard.getComponent( 59 );
        WhiteQueenPanel.add(WhiteQueenPiece);
        //White King
        ImageIcon WhiteKing = new ImageIcon("./Pieces/WhiteKing.png"); 
        JLabel WhiteKingPiece = new JLabel(WhiteKing);
        JPanel WhiteKingPanel = (JPanel)chessBoard.getComponent( 60 );
        WhiteKingPanel.add(WhiteKingPiece);
        //White Bishop
        ImageIcon WhiteBishop = new ImageIcon("./Pieces/WhiteBishop.png"); 
        JLabel WhiteBishopPiece = new JLabel(WhiteBishop);
        JPanel WhiteBishopPanel = (JPanel)chessBoard.getComponent( 58 );
        WhiteBishopPanel.add(WhiteBishopPiece);
        WhiteBishopPiece = new JLabel(WhiteBishop);
        WhiteBishopPanel = (JPanel)chessBoard.getComponent( 61 );
        WhiteBishopPanel.add(WhiteBishopPiece);
        
        //Black Rook
        ImageIcon BlackRook = new ImageIcon("./Pieces/BlackRook.png"); 
        JLabel BlackRookPiece = new JLabel(BlackRook);
        JPanel BlackRookPanel = (JPanel)chessBoard.getComponent( 0 );
        BlackRookPanel.add(BlackRookPiece);
        BlackRookPiece = new JLabel(BlackRook);
        BlackRookPanel = (JPanel)chessBoard.getComponent( 7 );
        BlackRookPanel.add(BlackRookPiece);
        //Black Knight
        ImageIcon BlackKnight = new ImageIcon("./Pieces/BlackKnight.png"); 
        JLabel BlackKnightPiece = new JLabel(BlackKnight);
        JPanel BlackKnightPanel = (JPanel)chessBoard.getComponent( 1 );
        BlackKnightPanel.add(BlackKnightPiece);
        BlackKnightPiece = new JLabel(BlackKnight);
        BlackKnightPanel = (JPanel)chessBoard.getComponent( 6 );
        BlackKnightPanel.add(BlackKnightPiece);
        //Black Pawns
         ImageIcon BlackPawn = new ImageIcon("./Pieces/BlackPawn.png"); 
        JLabel  BlackPawnPiece = new JLabel( BlackPawn);
        JPanel BlackPawnPanel = (JPanel)chessBoard.getComponent( 8 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 9 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 10 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 11 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 12 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 13 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 14 );
        BlackPawnPanel.add( BlackPawnPiece);
        BlackPawnPiece = new JLabel( BlackPawn);
        BlackPawnPanel = (JPanel)chessBoard.getComponent( 15 );
        BlackPawnPanel.add( BlackPawnPiece);
        //Black Queen
        ImageIcon BlackQueen = new ImageIcon("./Pieces/BlackQueen.png"); 
        JLabel BlackQueenPiece = new JLabel(BlackQueen);
        JPanel BlackQueenPanel = (JPanel)chessBoard.getComponent( 3 );
        BlackQueenPanel.add(BlackQueenPiece);
        //Black King
        ImageIcon BlackKing = new ImageIcon("./Pieces/BlackKing.png"); 
        JLabel BlackKingPiece = new JLabel(BlackKing);
        JPanel BlackKingPanel = (JPanel)chessBoard.getComponent( 4 );
        BlackKingPanel.add(BlackKingPiece);
        //Black Bishop
        ImageIcon BlackBishop = new ImageIcon("./Pieces/BlackBishop.png"); 
        JLabel BlackBishopPiece = new JLabel(BlackBishop);
        JPanel BlackBishopPanel = (JPanel)chessBoard.getComponent( 2 );
        BlackBishopPanel.add(BlackBishopPiece);
        BlackBishopPiece = new JLabel(BlackBishop);
        BlackBishopPanel = (JPanel)chessBoard.getComponent( 5 );
        BlackBishopPanel.add(BlackBishopPiece);

        
    }

    //dragging selected piece
    public void mousePressed(MouseEvent e)
    {
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) return;

        Point parentLocation = c.getParent().getLocation();
        moveX = parentLocation.x - e.getX();
        moveY = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + moveX, e.getY() + moveY);

        newPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
        newPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    /*
    **  Move the chess piece around
    */
    public void mouseDragged(MouseEvent me)
    {
        if (chessPiece == null) return;

        //  The drag location should be within the bounds of the chess board

        int x = me.getX() + moveX;
        int xMax = newPane.getWidth() - chessPiece.getWidth();
        x = Math.min(x, xMax);
        x = Math.max(x, 0);

        int y = me.getY() + moveY;
        int yMax = newPane.getHeight() - chessPiece.getHeight();
        y = Math.min(y, yMax);
        y = Math.max(y, 0);

        chessPiece.setLocation(x, y);
        System.out.println(chessPiece.getIcon().toString());
     }

    
    //MOUSE RELEASED
    public void mouseReleased(MouseEvent e)
    {
        newPane.setCursor(null);

        if (chessPiece == null) return;

       // gets rid of the chesspiece

        chessPiece.setVisible(false);
        newPane.remove(chessPiece);
        chessPiece.setVisible(true);

        // makes sure that the chess piece is within the board

        int xMax = newPane.getWidth() - chessPiece.getWidth();
        int x = Math.min(e.getX(), xMax);
        x = Math.max(x, 0);

        int yMax = newPane.getHeight() - chessPiece.getHeight();
        int y = Math.min(e.getY(), yMax);
        y = Math.max(y, 0);

        Component c =  chessBoard.findComponentAt(x, y);

        if (c instanceof JLabel)
        {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( chessPiece );
            parent.validate();
        }
        else
        {
            Container parent = (Container)c;
            parent.add( chessPiece );
            parent.validate();
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args)
    {
        JFrame frame = new Chessboard();
        frame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        frame.setResizable( false );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }
}
