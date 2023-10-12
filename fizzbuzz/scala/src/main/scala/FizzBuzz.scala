def isFizz(number: Int): Boolean = {
  number % 3 == 0
}

def isBuzz(number: Int): Boolean = {
  number % 5 == 0
}

def fizzBuzz(number: Int): String = {
  val fizz = if isFizz(number) then "fizz" else ""
  val buzz = if isBuzz(number) then "buzz" else ""
  val fizzBuzz = fizz + buzz

  if fizzBuzz.isBlank then number.toString else fizzBuzz
}

// Function that returns a string of fizzbuzz values from start to end
def fizzBuzzRange(start: Int, end: Int): String = {
  (start to end).map(fizzBuzz).mkString(", ")
}

@main def fizzBuzzMain(): Unit = {
  println(fizzBuzzRange(1, 100))
}