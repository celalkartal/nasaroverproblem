package com.celalkartal.nasa;

public enum Direction {
	NORTH('N', 1) {
		@Override
		public int updateCoordinate(int y) {
			return ++y;
		}
	},
	EAST('E', 2) {
		@Override
		public int updateCoordinate(int x) {
			return ++x;
		}
	},
	SOUTH('S', 3) {
		@Override
		public int updateCoordinate(int y) {
// TODO Auto-generated method stub
			return --y;
		}
	},
	WEST('W', 4) {
		@Override
		public int updateCoordinate(int x) {
			return --x;
		}
	};

	private char code;
	private int no;

	Direction(char code, int no) {
		this.code = code;
		this.no = no;
	}

	public char getCode() {
		return code;
	}

	public int getNo() {
		return no;
	}

	public abstract int updateCoordinate(int coordinate);

	public static Direction getDirectionByNo(int no) {
		for (Direction d : values()) {
			if (no == d.getNo()) {
				return d;
			}
		}
		throw new IllegalArgumentException("Invalid Command!");
	}

	public static Direction getDirectionByCode(char code) {
		for (Direction d : values()) {
			if (Character.compare(code, d.getCode()) == 0) {
				return d;
			}
		}
		throw new IllegalArgumentException("Invalid Command!:" + code);
	}

}