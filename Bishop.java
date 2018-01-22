import java.util.*;



public class Bishop{
	

	public static boolean validate(String color, int[] from, int[] to){
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		double deltaX = fromX - toX;
		double deltaY = fromY - toY;

		return Math.abs(deltaX) == Math.abs(deltaY) && deltaX != 0.0;
	}

	public static boolean checkUnitCollision(int[] from, int[] to, int[][] state){
		if (!validate("color", from, to)){
			return false;
		}
		int fromX = from[1]; 
		int toX = to[1];

		int fromY = from[0];
		int toY = to[0];
		// System.out.println("bishop coords" + fromX + "," + fromY + "   " + toX + "," + toY + "" );

		if (fromX<toX && fromY<toY){//upper left
			for (int i=fromX+1, j=fromY+1; i<toX; i++, j++){
				if (state[i][j] != 0){
					// System.out.println("state[" + i+"]["+ j + "] is " + state[i][j]);
					// System.out.println("bis a");
					return true;
				}
			}
		}
		if (fromX>toX && fromY>toY){//down right
			for (int i=fromX-1, j=fromY-1; i>toX; i--, j--){
				// System.out.println("state[" + i+"]["+ j + "] is " + state[i][j]);
				if (state[i][j] != 0){
					// System.out.println("bish b");
					return true;
				}
			}
		}
		if (fromX<toX && fromY>toY){//down left
			for (int i=fromX+1, j=fromY-1; i<toX; i++, j--){
				if (state[i][j] != 0){
					// System.out.println("state[" + i+"]["+ j + "] is " + state[i][j]);
					// System.out.println("bish c");
					return true;
				}
			}
		}
		if (fromX>toX && fromY<toY){//upper right
			for (int i=fromX-1, j=fromY+1; i>toX; i--, j++){
				if (state[i][j] != 0){
					System.out.println("bish d");
					return true;
				}
			}
		}
		// System.out.println("bishop authen passed");
		return false;
	}




}