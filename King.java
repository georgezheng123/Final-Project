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

		isInCheck(state, to);
		return dist == 1.0 || dist == Math.sqrt(2);
	}

	public static boolean isInCheck(int[][] state, int[] location){
		    for (int[] i: state){
        System.out.println(Arrays.toString(i));
    }
    System.out.println(Arrays.toString(location));
		;
		// if (){

		// }
		return false;
	}

}