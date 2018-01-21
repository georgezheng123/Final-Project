import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class Pawn extends Pieces{
	

	public static boolean validate(String color, int[] from, int[] to, int[][] state){
		int fromX = from[1]; 
		int toX = to[1];

		int fromY = from[0];
		int toY = to[0];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;


		double offset = 1.0;
		if (color.equals("Black")){
			offset = -1.0;
		}

		if (fromX == 6) return deltaY == 0.0 && (deltaX == offset || deltaX == 2.0) && state[5][fromY] == 0;

		if (fromX == 1) return deltaY == 0.0 && (deltaX == offset || deltaX == -2.0)  && state[2][(int)fromY] == 0;
		return deltaY == 0.0 && deltaX == offset;
	}

	public static boolean pawnCaptureValidate(String color, int[] from, int[] to){
		int fromX = from[1]; 
		int toX = to[1];

		int fromY = from[0];
		int toY = to[0];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;
		
		double offset = 1.0;
		if (color.equals("Black")){
			offset = -1.0;
		}

		return Math.abs(deltaY) == 1 && deltaX == offset;
	}

	public String toString(){
		return "pawn";
	}

}