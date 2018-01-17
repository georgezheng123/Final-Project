import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Pawn extends Pieces{
	

	public static boolean validate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		int offset = 1;
		if (color.equals("White")){
			offset = -1;
		};

		return deltaX == 0 && deltaY == offset;
	}

	public String toString(){
		return "";
	}

}