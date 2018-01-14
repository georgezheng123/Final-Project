import javax.swing.*; 
import java.util.ArrayList; 
public class Pieces { 
	private Position position; 
	private int color; 
	private JLabel getLabel; 
	private JLabel setLabel; 
	public Pieces(Position coordinate, int colors){ 
		position = coordinate; color = colors; 
	} 
	public JLabel getJLabel(){ 
		return getLabel; 
	} 
	public JLabel setJLabel(){ 
		return setLabel; 
	} 
	public Pieces(int x, int y, int colors){ 
		position = new Position(x,y); color = colors; 
	} 
	public Position getPos(){ 
		return position; 
	} 
	public void setPos(Position coordinate){ 
		position = coordinate; 
	} 
	public String toString(){ 
		return " "; 
	} 
}
	