# Makefile for C++ Palindrome Program

# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++11 -Wall -Wextra -O2

# Target executable name
TARGET = palindrome

# Source files
SOURCES = palindrome.cpp

# Default target
all: $(TARGET)

# Build the executable
$(TARGET): $(SOURCES)
	$(CXX) $(CXXFLAGS) -o $(TARGET) $(SOURCES)

# Run the program
run: $(TARGET)
	./$(TARGET)

# Clean build artifacts
clean:
	rm -f $(TARGET)

# Install dependencies (if needed)
install:
	@echo "No additional dependencies required for this program."

# Help target
help:
	@echo "Available targets:"
	@echo "  all     - Build the palindrome program (default)"
	@echo "  run     - Build and run the program"
	@echo "  clean   - Remove build artifacts"
	@echo "  help    - Show this help message"

.PHONY: all run clean install help