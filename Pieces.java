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
		for (int i=1; i<stuff.length+1; i++){
			pieceCon.put(stuff[i-1],i);
		}
		return pieceCon;
	}

	public static int getID(String pieceName){
		HashMap<String, Integer> pieceCon; 
		pieceCon = setupMap();
		return pieceCon.get(pieceName);
	}

	public static boolean validates(Boolean capture, String color, String pieceName, int[] from, int[] to, int[][] state){
		int id = getID(pieceName);
		if (from.toString().equals(to.toString())){
			return false;
		}
		id = Math.abs(id);
		
		if (id == 1){
			if (!capture){
				return Pawn.validate(color,from, to, state);
			}
			return Pawn.pawnCaptureValidate(color,from, to); 
		}
		if (id == 2){
			return Knight.validate(color,from, to);
		}
		if (id == 3){
			return (Bishop.validate(color,from, to) && !Bishop.checkUnitCollision(from, to, state));
		}
		if (id == 4){
			return (Rook.validate(color,from, to) && !Rook.checkUnitCollision(from, to, state)) ;
		}
		if (id == 5){
			return (Queen.validate(color,from, to) && !Queen.checkUnitCollision(from, to, state));
		}
		if (id == 6){
			return King.validate(color, from, to, state);
		}
		return false;
	}

	public static boolean validates(Boolean capture, String color, int id, int[] from, int[] to, int[][] state){
		id = Math.abs(id);
		
		if (id == 1){

			if (!capture){
				return Pawn.validate(color,from, to, state);
			}
			return Pawn.pawnCaptureValidate(color,from, to); 
			
		}
		if (id == 2){
			return Knight.validate(color,from, to);
		}
		if (id == 3){
			return (Bishop.validate(color,from, to) && !Bishop.checkUnitCollision(from, to, state));
		}
		if (id == 4){
			return (Rook.validate(color,from, to) && !Rook.checkUnitCollision(from, to, state)) ;
		}
		if (id == 5){
			return (Queen.validate(color,from, to) && !Queen.checkUnitCollision(from, to, state));
		}
		if (id == 6){
			return King.validate(color, from, to, state);
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
	