package org.example;

import java.util.Random;

public class Boat {
    private final int seats;
    private final boolean lastStation;

    public Boat(int minimumSeatsInBoat, int maximumSeatInBoat) {
        Random random = new Random();
        this.seats = random.nextInt(minimumSeatsInBoat) + maximumSeatInBoat;
        this.lastStation = random.nextBoolean();
    }

    public int getSeats() {
        return seats;
    }

    public boolean isLastStation() {
        return lastStation;
    }
}
