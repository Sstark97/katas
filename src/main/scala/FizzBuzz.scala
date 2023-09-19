val fizzBuzz: Int => String = (n: Int) => {
  if n % 15 == 0 then
    "fizzbuzz"
  else if n % 3 == 0 then
    "fizz"
  else if n % 5 == 0 then
    "buzz"
  else
    "1"
}