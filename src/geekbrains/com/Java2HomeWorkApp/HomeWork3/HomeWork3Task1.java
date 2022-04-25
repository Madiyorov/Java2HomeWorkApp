package geekbrains.com.Java2HomeWorkApp.HomeWork3;

import java.util.HashMap;
import java.util.Map;

public class HomeWork3Task1 {

    private static final String[] INPUT_DATE = {
            "one",
            "two",
            "three", "three", "three",
            "four",
            "five", "five", "five", "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten", "ten"
    };

    public static void main(String[] args) {

        Map<String, Integer> frequencyByWord = new HashMap<>();

        for (String word : INPUT_DATE) {
            Integer frequency = frequencyByWord.getOrDefault(word, 0);
            frequencyByWord.put(word, ++frequency);
        }

        for (Map.Entry<String, Integer> entry : frequencyByWord.entrySet()) {
            System.out.printf("Слово %s встречается %d раз %n", entry.getKey(), entry.getValue());
        }
    }
}
