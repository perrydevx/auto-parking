package org.perry;

public class AutoParking {

	public static void main(String[] args) {
		String s1 = "5,5:RFLFRFLF"; // "7,7";
		String s2 = "6,6:FFLFFLFFLFF"; // "6,6";
		String s3 = "5,5:FLFLFFRFFF"; // "4,1"

		AutoParking ap = new AutoParking();

		System.out.println("----------------------------");
		String result = ap.runDemo(s1);
		System.out.println("position: " + result);

		System.out.println("----------------------------");
		String result2 = ap.runDemo(s2);
		System.out.println("position: " + result2);

		System.out.println("----------------------------");
		String result3 = ap.runDemo(s3);
		System.out.println("position: " + result3);
	}

	private String runDemo(String commands) {
		System.out.println("input: " + commands);

		ParkingLot lot = new ParkingLot();
		Car car = new Car();
		car.navigateParking(commands, lot);

		return car.getMovedSlot().toString();
	}

}
