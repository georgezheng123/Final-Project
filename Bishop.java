import java.util.*;


public class Bishop{
	

	public static boolean validate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		return Math.abs(deltaX) == Math.abs(deltaY) && deltaX != 0;
	}

	public static boolean checkUnitCollision(int[] from, int[] to, int[][] state){
		if (!validate("color", from, to)){
			return false;
		}
		int fromX = from[0]; //[down, right]
		int toX = to[0];
		int fromY = from[1];
		int toY = to[1];

		System.out.println("from" + Arrays.toString(from));
		System.out.println("to" + Arrays.toString(to));

		if (fromX<toX && fromY<toY){//upper left
			for (int i=fromX+1, j=fromY+1; i<toX; i++, j++){
				if (state[j][i] != 0){
					System.out.println("state[j][i] is " + state[j][i]);
					System.out.println("a");
					return true;
				}
			}
		}
		if (fromX>toX && fromY>toY){//down right
			for (int i=fromX-1, j=fromY-1; i>toX; i--, j--){
				if (state[j][i] != 0){
					System.out.println("b");
					return true;
				}
			}
		}
		if (fromX<toX && fromY>toY){//down left
			for (int i=fromX+1, j=fromY-1; i<toX; i++, j--){
				if (state[j][i] != 0){
					System.out.println("c");
					return true;
				}
			}
		}
		if (fromX>toX && fromY<toY){//upper right
			for (int i=fromX-1, j=fromY+1; i>toX; i--, j++){
				if (state[j][i] != 0){
					System.out.println("d");
					return true;
				}
			}
		}
		System.out.println("bishop authen passed");
		return false;
	}




}