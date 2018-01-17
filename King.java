import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Pieces{

	public static boolean validate(int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];
		int dist = Math.hypot((double) toX, (double) fromX) + Math.hypot((double) toY, (double) fromY);
		
		return dist == Math.sqrt(2);
	}


	public String toString(){
		return "";
	}

}