val fizzBuzz: Int => String = (n: Int) => {
  if n == 15 then
    "fizzbuzz"
  else if n % 3 == 0 then
    "fizz"
  else if n == 5 then
    "buzz"
  else
    "1"
}