package lesson4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        String[] listOfWords = {"Ромашка", "Одуванчик", "Лилия", "Роза", "Тюльпан", "Кактус", "Алоэ", "Ранетка", "Пион", "Алоэ", "Гипсофила"};
        for (int i=0; i < listOfWords.length; i++) {
            if(words.containsKey(listOfWords[i]))
                words.put(listOfWords[i],words.get(listOfWords[i])+ 1);
            else
                words.put(listOfWords[i],1);
        }
        System.out.println(words);


        GuidePhone guidePhohe = new GuidePhone();
        guidePhohe.add("Иванов", "89965140368");
        guidePhohe.add("Джонс", "89996668837");
        guidePhohe.add("Петров", "89916548727");
        guidePhohe.add("Иванов", "89165276289");

        System.out.println(guidePhohe.get("Иванов"));


    }
}
