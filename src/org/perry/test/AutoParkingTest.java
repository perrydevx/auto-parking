package org.perry.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.perry.Car;
import org.perry.ParkingLot;

class AutoParkingTest {
	ParkingLot lot = new ParkingLot();
	Car car = new Car();

	@Test
	void whenNullParamsThenThrowError() {
		assertThrows(IllegalArgumentException.class, () -> car.navigateParking(null, null));
	}

	@Test
	void whenInvalidCommandPatternThenThrowError() {
		assertThrows(IllegalArgumentException.class, () -> car.navigateParking("ABC", lot));
		assertThrows(IllegalArgumentException.class, () -> car.navigateParking("1,2", lot));
		assertThrows(IllegalArgumentException.class, () -> car.navigateParking("1,2:", lot));
		assertThrows(IllegalArgumentException.class, () -> car.navigateParking("16,5:FFFL", lot));
	}

	@Test
	void whenCommandEnteredThenMove() {
		car.navigateParking("5,5:RFLFRFLF", lot);
		assertEquals("7,7", car.getMovedSlot().toString());

		car.navigateParking("6,6:FFLFFLFFLFF", lot);
		assertEquals("6,6", car.getMovedSlot().toString());

		car.navigateParking("5,5:FLFLFFRFFF", lot);
		assertEquals("4,1", car.getMovedSlot().toString());
	}

}
