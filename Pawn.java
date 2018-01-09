import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Pawn extends Pieces{
	
	/*private int color;
	private position Position;*/
	public Pawn(int x, int y, int colors){
		super(x,y,colors);
	}
	
	public Pawn(Position coordinate, int colors){
		super(coordinate,colors);
	}

	//figuring out return statements
	/*public boolean validMove(){
		
	}

	public boolean move(){
		
	}*/
	public String toString(){
		return "";
	}

}