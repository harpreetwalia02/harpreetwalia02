# Palindrome Checker Program

## Overview
This Java project provides comprehensive palindrome checking functionality. A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward.

## Files
- `PalindromeChecker.java` - Main palindrome checking class with multiple algorithms
- `PalindromeUtils.java` - Advanced utility functions for palindrome operations

## Features

### PalindromeChecker.java
1. **String Palindrome Check (Two-Pointer Method)**: Efficient O(n) algorithm using two pointers
2. **String Palindrome Check (Reverse Method)**: Uses StringBuilder.reverse() for comparison
3. **Number Palindrome Check**: Checks if integers are palindromes without string conversion
4. **Recursive Palindrome Check**: Recursive implementation for educational purposes
5. **Performance Comparison**: Benchmarks different algorithms

### PalindromeUtils.java
1. **Longest Palindromic Substring**: Finds the longest palindrome within a string
2. **Can Form Palindrome**: Checks if characters can be rearranged to form a palindrome
3. **Generate Palindromes**: Creates all possible palindromic permutations

## Key Features
- **Case Insensitive**: Ignores case differences
- **Punctuation Handling**: Removes spaces and punctuation for natural language palindromes
- **Multiple Algorithms**: Different approaches for learning and performance comparison
- **Comprehensive Testing**: Built-in test cases and performance benchmarks

## Usage

### Compile and Run
```bash
javac PalindromeChecker.java
java PalindromeChecker

javac PalindromeUtils.java
java PalindromeUtils
```

### Example Usage in Code
```java
// Check string palindromes
boolean isRacecarPalindrome = PalindromeChecker.isPalindrome("racecar"); // true
boolean isPhraseP = PalindromeChecker.isPalindrome("A man a plan a canal Panama"); // true

// Check number palindromes
boolean isNumberP = PalindromeChecker.isPalindrome(12321); // true

// Find longest palindromic substring
String longest = PalindromeUtils.longestPalindromicSubstring("babad"); // "bab" or "aba"

// Check if string can form palindrome
boolean canForm = PalindromeUtils.canFormPalindrome("aab"); // true
```

## Test Cases

### String Tests
- "racecar" ✓ (simple palindrome)
- "A man a plan a canal Panama" ✓ (phrase with spaces and punctuation)
- "race a car" ✗ (not a palindrome)
- "Madam" ✓ (case insensitive)
- "Was it a car or a cat I saw?" ✓ (complex phrase)

### Number Tests
- 121 ✓
- 12321 ✓  
- 123 ✗
- -121 ✗ (negative numbers not considered palindromes)

## Algorithms Used

1. **Two-Pointer Technique**: O(n) time, O(1) space
2. **Reverse and Compare**: O(n) time, O(n) space
3. **Recursive Approach**: O(n) time, O(n) space (due to call stack)
4. **Expand Around Center**: For longest palindromic substring

## Performance
The two-pointer method is generally the most efficient for simple palindrome checking, while the reverse method is more readable but uses additional memory.

## Related Work
Created for Jira Issue: OP-6 - Implementation of palindrome checking functionality.

## Requirements
- Java 8 or higher
- No external dependencies required