package word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MIAnalyzer {

    static Map<String, Integer> wordFreq = new HashMap<>();
    static Map<String, Integer> fourGramFreq = new HashMap<>();
    static Map<String, Integer> fourGramFileFreq = new HashMap<>();
    static int totalWordCount = 0;
    final static String TEST_FILE_DIR = "/Users/dongjae/IdeaProjects/problem-solving/test_programs/word/resource";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("최소 출현: ");
        int minFreq = sc.nextInt();

        System.out.print("최소 파일 출현: ");
        int minFileFreq = sc.nextInt();

        File testFileDir = new File(TEST_FILE_DIR);
        File[] testFiles = testFileDir.listFiles();

        for (File file : testFiles) {
            countFrequency(file);
        }

        calculateMI(minFreq, minFileFreq);
    }

    public static void countFrequency(File file) {
        Set<String> fourGramSetOfFile = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int idx = 0;
            List<String> words = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[,\\.?\\!\"]", "").toLowerCase();

                String[] lineWords = line.split("[\\s’]+");
                for (String word : lineWords) {
                    if (" ".equals(word) || "".equals(word) || word == null) {
                        continue;
                    }

                    // word 길이가 2 이하면서 유효한 단어가 아니라면 어퍼스트로피 붙이기
                    if (word.length() <= 2)
                        word = convertToApostropheForm(word);

                    // 단어 카운트 증가
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                    totalWordCount++;
                    idx++;

                    // 4-gram 구성
                    if (words.size() == 4) {
                        words.remove(0);
                    }
                    words.add(word);

                    if (idx >= 4) {
                        String fourGram = String.join(" ", words);
                        fourGramSetOfFile.add(fourGram);
                        fourGramFreq.put(fourGram, fourGramFreq.getOrDefault(fourGram, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fourGramSetOfFile.forEach(
                fourGram ->
                        fourGramFileFreq.put(fourGram, fourGramFileFreq.getOrDefault(fourGram, 0) + 1));
    }

    public static void calculateMI(int minFreq, int minFileFreq) {
        Map<String, Double> MIMap = new HashMap<>();

        for (Entry<String, Integer> fourGramEntry : fourGramFreq.entrySet()) {
            String fourGram = fourGramEntry.getKey();
            int count = fourGramEntry.getValue();
            String[] words = fourGram.split(" ");

            double fourGramProb = (double) count / (totalWordCount - 3);

            // 개별 단어 확률 계산
            double word1Prob = (double) wordFreq.get(words[0]) / totalWordCount;
            double word2Prob = (double) wordFreq.get(words[1]) / totalWordCount;
            double word3Prob = (double) wordFreq.get(words[2]) / totalWordCount;
            double word4Prob = (double) wordFreq.get(words[3]) / totalWordCount;

            // Mutual Information 계산식 적용
            double MIValue = logBaseTwo(fourGramProb / (word1Prob * word2Prob * word3Prob * word4Prob));

            MIMap.put(fourGram, MIValue);
        }

        System.out.println("Frequency\t\tMI value\t\t4-gram");
        MIMap.entrySet().stream()
             .filter(e -> fourGramFreq.get(e.getKey()) >= minFreq && fourGramFileFreq.get(e.getKey()) >= minFileFreq)
             .filter(e -> fourGramFreq.get(e.getKey()) >= minFreq)
             .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
             .forEach(e -> System.out.printf("%d\t\t\t\t\t\t%.6f\t\t%s\n",
                                             fourGramFreq.get(e.getKey()), e.getValue(), e.getKey().replaceAll("\\s+’", "’")));
    }

    private static String convertToApostropheForm(String str) {
        final String[] needApostrophe = {"s", "t", "re", "d", "ll", "m", "ve"};
        return Arrays.stream(needApostrophe).filter(s -> s.equals(str)).findAny().isPresent() ? "’" + str : str;
    }

    private static double logBaseTwo(double value) {
        return Math.log(value) / Math.log(2);
    }

}
