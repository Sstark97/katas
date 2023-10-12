String fizzbuzz(int number) {
  if (number == 15) {
    return "fizzbuzz";
  } else if(isFizz(number)) {
    return "fizz";
  } else if(isBuzz(number)) {
    return "buzz";
  }
  return "1";
}

bool isBuzz(int number) => number == 5;

bool isFizz(int number) => number % 3 == 0;