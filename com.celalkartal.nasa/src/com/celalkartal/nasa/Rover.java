package com.celalkartal.nasa;

public class Rover {

	private int x;
	private int y;
	private char currentDirectionCode;
	Grid grid;

	public Rover(Grid grid) {
		currentDirectionCode = Direction.NORTH.getCode();
		this.grid = grid;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x > grid.getX()) {
			throw new IllegalArgumentException("Out of X coordinate!:" + x);
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y > grid.getY()) {
			throw new IllegalArgumentException("Out of Y coordinate!:" + y);
		}
		this.y = y;
	}

	public char getCurrentDirectionCode() {
		return currentDirectionCode;
	}

	public void setCurrentDirectionCode(char currentDirectionCode) {
		this.currentDirectionCode = currentDirectionCode;
	}

	public void printPosition() {
		Direction direction = Direction.getDirectionByCode(currentDirectionCode);
		System.out.println(getX() + " " + getY() + " " + direction.getCode());
	}

	public void process(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			Instruction instruction = Instruction.getInstructionByCommand(instructions.charAt(i));
			if (Instruction.RIGHT.name().equals(instruction.name())) {
				turnRight();
			} else if (Instruction.LEFT.name().equals(instruction.name())) {
				turnLeft();
			} else if (Instruction.MOVE.name().equals(instruction.name())) {
				moveForward();
			}
		}
	}

	private void turnLeft() {
		Direction currentDirection = Direction.getDirectionByCode(currentDirectionCode);
		int directionNo = (currentDirection.getNo() - 1) < Direction.NORTH.getNo() ? Direction.WEST.getNo()
				: currentDirection.getNo() - 1;
		Direction direction = Direction.getDirectionByNo(directionNo);
		setCurrentDirectionCode(direction.getCode());

	}

	private void turnRight() {
		Direction currentDirection = Direction.getDirectionByCode(currentDirectionCode);
		int directionNo = (currentDirection.getNo() + 1) > Direction.WEST.getNo() ? Direction.NORTH.getNo()
				: currentDirection.getNo() + 1;
		Direction direction = Direction.getDirectionByNo(directionNo);
		setCurrentDirectionCode(direction.getCode());

	}

	private void moveForward() {
		Direction direction = Direction.getDirectionByCode(currentDirectionCode);
		if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			setY(direction.updateCoordinate(getY()));
		} else if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST)) {
			setX(direction.updateCoordinate(getX()));
		}

	}
}