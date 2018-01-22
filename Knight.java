import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Knight extends Pieces{
	

	public static boolean validate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = Math.abs(fromX - toX);
		double deltaY = Math.abs(fromY - toY);

		Boolean sleepingL = (deltaX == 2.0) && (deltaY == 1.0); 
		Boolean upwardsL = (deltaX == 1.0) && (deltaY == 2.0);

		return sleepingL || upwardsL;
	}

}