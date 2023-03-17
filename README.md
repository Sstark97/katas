# String Calculator
This classic kata guides you step by step through the implementation of a calculator that receives a String as input. 
It is a good exercise on refactoring and incremental implementation. It is also a good candidate for practising TDD.

## First Step
Create a function add that takes a String and returns a String:
- The method can take 0, 1 or 2 numbers separated by comma, and returns their sum.
- An empty string will return “0”.
- Example of inputs: "", "1", "1,2".
## Many Numbers
Allow the add method to handle an unknow number of arguments.

## Newline as separator
- "1\n2,3" should return "6".
- "175.2,\n35" is invalid and should return the message "Number expected but '\n' found at position 6."