package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final float TIME_BETWEEN_BOATS = 25.0f;  //in minutes
    private static final float TIME_BETWEEN_PASSENGERS = 2.0f;  //in minutes
    private static final int MAXIMUM_PASSENGER_ON_THE_PIER = 10;

    public static void main(String[] args) {
        Pier pier = new Pier();
        while(true) {
            pier.addBoat();
            for (int i = 0; i < TIME_BETWEEN_BOATS/TIME_BETWEEN_PASSENGERS; i ++ ) {
                pier.addPassengers(new Passenger());
                if(pier.getBoat() != null && !pier.getBoat().isLastStation() &&
                        pier.getBoat().getSeats() <= pier.getPassengers().size()) {
                    float averagePassengerTimeOnThePier = 0;
                    int tripsQuantityBeforeN = 0;
                    float boatTime = -1;
                    if (pier.getPassengers().size() > MAXIMUM_PASSENGER_ON_THE_PIER) {
                        boatTime = pier.getBoat().getSeats() * TIME_BETWEEN_PASSENGERS - TIME_BETWEEN_PASSENGERS;
                        if (boatTime > TIME_BETWEEN_BOATS) {
                            boatTime = TIME_BETWEEN_BOATS;
                        }
                        int passengerQuantityOnPier = pier.getPassengers().size();
                        while(passengerQuantityOnPier > MAXIMUM_PASSENGER_ON_THE_PIER) {
                            passengerQuantityOnPier -=  pier.getBoat().getSeats();
                            passengerQuantityOnPier += (int)(boatTime/TIME_BETWEEN_PASSENGERS);
                            tripsQuantityBeforeN++;
                        }
                    }
                    for (int j = 0; j < pier.getBoat().getSeats(); j++) {
                        averagePassengerTimeOnThePier += pier.getPassengers().remove().getTimeOnTheStation();
                    }
                    averagePassengerTimeOnThePier /= pier.getBoat().getSeats();
                    System.out.println("\nThe boat was with " + pier.getBoat().getSeats() + " seats. The average " +
                            "time of passenger's waiting for the boat is " +
                            String.format(Locale.US, "%.2f", averagePassengerTimeOnThePier) +
                            " minutes.");
                    if (tripsQuantityBeforeN > 0) {
                        System.out.println("This boat (with " + pier.getBoat().getSeats() +
                                " seats) has to travel each " + boatTime + " minutes.");
                        System.out.println("After " + tripsQuantityBeforeN + " times, quantity of passengers " +
                                "on pier will be less than " + MAXIMUM_PASSENGER_ON_THE_PIER);
                    }
                    pier.removeBoat();
                }
                if (!pier.getPassengers().isEmpty()) {
                    for (Passenger passenger : pier.getPassengers()) {
                        passenger.addTimeOnTheStation(TIME_BETWEEN_PASSENGERS);
                    }
                }
            }
            if(pier.getBoat() != null) {
                pier.removeBoat();
            }
            System.out.print("\nDo you want to stop the simulation of the pier? yes/(any other key): ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                break;
            }
        }
    }
}