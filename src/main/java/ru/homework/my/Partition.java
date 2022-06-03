package ru.homework.my;

public class Partition extends Obstacle {
    private int heightPartition;

    public Partition(int heightPartition){
        this.heightPartition = heightPartition;
    }

    public void doIt(Members members){
        members.jump(heightPartition);
    }

}
