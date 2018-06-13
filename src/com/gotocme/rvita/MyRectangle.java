package com.gotocme.rvita;

public class MyRectangle {
	double x;
	double y;
	double width;
	double height;

	public MyRectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public static void main(String[] args) {
		MyRectangle r1 = new MyRectangle(-3.5, 1, 4.5, 3);
		MyRectangle r2 = new MyRectangle(-2.5, -1, 3.5, 4.5);

		if (findOverlap(r1, r2) != null) {
			System.out.println(area(findOverlap(r1, r2)));
		} else {
			System.out.println("No intersection");
		}
	}

	private static double area(MyRectangle findOverlap) {
		double sum = 0.0;
		sum = Math.abs(findOverlap.height * findOverlap.width);
		return sum;
	}
	
	static MyRectangle findOverlap(MyRectangle r1, MyRectangle r2) {
		double overlapX;
		double overlapY;
		double overlapWidth;
		double overlapHeight;

		MyRectangle leftRect;
		MyRectangle rightRect;

		MyRectangle upperRect;
		MyRectangle lowerRect;

		// determinate left and right
		if (r1.x <= r2.x) {
			leftRect = r1;
			rightRect = r2;
		} else {
			leftRect = r2;
			rightRect = r1;
		}

		// determinate upper and lower
		if (r1.y <= r2.y) {
			upperRect = r1;
			lowerRect = r2;
		} else {
			upperRect = r2;
			lowerRect = r1;
		}

		// calculate the overlapWidth
		if (leftRect.x + leftRect.width <= rightRect.x) {
			// no overlap
			return null;
		} else if (leftRect.x + leftRect.width >= rightRect.x + rightRect.width) {
			// fully overlapped
			overlapWidth = rightRect.width;
		} else {
			// partial overlap
			overlapWidth = leftRect.x + leftRect.width - rightRect.x;
		}

		// calculate the ovelapHeight
		if (upperRect.y + upperRect.height <= lowerRect.y) {
			// no overlap
			return null;
		} else if (upperRect.y + upperRect.height >= lowerRect.y + lowerRect.height) {
			// fully overlapped
			overlapHeight = lowerRect.height;
		} else {
			// partial overlap
			overlapHeight = upperRect.y + upperRect.height - lowerRect.y;
		}

		overlapX = rightRect.x;
		overlapY = lowerRect.y;

		return new MyRectangle(overlapX, overlapY, overlapWidth, overlapHeight);

	}



	@Override
	public String toString() {
		return "MyRectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

}
