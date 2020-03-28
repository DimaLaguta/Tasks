package chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter8 {
    public static List<String> longWordsStream(List<String> words) {
        return words.stream()
                .filter(w -> {
                    System.out.println(w);
                    return w.length() > 5;
                })
                .collect(Collectors.toList());
    }

    public static List<String> longWordsParallelStream(List<String> words) {
        return words.parallelStream()
                .filter(w -> {
                    System.out.println(w);
                    return w.length() > 5;
                })
                .collect(Collectors.toList());
    }

    public static Stream<Long> generator(Long a, Long c, Long m) {
        return Stream.iterate(1L, i -> (a * i + c) % m);
    }

    public static Stream<String> letters(String s) {

        return s.chars()
                .mapToObj(x -> Character.toString((char) x));

       /* List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            result.add(s.substring(i, i + 1));
        return result.stream();*/
    }

    public static List<String> wordsWithDifferentVowels(String filename) throws IOException {
        return Stream.of(new String(Files.readAllBytes(Paths.get(filename)))
                .split(" "))
                .filter(Chapter8::isContainsDifferentVowels)
                .collect(Collectors.toList());

    }

    private static List<String> vowels = Arrays.asList("a", "e", "y", "u", "i", "o");

    private static boolean isContainsDifferentVowels(String word) {
        return letters(word)
                .filter(x -> vowels.contains(x))
                .collect(Collectors.toSet())
                .size() == 5;
    }

    public static int averageLengthOfStr(Stream<String> stringStream) {
        IntSummaryStatistics statistics = stringStream
                .mapToInt(String::length)
                .summaryStatistics();
        return (int) Math.round(statistics.getAverage());
    }

    public static List<String> strWithMaxLength(Stream<String> stringStream) {
        Optional<Map.Entry<Integer, List<String>>> max = stringStream
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey());

        return max.map(x -> x.getValue()).get();
    }

    public static <T> void joining(Stream<T> stream) {
        //stream.reduce()
    }

//    public static Double average(Stream<Double> doubleStream) {
//      //??
//    }

    public static List<String> longestWords500() {
        List<String> words = new ArrayList<>();
        Matcher matcher = null;
        try {
            matcher = Pattern.compile("[A-Za-z]+").matcher(new String(Files.readAllBytes(Paths.get("Tolstoy Leo.txt"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        matcher.results().parallel().forEach(x -> words.add(x.group()));
        List<String> res = words.parallelStream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(500)
                .collect(Collectors.toList());
        return res;
    }
}
