package task1255;

import java.util.LinkedList;

/**
 * Road presentation of system
 */
public class Road {

	/**
	 * Queue of cars. According to task - we can use LinkedList
	 */
	private LinkedList<Car> stack;
	/**
	 * if this is true, cars can pass the intersection
	 */
	private boolean greenLight;
	/**
	 * Road ID
	 */
	private final int id;

	/**
	 * Default constructor
	 * @param i - id of route
	 */
	public Road(int i) {
		stack = new LinkedList<>();
		greenLight = false;
		id = i;
	}

	/**
	 * Add a car to Queue
	 */
	public void addCar() {
		stack.add(new Car());
	}

	//getters and setters below

	public Car passCar() {
		return stack.poll();
	}

	public int queueSize() {
		return stack.size();
	}

	public boolean isGreenLight() {
		return greenLight;
	}

	public void setGreenLight(boolean greenLight) {
		this.greenLight = greenLight;
	}

	public int getId() {
		return id;
	}
}
