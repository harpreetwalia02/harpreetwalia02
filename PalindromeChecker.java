/**
 * Palindrome Checker Program
 * 
 * This program provides multiple methods to check if a string or number is a palindrome.
 * A palindrome reads the same forwards and backwards.
 * 
 * Created for Jira Issue: OP-6
 */
public class PalindromeChecker {
    
    /**
     * Check if a string is a palindrome (case-insensitive, ignoring spaces and punctuation)
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true; // Empty string is considered a palindrome
        }
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Check if a string is a palindrome using StringBuilder reverse method
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeReverse(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        
        return cleanStr.equals(reversed);
    }
    
    /**
     * Check if a number is a palindrome
     * @param number The number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false; // Negative numbers are not palindromes
        }
        
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        
        return original == reversed;
    }
    
    /**
     * Recursive method to check if a string is a palindrome
     * @param str The string to check
     * @param start Starting index
     * @param end Ending index
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (start >= end) {
            return true;
        }
        
        if (cleanStr.charAt(start) != cleanStr.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(cleanStr, start + 1, end - 1);
    }
    
    /**
     * Main method to demonstrate palindrome checking
     */
    public static void main(String[] args) {
        // Test strings
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?",
            ""
        };
        
        // Test numbers
        int[] testNumbers = {
            121,
            12321,
            123,
            1,
            -121,
            1001
        };
        
        System.out.println("=== Palindrome Checker Demo ===\n");
        
        // Test string palindromes
        System.out.println("String Palindrome Tests:");
        System.out.println("-----------------------");
        for (String test : testStrings) {
            boolean result1 = isPalindrome(test);
            boolean result2 = isPalindromeReverse(test);
            String cleanStr = test.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            boolean result3 = cleanStr.isEmpty() ? true : isPalindromeRecursive(test, 0, cleanStr.length() - 1);
            
            System.out.printf("'%s' -> Two-pointer: %s, Reverse: %s, Recursive: %s%n", 
                            test, result1, result2, result3);
        }
        
        System.out.println("\nNumber Palindrome Tests:");
        System.out.println("------------------------");
        for (int test : testNumbers) {
            boolean result = isPalindrome(test);
            System.out.printf("%d -> %s%n", test, result);
        }
        
        // Performance comparison
        System.out.println("\n=== Performance Test ===");
        String longPalindrome = "A Santa at NASA";
        long startTime, endTime;
        int iterations = 1000000;
        
        // Test two-pointer method
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            isPalindrome(longPalindrome);
        }
        endTime = System.nanoTime();
        System.out.printf("Two-pointer method: %.2f ms%n", (endTime - startTime) / 1000000.0);
        
        // Test reverse method
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            isPalindromeReverse(longPalindrome);
        }
        endTime = System.nanoTime();
        System.out.printf("Reverse method: %.2f ms%n", (endTime - startTime) / 1000000.0);
    }
}