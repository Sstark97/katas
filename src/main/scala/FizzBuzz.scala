def isFizz(n: Int): Boolean = {
  n % 3 == 0
}

def isBuzz(n: Int): Boolean = {
  n % 5 == 0
}

def fizzBuzz(n: Int): String = {
  val fizz = if isFizz(n) then "fizz" else ""
  val buzz = if isBuzz(n) then "buzz" else ""
  val fizzBuzz = fizz + buzz

  if fizzBuzz != "" then
    fizzBuzz
  else
    n.toString
}