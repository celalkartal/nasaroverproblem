package com.celalkartal.nasa;

public enum Instruction {
	LEFT('L'), RIGHT('R'), MOVE('M');

	private char command;

	public static Instruction getInstructionByCommand(char command) {
		for (Instruction i : values()) {
			if (command == i.getCommand()) {
				return i;
			}
		}
		throw new IllegalArgumentException("Invalid Command!");
	}

	Instruction(char command) {
		this.command = command;
	}

	public char getCommand() {
		return command;
	}

}