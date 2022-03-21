package com.celalkartal.nasa;

public enum Instruction {
	LEFT('L'), RIGHT('R'), MOVE('M');

	private char command;

	public static Instruction getInstructionByCommand(char command) {
		for (Instruction instruction : values()) {
			if (command == instruction.getCommand()) {
				return instruction;
			}
		}
		throw new IllegalArgumentException("Invalid Command!:" + command);
	}

	Instruction(char command) {
		this.command = command;
	}

	public char getCommand() {
		return command;
	}

}