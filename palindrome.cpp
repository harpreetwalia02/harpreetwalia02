#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

/**
 * Function to check if a string is a palindrome
 * @param str: Input string to check
 * @return: true if palindrome, false otherwise
 */
bool isStringPalindrome(string str) {
    // Convert to lowercase and remove spaces for better comparison
    string cleanStr = "";
    for (char c : str) {
        if (isalnum(c)) {
            cleanStr += tolower(c);
        }
    }
    
    int left = 0;
    int right = cleanStr.length() - 1;
    
    while (left < right) {
        if (cleanStr[left] != cleanStr[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

/**
 * Function to check if a number is a palindrome
 * @param num: Input number to check
 * @return: true if palindrome, false otherwise
 */
bool isNumberPalindrome(int num) {
    // Handle negative numbers
    if (num < 0) {
        return false;
    }
    
    int original = num;
    int reversed = 0;
    
    while (num > 0) {
        reversed = reversed * 10 + num % 10;
        num /= 10;
    }
    
    return original == reversed;
}

/**
 * Function to reverse a string (alternative method demonstration)
 * @param str: Input string to reverse
 * @return: reversed string
 */
string reverseString(string str) {
    string reversed = str;
    reverse(reversed.begin(), reversed.end());
    return reversed;
}

/**
 * Function to check palindrome using string reversal method
 * @param str: Input string to check
 * @return: true if palindrome, false otherwise
 */
bool isPalindromeByReversal(string str) {
    // Clean the string (remove spaces and convert to lowercase)
    string cleanStr = "";
    for (char c : str) {
        if (isalnum(c)) {
            cleanStr += tolower(c);
        }
    }
    
    string reversed = reverseString(cleanStr);
    return cleanStr == reversed;
}

int main() {
    cout << "=== C++ Palindrome Checker Program ===" << endl;
    cout << "This program checks if strings and numbers are palindromes." << endl << endl;
    
    // Test string palindromes
    cout << "--- String Palindrome Tests ---" << endl;
    string testStrings[] = {
        "racecar",
        "A man a plan a canal Panama",
        "race a car",
        "hello",
        "Madam",
        "Was it a car or a cat I saw",
        "No 'x' in Nixon"
    };
    
    for (const string& testStr : testStrings) {
        bool result = isStringPalindrome(testStr);
        cout << "\"" << testStr << "\" -> " 
             << (result ? "Palindrome" : "Not a palindrome") << endl;
    }
    
    cout << endl << "--- Number Palindrome Tests ---" << endl;
    int testNumbers[] = {121, 12321, 123, 1, 1001, -121, 0, 12345};
    
    for (int testNum : testNumbers) {
        bool result = isNumberPalindrome(testNum);
        cout << testNum << " -> " 
             << (result ? "Palindrome" : "Not a palindrome") << endl;
    }
    
    // Interactive section
    cout << endl << "--- Interactive Testing ---" << endl;
    char choice;
    
    do {
        cout << "\nChoose an option:" << endl;
        cout << "1. Check string palindrome (s)" << endl;
        cout << "2. Check number palindrome (n)" << endl;
        cout << "3. Exit (e)" << endl;
        cout << "Enter your choice: ";
        cin >> choice;
        
        switch (choice) {
            case 's':
            case 'S':
            case '1': {
                cin.ignore(); // Clear the input buffer
                cout << "Enter a string: ";
                string userString;
                getline(cin, userString);
                
                if (isStringPalindrome(userString)) {
                    cout << "\"" << userString << "\" is a palindrome!" << endl;
                } else {
                    cout << "\"" << userString << "\" is not a palindrome." << endl;
                }
                break;
            }
            case 'n':
            case 'N':
            case '2': {
                cout << "Enter a number: ";
                int userNumber;
                cin >> userNumber;
                
                if (isNumberPalindrome(userNumber)) {
                    cout << userNumber << " is a palindrome!" << endl;
                } else {
                    cout << userNumber << " is not a palindrome." << endl;
                }
                break;
            }
            case 'e':
            case 'E':
            case '3':
                cout << "Goodbye!" << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 'e' && choice != 'E' && choice != '3');
    
    return 0;
}