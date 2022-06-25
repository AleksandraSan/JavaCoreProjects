package ru.homework.my;

public class Water extends Obstacle {
    private int distanсeSwim;

    public Water(int distanсeSwim){
        this.distanсeSwim = distanсeSwim;
    }

    public void doIt(Members members){
        members.swim(distanсeSwim);
    }
}
