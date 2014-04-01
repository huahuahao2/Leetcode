class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Max_Points_on_a_Line {

	
	public static void main(String[] args) {
		Point[] points = {new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};//new Point[4];
		Point[] points1 = {new Point(0,9),new Point(0,9),new Point(0,9)};
		//points[0] = new Point(1,1);
		//points[1] = new Point(2,2);
		//points[2] = new Point(2,3);
		//points[3] = new Point(4,4);
		System.out.println(maxPoints(points1));
	}
	public static int maxPoints(Point[] points) {
		int max = 0;
		int count = 0;
		int counti = 0;
		int countx = 0;
		for (int i = 0; i < points.length; i++) {
			counti = 1;
			for (int j = i+1; j < points.length; j++) {
				//count++;
				if (samePoint(points[i], points[j])) {
					counti++;
					continue;
				}
				else {
					count = counti+1;
				}
				countx = count;
				for(int x = j + 1; x < points.length; x++) {
					if (sameLine(points[i], points[j], points[x]))
						countx++;
				}
				
				if (countx > max)
					max = countx;
			}
			if (counti > max)
				max = counti;
		}
		return max;
	}
	
	public static boolean sameLine(Point a, Point b, Point c) {
		return ((a.x-b.x)*(b.y-c.y) == (b.x-c.x)*(a.y-b.y));
	}
	
	public static boolean samePoint(Point a, Point b) {
		return a.x==b.x && a.y==b.y;
	}
}
