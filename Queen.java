import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Queen extends Pieces{
	
	public static boolean validate(String color, int[] from, int[] to){

		return Rook.validate(color, from, to) || Bishop.validate(color, from, to);
	}

	public static boolean checkUnitCollision(int[] from, int[] to, int[][] state){
		System.out.println(!Bishop.checkUnitCollision(from, to, state));
		System.out.println(!Rook.checkUnitCollision(from, to, state));
		return !Bishop.checkUnitCollision(from, to, state) || !Rook.checkUnitCollision(from, to, state); 
	}


	public String toString(){
		return "";
	}

}