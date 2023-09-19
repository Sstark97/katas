val fizzBuzz: Int => String = (n: Int) => {
  val fizz = if n % 3 == 0 then "fizz" else ""
  val buzz = if n % 5 == 0 then "buzz" else ""
  val fizzBuzz = fizz + buzz

  if fizzBuzz != "" then
    fizzBuzz
  else
    "1"
}