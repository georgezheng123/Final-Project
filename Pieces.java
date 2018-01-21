import java.util.HashMap;
import javax.swing.*; 
import java.util.ArrayList; 
import java.util.*;


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
		id = id * ((color.equals("White")) ? 1 : -1);
		if (from.toString().equals(to.toString())){
			return false;
		}
		
		
		if (Math.abs(id) != 6 && checkIfCheck(color, state, from, to, id)){
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
			return King.validate(color, from, to, state, false);
		}
		return false;
	}

	public static boolean validates(Boolean capture, String color, int id, int[] from, int[] to, int[][] state){
		//id = Math.abs(id);
		
		if (Math.abs(id)== 1){

			if (!capture){
				return Pawn.validate(color,from, to, state);
			}
			return Pawn.pawnCaptureValidate(color,from, to); 
			
		}
		if (Math.abs(id)== 2){
			return Knight.validate(color,from, to);
		}
		if (Math.abs(id)== 3){
			return (Bishop.validate(color,from, to) && !Bishop.checkUnitCollision(from, to, state));
		}
		if (Math.abs(id)== 4){
			return (Rook.validate(color,from, to) && !Rook.checkUnitCollision(from, to, state)) ;
		}
		if (Math.abs(id)== 5){
			return (Queen.validate(color,from, to) && !Queen.checkUnitCollision(from, to, state));
		}
		if (Math.abs(id)== 6){
			return King.validate(color, from, to, state, false);
		}
		return false;
	}

	public static int[] findTheKing(String color, int[][] state){
		int[] ans = new int[2];  
		int target = ((color.equals("White")) ? 6 : -6);
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int pieceID = state[j][i];
				if (pieceID == target){
					ans = new int[] {i,j};
				}
			}
		}
		return ans;
	}

	public static Boolean checkIfCheck(String color, int[][] state, int[] from, int[] to, int id){
		int[] kingLocation = findTheKing(color, state);

		int[][] stateee = state.clone();
		for (int i = 0; i < stateee.length; i++) {
			stateee[i] = state[i].clone();
		}
		int fromX = from[1]; 
		int toX = to[1];

		int fromY = from[0];
		int toY = to[0];
		stateee[fromX][fromY] = 0;
		stateee[toX][toY] = id;
		System.out.println("will now check for check:");
				    for (int[] i: stateee){
        System.out.println(Arrays.toString(i));
    }
		return King.isInCheck(color, stateee, kingLocation, (color.equals("White")) ? 6 : -6);
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
