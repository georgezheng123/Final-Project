import java.util.HashMap;
import javax.swing.*; 
import java.util.ArrayList; 

public class Pieces extends JLabel{ 
	private Position position; 
	private int color; 
	private JLabel label;
	private 
	
	public Pieces(Position coordinate, int colors){ 
		position = coordinate; color = colors; 
	} 

	public Pieces(){ 
	} 

	public void setupMap(){
		HashMap<String, Integer> pieceCon = new HashMap<>();
		pieceCon.put("Chaitanya");
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




	public String toString(){ 
		return " "; 
	} 
}
	