package task1255;

import java.util.*;

public class IntersectionMain {

	/**
	 * Number of roads crossed in intersection
	 */
	private static int roadsQuantity = 2;

	/**
	 * Simulation duration (seconds)
	 */
	private static int simulationduration = 1_000_000;

	/**
	 * Intersection runner. Does all work :)
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); //reader of input
		System.out.print("Enter generation chance: "); //input example: 0,33
		double chance = sc.nextDouble();
		if (chance > 1 || chance < 0) {
			throw new OutOfPossibleRangeException();
		}
		System.out.println();
		System.out.print("Enter traffic light duration: ");
		int lightDuration = sc.nextInt();
		System.out.println();

		Road[] roads = new Road[roadsQuantity * 2];
		for (int i = 0; i < roads.length; i++) {
			roads[i] = new Road(i);
		}
		//we will use this to calc avg load. long - to avoid overflowing int value
		long[] queueSumm = new long[roads.length];
		int[] generatedSumm = new int[roads.length];


		for (int i = 0; i < simulationduration; i++) {

			//for each step we can add a car to queue
			for (Road road : roads) {
				if (Math.random() < chance) {
					road.addCar();
					generatedSumm[road.getId()]++;
				}
			}

			for (int j = 0; j < roads.length; j++) {
				roads[j].setGreenLight(j / 2 == ((i / lightDuration) % roadsQuantity));
			}

			for (Road road : roads) {
				if (road.isGreenLight()) {
					road.passCar();
				}
			}

			for (int ptr = 0; ptr < roads.length; ptr++) {
				queueSumm[ptr] += roads[ptr].queueSize();
			}
		}

		System.out.println("Average load on each");
		for (int i = 0; i < roads.length; i++) {
			System.out.print("Road " + (i+1) + ": \t");
			System.out.print("avg. delay = " + (double) queueSumm[i] / simulationduration + ", \t");
			System.out.print("total delay = " + queueSumm[i] + ", \t");
			System.out.print("cars passed = " + generatedSumm[i]);
			System.out.println();
		}
	}

}
