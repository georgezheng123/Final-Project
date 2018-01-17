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
	} 

	public static HashMap<String, Integer> setupMap(){
		HashMap<String, Integer> pieceCon = new HashMap<String, Integer>();
		String[] stuff = new String[] {"Pawn","Knight","Bishop","Rook","Queen","King"};
		for (int i=0; i<stuff.length; i++){
			pieceCon.put(stuff[i],i);
		}
		return pieceCon;
	}

	public static boolean validates(String pieceName, int[] from, int[] to){
		HashMap<String, Integer> pieceCon; 
		pieceCon = setupMap();
		int id = pieceCon.get(pieceName);
		if (id == 1){
			return Pawn.validate(from, to);
		}
		if (id == 5){
			return King.validate(from, to);
		}
		return false;
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
		return "I am a validator"; 
	} 
}
	