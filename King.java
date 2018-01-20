import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class King extends Pieces{

	public static boolean validate(String color, int[] from, int[] to, int[][] state){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		double dist = Math.hypot(deltaX, deltaY);

		isInCheck(color, state, to, (color.equals("White")) ? 6 : -6);
		return dist == 1.0 || dist == Math.sqrt(2);
	}

	public static boolean isInCheck(String color, int[][] state, int[] location, int type){
		int[] tempLoc = new int[] {location[1], location[0]};
		// for (int[] i: state){
  //   	    System.out.println(Arrays.toString(i));
  //   	}
		;
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				int pieceID = state[j][i];
				int[] from = new int[] {j,i};
				int counter = 0;
				if (Math.abs(pieceID) != 6 && pieceID * type < 0){
					Boolean isValid = Pieces.validates(true, color, pieceID, from, tempLoc, state);
					if (isValid){
						counter += 1;
						for (int[] k: state){
    	    System.out.println(Arrays.toString(k));
    	}
						// System.out.println("\n\n" + pieceID + "" + Arrays.toString(from));
						// System.out.println("king is at"  + Arrays.toString(tempLoc));
						System.out.println(pieceID + "IS CHECKING TEH KING");
						System.out.println("Total pieces checking king"+ counter+ "\n\n");
					}
				}
			}
		}
		return false;
	}

}