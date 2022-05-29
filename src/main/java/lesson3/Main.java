package lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruite(new Apple());
        appleBox.addFruite(new Apple());
        System.out.println(appleBox.getWeight());


        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruite(new Apple());
        appleBox2.addFruite(new Apple());
        appleBox2.addFruite(new Apple());
        System.out.println(appleBox2.getWeight());

        System.out.println(appleBox.compare(appleBox2));

        appleBox.overFilling(appleBox2);



        System.out.println("Вес коробки 1 после пересыпания : " + appleBox.getWeight());
        System.out.println("Вес коробки 2 после пересыпания : " + appleBox2.getWeight());
    }

    public void changeElementArrays(Object[] Array, int first, int last){
        System.out.println(Arrays.toString(Array));
        Object arr = Array[first];
        Array[first] = Array[last];
        Array[last] = arr;
        System.out.println(Arrays.toString(Array));
    }
}
