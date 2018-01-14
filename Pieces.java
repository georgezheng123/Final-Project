
import javax.swing.*; 
import java.util.ArrayList; 
public class Pieces extends JLabel{ 
	private Position position; 
	private int color; 
	private JLabel label;
	public Pieces(Position coordinate, int colors){ 
		position = coordinate; color = colors; 
	} 
	public JLabel getJLabel(){ 
		return label; 
	} 
	public JLabel setJLabel(JLabel newLabel){ 
		label = newLabel; 
		return label;
	}
	public Pieces(JLabel argument){ 
		label = argument;
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
	