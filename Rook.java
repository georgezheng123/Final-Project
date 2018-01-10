import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Rook extends Pieces{
	
	public Rook(int x, int y, int colors){
		super(x,y,colors);
	}
	
	public Rook(Position coordinate, int colors){
		super(coordinate,colors);
	}

	public String toString(){
		return "";
	}

}