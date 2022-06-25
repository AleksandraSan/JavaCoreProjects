package lesson3;

import java.util.ArrayList;

public class Box <T extends Fruite> {
    private ArrayList<T> fruiteList;

    public Box() {
        this.fruiteList = new ArrayList<>();
    }

    public ArrayList<T> getFruiteList() {
        return fruiteList;
    }

    public void setFruiteList(ArrayList<T> fruiteList) {
        this.fruiteList = fruiteList;
    }

    public double getWeight() {
        int count = fruiteList.size();
        if (count == 0 ) return 0;
        return fruiteList.get(0).getWeight() * count;

    }

    public void addFruite(T fruit) {
        fruiteList.add(fruit);
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruiteList=" + fruiteList +
                '}';
    }

    public boolean compare(Box<?> o) {
        //Math.abs(this.getWeight() - o.getWeight()) < 0.001;
        if (getWeight() == o.getWeight()){
            return true;
        }
        return false;
    }

    //пересыпание
    public void overFilling (Box<T> box){
        for (T fruit :  fruiteList){
            box.addFruite(fruit);
        }
        fruiteList.clear();
    }
}
