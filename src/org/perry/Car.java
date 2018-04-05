package org.perry;

public class Car {
	private Position position = Position.NORTH;
	private static final char STEER_LEFT = 'L';
	private static final char STEER_RIGHT = 'R';
	private static final char FORWARD = 'F';
	private static final String COMMAND_PATTERN = "([1-9]|[1][0-5]),([1-9]|[1][0-5]):[F|L|R]+";
	private ParkingSlot movedSlot;

	public ParkingSlot navigateParking(String command, ParkingLot lot) {

		if (command == null || lot == null) {
			throw new IllegalArgumentException("Parameters are mandatory");
		}

		if (!command.matches(COMMAND_PATTERN)) {
			throw new IllegalArgumentException("Command Pattern is invalid");
		}

		String[] commandArr = command.split(":");
		String startCoordinates = commandArr[0];
		String path = commandArr[1];

		String[] startCoordinatesArr = startCoordinates.split(",");
		ParkingSlot currentSlot = new ParkingSlot(Integer.valueOf(startCoordinatesArr[0]),
				Integer.valueOf(startCoordinatesArr[1]));

		for (char action : path.toCharArray()) {
			if (action == STEER_RIGHT || action == STEER_LEFT)
				steerCar(action);
			if (action == FORWARD)
				currentSlot = move(currentSlot, lot);
		}

		position = Position.NORTH;
		movedSlot = currentSlot;

		return movedSlot;
	}

	private void steerCar(char action) {
		boolean isSteerRight = action == STEER_RIGHT;
		switch (position) {
		case NORTH:
			position = isSteerRight ? Position.EAST : Position.WEST;
			break;
		case EAST:
			position = isSteerRight ? Position.SOUTH : Position.NORTH;
			break;
		case WEST:
			position = isSteerRight ? Position.NORTH : Position.SOUTH;
			break;
		case SOUTH:
			position = isSteerRight ? Position.WEST : Position.EAST;
			break;
		}
	}

	private ParkingSlot move(ParkingSlot currentSlot, ParkingLot lot) {
		switch (position) {
		case NORTH:
			movedSlot = lot.parkingSlots[currentSlot.getX()][currentSlot.getY() + 1];
			break;
		case EAST:
			movedSlot = lot.parkingSlots[currentSlot.getX() + 1][currentSlot.getY()];
			break;
		case WEST:
			movedSlot = lot.parkingSlots[currentSlot.getX() - 1][currentSlot.getY()];
			break;
		case SOUTH:
			movedSlot = lot.parkingSlots[currentSlot.getX()][currentSlot.getY() - 1];
			break;
		default:
			movedSlot = currentSlot;
		}
		return movedSlot;
	}

	public ParkingSlot getMovedSlot() {
		return movedSlot;
	}

}
