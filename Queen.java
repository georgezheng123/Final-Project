import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Queen extends Pieces{
	
	public static boolean validate(String color, int[] from, int[] to){

		return Rook.validate(color, from, to) || Bishop.validate(color, from, to);
	}

	public static boolean checkUnitCollision(int[] from, int[] to, int[][] state){
		Boolean bishColl = Bishop.checkUnitCollision(from, to, state);
		Boolean rookColl = Rook.checkUnitCollision(from, to, state);
		return  bishColl || rookColl; 
	}


	public String toString(){
		return "";
	}

}