package org.example;

public class Passenger implements Comparable<Passenger> {
    private float timeOnTheStation;

    public Passenger() {
        this.timeOnTheStation = 0;
    }

    public float getTimeOnTheStation() {
        return timeOnTheStation;
    }

    public void addTimeOnTheStation(float timeOnTheStation) {
        this.timeOnTheStation += timeOnTheStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        return Float.compare(passenger.timeOnTheStation, timeOnTheStation) == 0;
    }

    @Override
    public int hashCode() {
        return (timeOnTheStation != 0.0f ? Float.floatToIntBits(timeOnTheStation) : 0);
    }

    @Override
    public int compareTo(Passenger o) {
        return Float.compare(o.timeOnTheStation, timeOnTheStation);
    }
}
