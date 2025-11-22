# C++ Palindrome Program

A comprehensive C++ program that checks whether strings and numbers are palindromes.

## What is a Palindrome?

A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward. Examples include:
- **Strings**: "racecar", "A man a plan a canal Panama", "Madam"
- **Numbers**: 121, 12321, 1001

## Features

- **String Palindrome Detection**: Checks if strings are palindromes (case-insensitive, ignores spaces and punctuation)
- **Number Palindrome Detection**: Checks if numbers are palindromes
- **Multiple Algorithms**: Implements both character-by-character comparison and string reversal methods
- **Interactive Mode**: Allows users to test their own inputs
- **Comprehensive Testing**: Includes pre-defined test cases for demonstration

## Files

- `palindrome.cpp` - Main C++ source code
- `Makefile` - Build configuration for easy compilation
- `README.md` - This documentation file

## Compilation and Usage

### Prerequisites
- C++ compiler (g++ recommended)
- Make utility (optional, for using Makefile)

### Method 1: Using Makefile (Recommended)
```bash
# Compile the program
make

# Compile and run the program
make run

# Clean build artifacts
make clean

# Show help
make help
```

### Method 2: Direct Compilation
```bash
# Compile
g++ -std=c++11 -Wall -Wextra -O2 -o palindrome palindrome.cpp

# Run
./palindrome
```

## Program Structure

### Functions

1. **`isStringPalindrome(string str)`**
   - Checks if a string is a palindrome using two-pointer technique
   - Handles case-insensitive comparison
   - Ignores spaces and non-alphanumeric characters

2. **`isNumberPalindrome(int num)`**
   - Checks if a number is a palindrome by reversing its digits
   - Handles negative numbers (returns false)

3. **`isPalindromeByReversal(string str)`**
   - Alternative method using string reversal
   - Demonstrates different algorithmic approach

4. **`reverseString(string str)`**
   - Utility function to reverse a string
   - Uses STL reverse function

### Program Flow

1. **Automated Testing**: Runs predefined test cases for both strings and numbers
2. **Interactive Mode**: Allows user input for custom testing
3. **User-Friendly Interface**: Clear menu system and formatted output

## Example Output

```
=== C++ Palindrome Checker Program ===
This program checks if strings and numbers are palindromes.

--- String Palindrome Tests ---
"racecar" -> Palindrome
"A man a plan a canal Panama" -> Palindrome
"race a car" -> Not a palindrome
"hello" -> Not a palindrome
"Madam" -> Palindrome

--- Number Palindrome Tests ---
121 -> Palindrome
12321 -> Palindrome
123 -> Not a palindrome
1 -> Palindrome
1001 -> Palindrome
-121 -> Not a palindrome

--- Interactive Testing ---
Choose an option:
1. Check string palindrome (s)
2. Check number palindrome (n)
3. Exit (e)
```

## Algorithm Complexity

- **Time Complexity**: O(n) where n is the length of the string or number of digits
- **Space Complexity**: O(1) for the two-pointer method, O(n) for the reversal method

## Educational Value

This program demonstrates:
- String manipulation in C++
- Two-pointer technique
- Input validation and error handling
- Interactive console applications
- Multiple algorithmic approaches to the same problem
- Good C++ programming practices

## Contributing

Feel free to enhance this program by:
- Adding support for Unicode characters
- Implementing additional palindrome detection algorithms
- Adding file input/output capabilities
- Creating a GUI version

## License

This program is provided as-is for educational purposes.