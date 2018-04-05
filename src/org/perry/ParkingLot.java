package org.perry;

public class ParkingLot {
	ParkingSlot[][] parkingSlots = new ParkingSlot[16][16];

	public ParkingLot() {
		for (int i = 1; i < parkingSlots.length; i++) {
			for (int j = 1; j < parkingSlots.length; j++) {
				this.parkingSlots[i][j] = new ParkingSlot(i, j);
			}
		}
	}
}
