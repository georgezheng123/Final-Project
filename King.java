import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Pieces{

	public static boolean validate(int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		double dist = Math.hypot(deltaX, deltaY);
		System.out.println(dist);
		return dist == 1.0 || dist == Math.sqrt(2);
	}


	public String toString(){
		return "";
	}

}