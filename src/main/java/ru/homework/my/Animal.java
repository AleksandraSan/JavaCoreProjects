package ru.homework.my;

public class Animal implements Members {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;
    private boolean onDistance;


    public Animal(String name, int maxJumpHeight, int maxRunDistance, int maxSwimDistance){
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.maxRunDistance = maxRunDistance;
        this.onDistance = true;
    }



    public void swim(int swimDistance){
        if (maxSwimDistance >= swimDistance){
            System.out.println(name + " успешно проплыл дистанцию.");
        } else {
            System.out.println(name + " не справился с дистанцией");
            onDistance = false;
        }
    }

    public void jump(int heightJump){
        if (maxJumpHeight >= heightJump){
            System.out.println(name + " успешно перепрыгнул ограждение");
        } else {
            System.out.println(name + " не справился с препятсвием ");
            onDistance = false;
        }
    }

    public void run(int runDistance){
        if (maxRunDistance >= runDistance){
            System.out.println(name + " успешно пробежал дистанцию");
        } else {
            System.out.println(name + " не справился с задачей преодоления кросса");
            onDistance = false;
        }
    }

    public void result(){
        System.out.println(name + ":" + onDistance);
    }

    public boolean isOnDistance(){
        return onDistance;
    }

    public void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
