package org.example;

import java.util.PriorityQueue;

public class Pier {
    private final int MINIMUM_SEATS_IN_BOAT = 1;
    private final int MAXIMUM_SEATS_IN_BOAT = 20;
    private Boat boat;
    private final PriorityQueue<Passenger> passengers;

    public Pier() {
        this.boat = null;
        this.passengers = new PriorityQueue<>();
    }

    public Boat getBoat() {
        return this.boat;
    }

    public PriorityQueue<Passenger> getPassengers() {
        return passengers;
    }

    public void addBoat() {
        this.boat = new Boat(MINIMUM_SEATS_IN_BOAT, MAXIMUM_SEATS_IN_BOAT);
    }

    public void addPassengers(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removeBoat() {
        this.boat = null;
    }
}
