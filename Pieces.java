import javax.swing.*;
import java.util.ArrayList;


/*public abstract class Pieces{
	
	private int color;
	private Position position;

	public abstract boolean validMove();

	public abstract boolean move();

}
*/

public class Pieces extends JLabel{
	private Position position;
	private int color;
	
	public Pieces(Position coordinate, int colors){
		position = coordinate;
		color = colors;
	}
	
	
	public Pieces(int x, int y, int colors){
		position = new Position(x,y);
		color = colors;
	}
	
	public Position getPos(){
		return position;
	}
	
	public void setPos(Position coordinate){
		position = coordinate;
	}
	
	public String toString(){
		return " "; //more to be added
	}
}