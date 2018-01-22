import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;


public class Rook extends Pieces{
	
	public static boolean validate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		return deltaX == 0.0 ^ deltaY == 0.0;
	}

	public static boolean checkUnitCollision(int[] from, int[] to, int[][] state){
		int fromX = from[1];
		int fromY = from[0];
		int toX = to[1];
		int toY = to[0];

		// System.out.println("rook:" + fromX + "," + fromY + "   " + toX + "," + toY + "" );



		//     for (int[] i: state){
  //       System.out.println(Arrays.toString(i));
  //   }
		if (fromY == toY) { 
			// System.out.println("rook a, rook collision failed");	
			for (int i=Math.min(fromX, toX)+1; i<Math.max(fromX, toX); i++){
					// System.out.println(i + " " + fromY);
					if (state[i][fromY] != 0){
					// System.out.println(state[i][fromY]);
					// 	System.out.println("rook authen failed");
						return true;
					}
				}}
		if (fromX == toX){
			// System.out.println("rook b, rook collision failed");	
			for (int i=Math.min(fromY, toY)+1; i<Math.max(fromY, toY); i++){
				    // System.out.println(fromX + " " + i);		
	
					
					if (state[fromX][i] != 0){
						// System.out.println(state[fromX][i]);
						return true;
					}
				}}
		return false;
	}


	public String toString(){
		return "";
	}

}