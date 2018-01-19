import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class Pawn extends Pieces{
	

	public static boolean validate(String color, int[] from, int[] to, int[][] state){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		double offset = 1.0;
		if (color.equals("Black")){
			offset = -1.0;
		}

		if (fromY == 6) return deltaX == 0.0 && (deltaY == offset || deltaY == 2.0) && state[5][fromX] == 0;
		if (fromY == 1) return deltaX == 0.0 && (deltaY == offset || deltaY == -2.0)  && state[2][fromX] == 0;

		return deltaX == 0.0 && deltaY == offset;
	}

	public static boolean pawnCaptureValidate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		double offset = 1.0;
		if (color.equals("Black")){
			offset = -1.0;
		}

		return Math.abs(deltaX) == 1 && deltaY == offset;
	}

	public String toString(){
		return "pawn";
	}

}