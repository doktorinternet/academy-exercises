package com.company.week2.day3.car;

class CarPart{

    private float weight;

    CarPart(double weight)
    {this.weight = (float) weight;}

    float weighs()
    {return weight;}
}

class Door extends CarPart{
    Door()
    {super(150);}
}

class Tire extends CarPart{
    Tire()
    {super(100);}
}
