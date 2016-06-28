package task1255;

import java.util.UUID;

/**
 * Car object to put in system
 */
public class Car {

	/**
	 * Identifier of car
	 */
	private String id;

	/**
	 * No-args constructor generates 8-chf
	 */
	public Car() {
		this.id = UUID.randomUUID().toString().substring(0,8);
	}

	/**
	 * @return car ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Manually sets id
	 * @param id to be set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
