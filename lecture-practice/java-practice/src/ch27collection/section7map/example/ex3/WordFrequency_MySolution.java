package ch27collection.section7map.example.ex3;

import java.util.*;

/* 같은 단어가 나타난 수
- 각각의 단어가 나타난 수 출력
*/
public class WordFrequency_MySolution {
    public static void main(String[] args) {

        String text = "protein fiber vitamin protein fat carbohydrate fiber mineral vitamin fat protein fiber iron calcium fat vitamin protein carbohydrate fiber mineral zinc iron calcium fiber vitamin";

        String[] words = text.split(" ");

        Map<String, Integer> wordCountMap = getWordCountMap(words);
        System.out.println("wordCountMap = " + wordCountMap);
    }

    private static Map<String, Integer> getWordCountMap(String[] words) {
        Map<String, Integer> result = new HashMap<>();

        for (String word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return result;
    }
}
