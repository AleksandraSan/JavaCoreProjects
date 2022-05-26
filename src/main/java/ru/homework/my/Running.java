package ru.homework.my;

public class Running extends Obstacle{
    private int runDistance;
    public Running(int runDistance){
        this.runDistance= runDistance;
    }

    public void doIt(Members members) {
        members.run(runDistance);
    }
}
