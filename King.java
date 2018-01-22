import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class King extends Pieces{

	public static boolean validate(String color, int[] from, int[] to, int[][] state, Boolean toCheck){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		double dist = Math.hypot(deltaX, deltaY);
		// System.out.println("king:" + fromX + "," + fromY + "   " + toX + "," + toY + "" );

		Boolean intoCheck; 
		if (!toCheck){
			intoCheck = isInCheck(color, state, to, (color.equals("White")) ? 6 : -6);
		}else{
			intoCheck = false;
		}
		return !intoCheck && (dist == 1.0 || dist == Math.sqrt(2));
	}

	public static boolean isInCheck(String color, int[][] state, int[] location, int type){
		// for (int[] i: state){
  //   	    System.out.println(Arrays.toString(i));
  //   	}
		color = otherColor(color);
		Boolean isChecked = false;
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int pieceID = state[j][i];
				int[] from = new int[] {i,j};
				
				if (pieceID * type < 0){
					Boolean isValid;
					if (Math.abs(pieceID) != 6){
						isValid = Pieces.validates(true, color, pieceID, from, location, state);
					}else{
						isValid = validate(color, from, location, state, true);
					}
					if (isValid){
						isChecked = true;
						// System.out.println("\n\n" + pieceID + "" + Arrays.toString(from));
						// System.out.println("king is at"  + Arrays.toString(tempLoc));
						System.out.println(pieceID + "IS CHECKING TEH KING at " 
							+ Arrays.toString(location) + " from "+ Arrays.toString(from));
						// System.out.println("Total pieces checking king"+ counter+ "\n\n");
					}
				}
			}
		}
		return isChecked;
	}

	public static boolean checkmate(String color, int[][] state){
		int[] kingLocation = Pieces.findTheKing(otherColor(color), state);
				    for (int[] i: state){
        System.out.println(Arrays.toString(i));
    }
		if (!isInCheck(otherColor(color), state, kingLocation, (color.equals("White")) ? -6 : 6)){
			System.out.println(otherColor(color) + "king is not in check");
			return false;
		}
		System.out.println(otherColor(color) + "king is in check");
		if (canMoveAway(otherColor(color), state, kingLocation, (color.equals("White")) ? -6 : 6)){
			System.out.println(otherColor(color) + "king can move away");
			return false;
		}
		System.out.println(otherColor(color) + "king cannot move away");
		System.out.println("numb checking: " + numbCheckingPiece(otherColor(color), state, kingLocation, (color.equals("White")) ? -6 : 6));
		if (1 < numbCheckingPiece(otherColor(color), state, kingLocation, (color.equals("White")) ? -6 : 6)){
			System.out.println(otherColor(color) + "king cannot move away with more than one piece checking, this is checkmate");
			return true;
		}
		System.out.println("only one piece is checking the king");
		canCaptureChecking(otherColor(color), state, kingLocation, (color.equals("White")) ? -6 : 6);
		return true;
	}

	public static boolean canMoveAway(String color, int[][] state, int[] location, int type){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int[] to = new int[] {i,j};
				if (validate(color, location, to, state, false)){
					System.out.println(Arrays.toString(to));
					return true;
				}
			}
		}

		return false;
	}

	public static int numbCheckingPiece(String color, int[][] state, int[] location, int type){
		// for (int[] i: state){
  //   	    System.out.println(Arrays.toString(i));
  //   	}
		color = otherColor(color);
		int counter = 0;
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int pieceID = state[j][i];
				int[] from = new int[] {i,j};
				if (pieceID * type < 0){
					Boolean isValid;
					if (Math.abs(pieceID) != 6){
						isValid = Pieces.validates(true, color, pieceID, from, location, state);
					}else{
						isValid = validate(color, from, location, state, true);
					}
					if (isValid){
						counter += 1;
					}
				}
			}
		}
		return counter;
	}

	public static boolean canCaptureChecking(String color, int[][] state, int[] location, int type){
		// for (int[] i: state){
  //   	    System.out.println(Arrays.toString(i));
  //   	}
		color = otherColor(color);
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int pieceID = state[j][i];
				int[] from = new int[] {i,j};
				if (pieceID * type < 0){
					Boolean isValid;
					if (Math.abs(pieceID) != 6){
						isValid = Pieces.validates(true, color, pieceID, from, location, state);
					}else{
						isValid = validate(color, from, location, state, true);
					}
					if (isValid){
						System.out.println(color + pieceID + "IS CHECKING TEH KING at " 
							+ Arrays.toString(location) + " from "+ Arrays.toString(from));
						return canCapture(color, state, from, type);
					}
				}
			}
		}
		return false;
	}

	public static boolean canCapture(String color, int[][] state, int[] location, int type){
		System.out.println("will now check if it is possible to capture the " + color + " piece at " + Arrays.toString(location));
		return false;
	}

	public static String otherColor(String color){
		if (color.equals("White")){
			return "Black";
		}
		return "White";
	}

}