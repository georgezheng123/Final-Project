import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Queen extends Pieces{
	
	public static boolean validate(String color, int[] from, int[] to){

		return Rook.validate(color, from, to) || Rook.validate(color, from, to);
	}

	public String toString(){
		return "";
	}

}