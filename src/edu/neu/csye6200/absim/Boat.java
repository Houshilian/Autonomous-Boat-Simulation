package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

public class Boat {
	private Integer x;      //boat's position on the ocean (coordinates)
	private Integer y;

	private Character horizontalDirection = DirectionEnum.EAST.getDirection();     //direction
	private Character verticalDirection = DirectionEnum.SOUTH.getDirection();
	private Integer speed = 1;     //the speed of the boat

	public Boat(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}

	//Move the boat
	public void Move(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	//Clean up the location of the boat
	public void Clean(OceanGrid oceanGrid){
		oceanGrid.setWater(this.x, this.y);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Character getHorizontalDirection() {
		return horizontalDirection;
	}

	public void setHorizontalDirection(Character horizontalDirection) {
		this.horizontalDirection = horizontalDirection;
	}

	public Character getVerticalDirection() {
		return verticalDirection;
	}

	public void setVerticalDirection(Character verticalDirection) {
		this.verticalDirection = verticalDirection;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
}
