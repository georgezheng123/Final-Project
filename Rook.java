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
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		System.out.println("from" + Arrays.toString(from));
		System.out.println("to" + Arrays.toString(to));
		//     for (int[] i: state){
  //       System.out.println(Arrays.toString(i));
  //   }
		if (fromY == toY) { 
			//System.out.println("upToDown");	
			for (int i=Math.min(fromX, toX)+1; i<Math.max(fromX, toX); i++){

					if (state[i][fromY] != 0){
					System.out.println(i + " " + fromY);

				System.out.println(state[fromY][i]);
						System.out.println("rook authen failed");
						return true;
					}
					System.out.println(fromY + " " + i);
				}}
		if (fromX == toX){for (int i=Math.min(fromY, toY)+1; i<Math.max(fromY, toY); i++){
					if (state[fromX][i] != 0){
						System.out.println(i + " " + fromX);
						System.out.println("rook authen failed");
				System.out.println(state[i][fromX]);
						return true;
					}
				}}
		System.out.println("rook unit collision passed");
		return false;
	}


	public String toString(){
		return "";
	}

}