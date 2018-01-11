import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Pieces{

	public King(int x, int y, int colors){
		super(x,y,colors);
	}
	
	public King(Position coordinate, int colors){
		super(coordinate,colors);
	}

	public String toString(){
		return "";
	}

}