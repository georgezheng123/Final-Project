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
		    for (int[] i: state){
        System.out.println(Arrays.toString(i));
    }
		if (fromY == toY) {
			for (int i=Math.min(fromX, toX)+1; i<Math.max(fromX, toX); i++){
					System.out.println(Arrays.toString(from));
					System.out.println(Arrays.toString(to));
					System.out.println(i);
					if (state[fromY][i] == 1){
						return true;
					}
				}}
		if (fromX == toX){for (int i=Math.min(fromY, toY)+1; i<Math.max(fromY, toY); i++){
					System.out.println(i);
					if (state[i][fromX] == 1){
						return true;
					}
				}}
		return false;
	}


	public String toString(){
		return "";
	}

}