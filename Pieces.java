import java.util.HashMap;
import javax.swing.*; 
import java.util.ArrayList; 

public class Pieces extends JLabel{ 
	private Position position; 
	private int color; 
	private JLabel label;
	 
	
	public Pieces(Position coordinate, int colors){ 
		position = coordinate; color = colors; 
	} 

	public Pieces(){ 
		setupMap();
	} 

	public void setupMap(){
		HashMap<String, Integer> pieceCon = new HashMap<>();
		String[] stuff = new String[] {"Pawn","Knight","Bishop","Rook","Queen","King"};
		for (int i=0; i<stuff.length; i++){
			pieceCon.put(stuff[i],i);
		}
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
	