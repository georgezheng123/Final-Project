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
		int fromX = from[0]; //[down, right]
		int toX = to[0];
		int fromY = from[1];
		int toY = to[1];

		if (fromX<toX && fromY<toY){//upper left
			for (int i=fromX+1, j=fromY+1; i<toX; i++, j++){
				if (state[j][i] != -1){
					return true;
				}
			}
		}
		if (fromX>toX && fromY>toY){//down right
			for (int i=fromX-1, j=fromY-1; i>toX; i--, j--){
				if (state[j][i] != -1){
					return true;
				}
			}
		}
		if (fromX<toX && fromY>toY){//down left
			for (int i=fromX+1, j=fromY-1; i<toX; i++, j--){
				if (state[j][i] != -1){
					return true;
				}
			}
		}
		if (fromX>toX && fromY<toY){//upper right
			for (int i=fromX-1, j=fromY+1; i>toX; i--, j++){
				if (state[j][i] != -1){
					return true;
				}
			}
		}

		
		return false;
	}


}