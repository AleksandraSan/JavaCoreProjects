package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class GuidePhone {

    private HashMap<String, ArrayList<String>> guide = new HashMap<>();

    public ArrayList<String> get(String lastname) {
        return guide.get(lastname);
    }

    public void add(String lastnameHuman, String number) {
        ArrayList<String> numberForLastname = guide.getOrDefault(lastnameHuman, new ArrayList<>());
        numberForLastname.add(number);
        guide.put(lastnameHuman, numberForLastname);
    }
}
