String fizzbuzz(int number) {
  if (isFizzBuzz(number)) {
    return "fizzbuzz";
  } else if(isFizz(number)) {
    return "fizz";
  } else if(isBuzz(number)) {
    return "buzz";
  }
  return "1";
}

bool isFizzBuzz(int number) => isFizz(number) && isBuzz(number);

bool isBuzz(int number) => number % 5 == 0;

bool isFizz(int number) => number % 3 == 0;