package com.gotocme.rvita;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rectangles {

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);

		int numberOfRectangles = 0;
		System.out.println("Number of rectangles: ");
		numberOfRectangles = sc.nextInt();

		/**
		 * Creates a list of rectangles using the 2 pair of numbers which are x and y
		 * positions of each opposing corner, provided by the user to calculate the x
		 * and y minimum and the height and width of each rectangle
		 **/
		List<Rectangle2D> rect = new ArrayList<Rectangle2D>();
		double[] coordinates = new double[4];
		double x, y, h, w;
		for (int i = 0; i < numberOfRectangles; i++) {
			System.out.println("Enter (x1, y1) (x2, y2): ");
			for (int j = 0; j <= 3; j++) {
				coordinates[j] = sc.nextDouble();
			}
			x = Math.min(coordinates[0], coordinates[2]);
			y = Math.min(coordinates[1], coordinates[3]);
			h = height(coordinates[1], coordinates[3]);
			w = width(coordinates[0], coordinates[2]);
			rect.add(new Rectangle2D.Double(x, y, w, h));

		}
		sc.close();

		/**
		 * In the first loop, the first two rectangles are compared. If there are more
		 * rectangles, it continues comparing the new rectangle created, based on the
		 * intersection, with the next rectangle. Update a flag to indicate if there is
		 * an intersection or not, and then calculate the area or return a message.
		 **/

		Rectangle2D intersection = new Rectangle2D.Double();
		boolean area = false;

		for (int i = 0; i < rect.size() - 1; i++) {
			if (i == 0) {
				if (rect.get(i).intersects(rect.get(i + 1))) {
					intersection = rect.get(i).createIntersection(rect.get(i + 1));
					area = true;
				} else {
					area = false;
				}
			} else {
				if (intersection.intersects(rect.get(i + 1))) {
					intersection = intersection.createIntersection(rect.get(i + 1));
					area = true;
				} else {
					area = false;
				}
			}
		}

		/**
		 * If there is intersection between the rectangles it calculates the area of the
		 * intersection and returns the result, if there is no intersection, returns "No
		 * intersection" message
		 **/
		if (area) {
			System.out.format("Area: %.2f%n", +area(intersection.getWidth(), intersection.getHeight()));

		} else {
			System.out.println("No intersection");
		}

	}

	/**
	 * Calculate the height of the rectangle
	 * 
	 * @param y1
	 *            the first y provided by use
	 * @param y2
	 *            the second y provided by use
	 * @return returns the subtraction between y1 and y2
	 */
	public static double height(double y1, double y2) {
		return Math.abs(y2 - y1);
	}

	/**
	 * Calculate the width of the rectangle
	 * 
	 * @param x1
	 *            the first x provided by user
	 * @param x2
	 *            the second x provided by user
	 * @return returns the subtraction between x1 and x2
	 */

	public static double width(double x1, double x2) {
		return Math.abs(x2 - x1);
	}

	/**
	 * Calculate the area of the rectangle
	 * 
	 * @param w
	 *            the width of the rectangle previously calculated
	 * @param h
	 *            the height of the rectangle previously calculated
	 * @return returns the area making the multiplication between the width and the
	 *         height
	 */
	public static double area(double w, double h) {
		return Math.abs(w * h);
	}

}
