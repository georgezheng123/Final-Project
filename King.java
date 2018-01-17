import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Pieces{

	public static boolean validate(int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];
		return Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) != Math.sqrt(2);
	}


	public String toString(){
		return "";
	}

}