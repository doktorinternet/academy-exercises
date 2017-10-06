package com.company.week2.day3.car;

public class Car {

    private String model;
    private Door [] doors;
    private Tire [] tires;
    private float weight;

    Car(String model, int amountDoors, int amountTires, float weight){
        this.model = model;
        this.weight = weight;
        doors = new Door[amountDoors];
        tires = new Tire[amountTires];
        mount(doors);
        mount(tires);
    }

    private void mount(Door [] doors){
        for (int i = 0; i < doors.length-1; i++){
            this.doors[i] = new Door();
        }
    }

    private void mount(Tire [] tires){
        for (int i = 0; i < tires.length-1; i++){
            this.tires[i] = new Tire();
        }
    }

    private double weighs(){
        double result = 0.0;

        result += this.doors.length*new Door().weighs();
        result += this.tires.length*new Tire().weighs();
        result += this.weight;
        return result;
    }

    public static void run(){
        Car bigCar = new Car("Volvo", 6, 4, 1500);
        Car sedan = new Car("Saab", 4, 4, 1000);
        Car ecoCar = new Car("Ford", 2, 4, 750);


        System.out.println("The larger car weighs: " + bigCar.weighs() + " kg");
        System.out.println("The standard size car weighs: " + sedan.weighs()+ " kg");
        System.out.println("The smaller car weighs: " + ecoCar.weighs()+ " kg");
    }
}
