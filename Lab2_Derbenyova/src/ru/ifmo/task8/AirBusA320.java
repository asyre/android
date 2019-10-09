package ru.ifmo.task8;


class AirBusA320 {
    private double takeOfDistance;
    private double speed;

    public AirBusA320(double takeOfDistance, double speed) {
        this.takeOfDistance = takeOfDistance;
        this.speed = speed;
    }

    void takeOffRun() {
        System.out.println(takeOfDistance);
    }

    void speed() {
        System.out.println(speed);
    }
}
