package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.toUpperCase;

public class Chapter7 {
    //ex1
    public static Set<Integer> sieveOfEratosthenes(int n) {
        Set<Integer> resultSet = new TreeSet<>();
        for (int i = 2; i <= n; i++) {
            resultSet.add(i);
        }
        Integer s = 0;
        while (s * s <= n) {
            Integer finalS = s;
            s = resultSet.stream().filter(x -> x > finalS).min(Integer::compareTo).get();
            int buf = s * s;
            while (buf <= n) {
                resultSet.remove(buf);
                buf = buf + s;
            }
        }
        return resultSet;
    }

    //ex2
    public static ArrayList<String> toLowerCaseIter(ArrayList<String> arrayList) {
        ListIterator<String> iter = arrayList.listIterator();
        while (iter.hasNext()) {
            String str = iter.next();
            iter.set(str.toLowerCase());
        }
        return arrayList;
    }

    public static ArrayList<String> toLowerCaseIndex(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i).toLowerCase());
        }
        return arrayList;
    }

    public static ArrayList<String> toLowerCaseReplaceAll(ArrayList<String> arrayList) {
        arrayList.replaceAll(String::toLowerCase);
        return arrayList;
    }

    //ex3
    public static Set<Integer> union(Set<Integer> firstSet, Set<Integer> secondSet) {
        firstSet.addAll(secondSet);
        return firstSet;
    }

    public static Set<Integer> intersection(Set<Integer> firstSet, Set<Integer> secondSet) {
        firstSet.retainAll(secondSet);
        return firstSet;
    }

    public static Set<Integer> difference(Set<Integer> firstSet, Set<Integer> secondSet) {
        firstSet.removeAll(secondSet);
        return firstSet;
    }

    //ex7
    public static Map<String, Integer> words(String filename) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, new String(Files.readAllBytes(Paths.get(filename)))
                .split("[^A-Za-z]+"));
        Map<String, Integer> results = new TreeMap<>();
        words.forEach(x -> {
            x = x.toLowerCase();
            if (results.containsKey(x)) {
                results.put(x, results.get(x) + 1);
            } else {
                results.put(x, 1);
            }
        });
        return results;
    }

    //ex11
    public static List<String> shuffle(String filename) throws IOException {
        List<String> sentences = new ArrayList<>();
        Collections.addAll(sentences, new String(Files.readAllBytes(Paths.get(filename))).split("\\s*[.!?]\\s*"));
        sentences.forEach(x -> {
            LinkedList<String> words = splitSentenceToWord(x);
            shuffleWithoutFirstLast(words);
            sentences.set(sentences.indexOf(x), concatenationOfWords(words));
        });
        return sentences;
    }

    //ex12
    public static List<String> shuffleWithCapitalization(String filename) throws IOException {
        List<String> sentences = new ArrayList<>();
        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(new String(Files.readAllBytes(Paths.get(filename))));
        matcher.results().forEach(x->sentences.add(x.group()));


        sentences.forEach(x -> {
            LinkedList<String> words = splitSentenceToWord(x);
            shuffleWithCapitalization(words);
            sentences.set(sentences.indexOf(x), concatenationOfWords(words));
        });
        return sentences;
    }
    private static LinkedList<String> splitSentenceToWord(String sentence) {
        LinkedList<String> words = new LinkedList<>();
        Collections.addAll(words, sentence.split(" "));
        return words;
    }

    private static void shuffleWithoutFirstLast(LinkedList<String> words) {
        String firstWord = words.pop();
        String lastWord = words.removeLast();
        Collections.shuffle(words);
        words.addFirst(firstWord);
        words.addLast(lastWord);
    }

    private static void shuffleWithCapitalization(LinkedList<String> words) {
        words.addFirst(words.pop().toLowerCase());

        String lastWord = words.removeLast().trim();
        Character punctuationMark = lastWord.charAt(lastWord.length()-1);
        words.addLast(lastWord.replaceAll("[.!?]",""));

        Collections.shuffle(words);

        String firstWord = words.pop();
        words.addFirst(toUpperCase( firstWord.charAt(0) ) + firstWord.substring(1));

       words.addLast(words.removeLast().concat(punctuationMark.toString()));
    }

    private static String concatenationOfWords(LinkedList<String> words) {
        StringBuilder result = new StringBuilder();
        words.forEach(x -> result.append(x + " "));
        return result.toString();
    }

}
