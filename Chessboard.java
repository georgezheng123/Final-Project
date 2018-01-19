import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;

// bishop check collision
// queen check collision
// check if king is in check, king can't move into check
// check if move other piece would mean king is in check
// detect checkmate:: 
// king is in check
// look at his possible moves, loop through them to see if he'll still be in check
// look at the piece checking him(more than 1 == checkmate), if some of his pieces can capture it
// look if some of his pieces can block that piece
// it is checkmates
// en passant, castling , pawn promotion
// TESTING


public class Chessboard extends JFrame implements MouseListener, MouseMotionListener
{
    JLayeredPane newPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int moveY;
    int moveX;
    int[] from;
    int[] to;
    Pieces validator;

    public Chessboard()
    {
        Pieces validator = new Pieces();
        this.validator = validator;
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
                chessBoard.add(square);
            }
        }

        //White Rook
        ImageIcon WhiteRook = new ImageIcon("./Pieces/WhiteRook.png"); 
        Pieces WhiteRookPiece = new Pieces(new JLabel(WhiteRook));
        JPanel WhiteRookPanel = (JPanel)chessBoard.getComponent( 56 );
        WhiteRookPanel.add(WhiteRookPiece.getJLabel());
        WhiteRookPiece = new Pieces(new JLabel(WhiteRook));
        WhiteRookPanel = (JPanel)chessBoard.getComponent( 63 );
        WhiteRookPanel.add(WhiteRookPiece.getJLabel());

        //White Knight
        ImageIcon WhiteKnight = new ImageIcon("./Pieces/WhiteKnight.png"); 
        Pieces WhiteKnightPiece = new Pieces(new JLabel(WhiteKnight));
        JPanel WhiteKnightPanel = (JPanel)chessBoard.getComponent( 57 );
        WhiteKnightPanel.add(WhiteKnightPiece.getJLabel());
        WhiteKnightPiece = new Pieces(new JLabel(WhiteKnight));
        WhiteKnightPanel = (JPanel)chessBoard.getComponent( 62 );
        WhiteKnightPanel.add(WhiteKnightPiece.getJLabel());

        //White Pawns
        ImageIcon WhitePawn = new ImageIcon("./Pieces/WhitePawn.png"); 
        Pieces WhitePawnPiece = new Pieces(new JLabel( WhitePawn));
        JPanel WhitePawnPanel = (JPanel)chessBoard.getComponent( 48 );
        WhitePawnPanel.add( WhitePawnPiece.getJLabel());

        for (int i=49; i<56; i++){
            WhitePawnPiece = new Pieces(new JLabel( WhitePawn));
            WhitePawnPanel = (JPanel)chessBoard.getComponent(i);
            WhitePawnPanel.add( WhitePawnPiece.getJLabel());
        }

        //White Queen
        ImageIcon WhiteQueen = new ImageIcon("./Pieces/WhiteQueen.png"); 
        Pieces WhiteQueenPiece = new Pieces(new JLabel(WhiteQueen));
        JPanel WhiteQueenPanel = (JPanel)chessBoard.getComponent( 59 );
        WhiteQueenPanel.add(WhiteQueenPiece.getJLabel());

        //White King
        ImageIcon WhiteKing = new ImageIcon("./Pieces/WhiteKing.png"); 
        Pieces WhiteKingPiece = new Pieces(new JLabel(WhiteKing));
        JPanel WhiteKingPanel = (JPanel)chessBoard.getComponent( 60 );
        WhiteKingPanel.add(WhiteKingPiece.getJLabel());

        //White Bishop
        ImageIcon WhiteBishop = new ImageIcon("./Pieces/WhiteBishop.png"); 
        Pieces WhiteBishopPiece = new Pieces(new JLabel(WhiteBishop));
        JPanel WhiteBishopPanel = (JPanel)chessBoard.getComponent( 58 );
        WhiteBishopPanel.add(WhiteBishopPiece.getJLabel());
        WhiteBishopPiece = new Pieces(new JLabel(WhiteBishop));
        WhiteBishopPanel = (JPanel)chessBoard.getComponent( 61 );
        WhiteBishopPanel.add(WhiteBishopPiece.getJLabel());
        
        //Black Rook
        ImageIcon BlackRook = new ImageIcon("./Pieces/BlackRook.png"); 
        Pieces BlackRookPiece = new Pieces(new JLabel(BlackRook));
        JPanel BlackRookPanel = (JPanel)chessBoard.getComponent( 0 );
        BlackRookPanel.add(BlackRookPiece.getJLabel());
        BlackRookPiece = new Pieces(new JLabel(BlackRook));
        BlackRookPanel = (JPanel)chessBoard.getComponent( 7 );
        BlackRookPanel.add(BlackRookPiece.getJLabel());

        //Black Knight
        ImageIcon BlackKnight = new ImageIcon("./Pieces/BlackKnight.png"); 
        Pieces BlackKnightPiece = new Pieces(new JLabel(BlackKnight));
        JPanel BlackKnightPanel = (JPanel)chessBoard.getComponent( 1 );
        BlackKnightPanel.add(BlackKnightPiece.getJLabel());
        BlackKnightPiece = new Pieces(new JLabel(BlackKnight));
        BlackKnightPanel = (JPanel)chessBoard.getComponent( 6 );
        BlackKnightPanel.add(BlackKnightPiece.getJLabel());
          //Black Pawns

        ImageIcon BlackPawn = new ImageIcon("./Pieces/BlackPawn.png"); 
        Pieces BlackPawnPiece = new Pieces(new JLabel( BlackPawn));
        JPanel BlackPawnPanel = (JPanel)chessBoard.getComponent( 8 );
        BlackPawnPanel.add( BlackPawnPiece.getJLabel());

        for (int i=9; i<16; i++){
            BlackPawnPiece = new Pieces(new JLabel( BlackPawn));
            BlackPawnPanel = (JPanel)chessBoard.getComponent(i);
            BlackPawnPanel.add( BlackPawnPiece.getJLabel());
        }

        //Black Queen
        ImageIcon BlackQueen = new ImageIcon("./Pieces/BlackQueen.png"); 
        Pieces BlackQueenPiece = new Pieces(new JLabel(BlackQueen));
        JPanel BlackQueenPanel = (JPanel)chessBoard.getComponent( 3 );
        BlackQueenPanel.add(BlackQueenPiece.getJLabel());

        //Black King
        ImageIcon BlackKing = new ImageIcon("./Pieces/BlackKing.png"); 
        Pieces BlackKingPiece = new Pieces(new JLabel(BlackKing));
        JPanel BlackKingPanel = (JPanel)chessBoard.getComponent( 4 );
        BlackKingPanel.add(BlackKingPiece.getJLabel());

        //Black Bishop
        ImageIcon BlackBishop = new ImageIcon("./Pieces/BlackBishop.png"); 
        Pieces BlackBishopPiece = new Pieces(new JLabel(BlackBishop));
        JPanel BlackBishopPanel = (JPanel)chessBoard.getComponent( 2 );
        BlackBishopPanel.add(BlackBishopPiece.getJLabel());
        BlackBishopPiece = new Pieces(new JLabel(BlackBishop));
        BlackBishopPanel = (JPanel)chessBoard.getComponent( 5 );
        BlackBishopPanel.add(BlackBishopPiece.getJLabel());

    }


    

    //dragging selected piece
    public void mousePressed(MouseEvent e)
    {
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        //System.out.println(c);


        if (c instanceof JPanel) return;

        Point parentLocation = c.getParent().getLocation();
        moveX = parentLocation.x - e.getX();
        moveY = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + moveX, e.getY() + moveY);


        int[] coords = getCoord(chessPiece.getLocation());
        from = coords;


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
    }

    
    //MOUSE RELEASED
    public void mouseReleased(MouseEvent e)
    {
        newPane.setCursor(null);

        if (chessPiece == null) return;

       // gets rid of the chesspiece
        int[][] state = getBoardState();
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

        Container parent = (Container)c;
        int[] coords = getCoord(parent.getLocation());
        to = coords;
        String pieceType = getImageName(chessPiece);


        if (c instanceof JLabel) //capture
        {//write type function
         //cannot capture of same type
            Point parentLocation = c.getParent().getLocation();
            to = getCoord(parentLocation);


            Boolean isDiffColor = diffColor(chessPiece, (JLabel) c);
            Boolean isValidMove = validator.validates(true, getColor(chessPiece) , pieceType, from, to, state);
            
            if (isValidMove && isDiffColor){
                //System.out.println(parent);
                // parent.remove(0);
                // parent.add( chessPiece );
                JPanel panel = (JPanel)chessBoard.getComponent( to[0] + to[1]*8);
                panel.remove(0);
                panel.add(chessPiece);
                parent.validate();
            }else{//invalid move!!
                JPanel panel = (JPanel)chessBoard.getComponent( from[0] + from[1]*8);
                panel.add(chessPiece);
            }
        }

        else //move
        {

            // System.out.println(from[0] + " " + from[1]);
            // System.out.println(to[0] + " " + to[1]);
            
            System.out.println(pieceType);
            if (validator.validates(false, getColor(chessPiece), pieceType, from, to, state)){
                parent.add(chessPiece);
                parent.validate();
            }else{//invalid move!!
                JPanel panel = (JPanel)chessBoard.getComponent( from[0] + from[1]*8);
                panel.add(chessPiece);
            }
            
        }

    }

    public static String getImageName(JLabel label){//gets the name of the image file
        Icon icon = label.getIcon();
        String absolutePath = icon.toString().replaceFirst("file:/", "");
        absolutePath = absolutePath.replaceAll("%20", " ");
        absolutePath = absolutePath.substring(9,absolutePath.length());
        absolutePath = absolutePath.substring(0,absolutePath.indexOf('.'));
        return absolutePath.replace("White","").replace("Black","");
    }

    public static String getColor(JLabel label){//gets the name of the image file
        Icon icon = label.getIcon();
        String absolutePath = icon.toString().replaceFirst("file:/", "");
        absolutePath = absolutePath.replaceAll("%20", " ");
        absolutePath = absolutePath.substring(9,absolutePath.length());
        absolutePath = absolutePath.substring(0,absolutePath.indexOf('.'));
        return absolutePath.substring(0,5);
    }

    public static Boolean diffColor(JLabel label, JLabel other){//gets the name of the image file
        return !getColor(label).equals(getColor(other));
    }

    public static int[] getCoord(Point p){//gets the coordinates to be moved to
        int[] arr = new int[2];
        arr[0] = (int) p.getX() / 75 ;
        arr[1] = (int) p.getY() / 75 ;
        return arr;
    }
    

public int[][] getBoardState(){
    int[][] state = new int[8][8];
    // Component[] cc = chessBoard.getComponents();
    // for (Component i: cc){
    //     System.out.println(i);
    // }
    int counter =0;
    for (int i=0; i<8; i++){
        for (int j=0; j<8; j++){
            Component c = chessBoard.findComponentAt(i*75, j*75);;
            if (c instanceof JPanel){
                state[j][i] = 0;
            }else{
                state[j][i] = 1;
                // System.out.println(getImageName((JLabel) c) + i + " " + j);
                counter++;
            }
        }
    }
    // for (int[] i: state){
    //     System.out.println(Arrays.toString(i));
    // }
    // System.out.println();
    return state;
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
