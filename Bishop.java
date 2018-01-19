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
		int fromX = from[0];
		int fromY = from[1];
		int toX = to[0];
		int toY = to[1];

		if (toX - fromX > 1){
			for (int i=fromX+1; i<toX; i++){
					if (){

					}
				}
		}
		return false;
	}


}