import java.util.Scanner;

public class NoticeCleaner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        String originalLine = scanner.nextLine();
        if (!scanner.hasNextLine()) return;
        String keyword = scanner.nextLine().trim();

        // Count vowels in original line
        int vowelCount = 0;
        for (char c : originalLine.toCharArray()) {
            char lowerC = Character.toLowerCase(c);
            if (lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u') {
                vowelCount++;
            }
        }

        // Split words by one or more whitespace characters
        String trimmed = originalLine.trim();
        String[] words = trimmed.isEmpty() ? new String[0] : trimmed.split("\\s+");

        int wordCount = words.length;

        // Build cleaned sentence using StringBuilder
        StringBuilder sb = new StringBuilder();
        String shortestWord = "";
        int minLength = Integer.MAX_VALUE;
        int keywordCount = 0;

        for (int i = 0; i < words.length; i++) {
            String lowerWord = words[i].toLowerCase();

            // First word: first letter uppercase, rest lowercase
            // Following words: all lowercase
            String formattedWord;
            if (i == 0 && !lowerWord.isEmpty()) {
                formattedWord = Character.toUpperCase(lowerWord.charAt(0)) + lowerWord.substring(1);
            } else {
                formattedWord = lowerWord;
            }

            if (i > 0) {
                sb.append(" ");
            }
            sb.append(formattedWord);

            // Check shortest word (first occurrence on tie)
            if (lowerWord.length() < minLength) {
                minLength = lowerWord.length();
                shortestWord = lowerWord;
            }

            // Check keyword (ignoring case)
            if (lowerWord.equalsIgnoreCase(keyword)) {
                keywordCount++;
            }
        }

        System.out.println("Sentence: " + sb.toString());
        System.out.println("Words: " + wordCount);
        System.out.println("Shortest word: " + shortestWord);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowelCount);
        scanner.close();
    }
}

