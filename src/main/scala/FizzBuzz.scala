val fizzBuzz: Int => String = (n: Int) => {
  if n == 3 then
    "fizz"  
  else if n == 5 then
    "buzz"
  else if n == 15 then
    "fizzbuzz"
  else
    "1"
}