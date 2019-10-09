package ru.ifmo.task8;

public class AirBusA380 extends AirBusA320 {
    private int seatNumbers;

    public AirBusA380(double takeOfDistance, double speed, int seatNumbers) {
        super(takeOfDistance, speed);
        this.seatNumbers = seatNumbers;
    }

    void seats() {
        System.out.println(seatNumbers);
    }
}
