# Word wrap
This kata is from Robert Martin and his blog includes a solution in Java [1] .

## Problem Description
You write a class called Wrapper, that has a single static function named wrap that takes two arguments, a string, and a
column number. The function returns the string, but with line breaks inserted at just the right places to make sure that
no line is longer than the column number. You try to break lines at word boundaries.

Like a word processor, break the line by replacing the last space in a line with a newline.

## Use Cases
- "", 1 -> ""
- "hello", -2 -> "Error: columnNumber must be a positive number and it is: -2"
- "hello", 2 -> "he\nllo"
- "hello", 7 -> "hello"
- "hello world", 7 -> "hello\nworld"