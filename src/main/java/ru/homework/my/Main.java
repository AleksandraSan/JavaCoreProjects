package ru.homework.my;

public class Main {
    public static void main(String[] args) {
        Course courseNumber1 = new Course(new Running(50), new Water(10), new Partition(2));

        Team teamNumber1 = new Team("Команда 1", new Cat("Бублик"), new Dog("Барон"), new Turtle("Немо"));
        Team teamNumber2 = new Team("Команда 2", new Cat("Лютик"), new Dog("Марли"),new Turtle("Звездочка"));

        courseNumber1.doIt(teamNumber1);
        courseNumber1.doIt(teamNumber2);

        System.out.println("Результаты соревнования: ");
        teamNumber1.showResult();
        System.out.println();
        teamNumber1.showResult();
    }
}
