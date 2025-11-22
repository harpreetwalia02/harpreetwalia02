/**
 * Utility class for advanced palindrome operations
 * 
 * This class provides additional palindrome-related functionality
 * including finding the longest palindromic substring and checking
 * for palindromic sentences.
 * 
 * Related to Jira Issue: OP-6
 */
public class PalindromeUtils {
    
    /**
     * Find the longest palindromic substring in a given string
     * @param str The input string
     * @return The longest palindromic substring
     */
    public static String longestPalindromicSubstring(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // Check for odd length palindromes (center at i)
            int len1 = expandAroundCenter(str, i, i);
            // Check for even length palindromes (center between i and i+1)
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int currentMaxLength = Math.max(len1, len2);
            
            if (currentMaxLength > maxLength) {
                maxLength = currentMaxLength;
                start = i - (currentMaxLength - 1) / 2;
            }
        }
        
        return str.substring(start, start + maxLength);
    }
    
    /**
     * Helper method to expand around center and find palindrome length
     */
    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    /**
     * Check if a sentence can be rearranged to form a palindrome
     * @param sentence The input sentence
     * @return true if it can form a palindrome, false otherwise
     */
    public static boolean canFormPalindrome(String sentence) {
        if (sentence == null) {
            return false;
        }
        
        // Clean the string - keep only alphanumeric characters
        String cleaned = sentence.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Count frequency of each character
        int[] charCount = new int[256];
        for (char c : cleaned.toCharArray()) {
            charCount[c]++;
        }
        
        // Count characters with odd frequency
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // A string can form a palindrome if at most one character has odd frequency
        return oddCount <= 1;
    }
    
    /**
     * Generate all possible palindromes from a given string
     * @param str The input string
     * @return Array of palindromic permutations
     */
    public static String[] generatePalindromes(String str) {
        if (str == null || !canFormPalindrome(str)) {
            return new String[0];
        }
        
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Count frequencies
        int[] charCount = new int[256];
        for (char c : cleaned.toCharArray()) {
            charCount[c]++;
        }
        
        // Find the character with odd frequency (if any)
        char oddChar = 0;
        StringBuilder half = new StringBuilder();
        
        for (int i = 0; i < 256; i++) {
            if (charCount[i] % 2 != 0) {
                oddChar = (char) i;
            }
            // Add half of the characters to build the first half
            for (int j = 0; j < charCount[i] / 2; j++) {
                half.append((char) i);
            }
        }
        
        // Generate permutations of the first half
        java.util.List<String> permutations = new java.util.ArrayList<>();
        generatePermutations(half.toString().toCharArray(), 0, permutations);
        
        // Build palindromes
        java.util.Set<String> palindromes = new java.util.HashSet<>();
        for (String perm : permutations) {
            StringBuilder palindrome = new StringBuilder(perm);
            if (oddChar != 0) {
                palindrome.append(oddChar);
            }
            palindrome.append(new StringBuilder(perm).reverse());
            palindromes.add(palindrome.toString());
        }
        
        return palindromes.toArray(new String[0]);
    }
    
    /**
     * Helper method to generate all permutations of a character array
     */
    private static void generatePermutations(char[] chars, int start, java.util.List<String> result) {
        if (start == chars.length) {
            result.add(new String(chars));
            return;
        }
        
        java.util.Set<Character> used = new java.util.HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (used.contains(chars[i])) {
                continue;
            }
            used.add(chars[i]);
            
            // Swap
            char temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
            
            generatePermutations(chars, start + 1, result);
            
            // Swap back
            chars[i] = chars[start];
            chars[start] = temp;
        }
    }
    
    /**
     * Main method for testing utility functions
     */
    public static void main(String[] args) {
        System.out.println("=== Palindrome Utilities Demo ===\n");
        
        // Test longest palindromic substring
        String[] testStrings = {
            "babad",
            "cbbd",
            "racecar",
            "abcdef",
            "aabbaa"
        };
        
        System.out.println("Longest Palindromic Substring Tests:");
        System.out.println("------------------------------------");
        for (String test : testStrings) {
            String result = longestPalindromicSubstring(test);
            System.out.printf("'%s' -> '%s'%n", test, result);
        }
        
        // Test palindrome formation
        String[] formationTests = {
            "aab",
            "carerac",
            "abc",
            "aabbcc"
        };
        
        System.out.println("\nCan Form Palindrome Tests:");
        System.out.println("--------------------------");
        for (String test : formationTests) {
            boolean canForm = canFormPalindrome(test);
            System.out.printf("'%s' -> %s%n", test, canForm);
            
            if (canForm) {
                String[] palindromes = generatePalindromes(test);
                System.out.printf("  Possible palindromes: %s%n", java.util.Arrays.toString(palindromes));
            }
        }
    }
}