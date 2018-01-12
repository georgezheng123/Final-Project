import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Queen extends Pieces{
	
	public Queen(int x, int y, int colors){
		super(x,y,colors);
	}
	
	public Queen(Position coordinate, int colors){
		super(coordinate,colors);
	}

	public String toString(){
		return "";
	}

}