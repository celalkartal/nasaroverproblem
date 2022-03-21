package com.celalkartal.nasa;

import java.util.Scanner;

public class NasaApplication {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input For Plateau:");
			String lineData = scanner.nextLine();
			String[] lineDataArray = lineData.split(" ");
			if (lineDataArray.length != 2) {
				throw new IllegalArgumentException(
						"Invalid upper-right coordinate or lower-right coordinate of Plateau!");
			}
			int upperRightCoordinate = Integer.valueOf(lineDataArray[0]);
			int lowerRightCoordinate = Integer.valueOf(lineDataArray[1]);
			Grid plateau = new Grid(upperRightCoordinate, lowerRightCoordinate);
			System.out.println("\nInput For Rover(Exit?'Y')");
			String firstLineData = scanner.nextLine();
			while (!"Y".equals(firstLineData)) {
				String[] firstLineDataArray = firstLineData.split(" ");
				if (firstLineDataArray.length != 3) {
					throw new IllegalArgumentException("Invalid Rover Position!");
				}
				String[] roverFirstLineDataArray = firstLineData.split(" ");
				Rover rover = new Rover(plateau);
				rover.setX(Integer.valueOf(roverFirstLineDataArray[0]));
				rover.setY(Integer.valueOf(roverFirstLineDataArray[1]));
				rover.setCurrentDirectionCode(roverFirstLineDataArray[2].charAt(0));
				String secondLineData = scanner.nextLine();
				rover.process(secondLineData);

				System.out.println("\nOUTPUT:");
				rover.printPosition();
				System.out.println("\nInput For Next Rover(Exit?'Y')");
				firstLineData = scanner.nextLine();
			}
		}

	}
}