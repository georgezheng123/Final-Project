import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Pawn extends Pieces{
	

	public Pawn(int x, int y, int colors){
		super(x,y,colors);
	}
	
	public Pawn(Position coordinate, int colors){
		super(coordinate,colors);
	}

	public String toString(){
		return "";
	}

}