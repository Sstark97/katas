// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class FizzBuzz extends munit.FunSuite {
  test("The number 1 must be '1'") {
    assertEquals(fizzBuzz(1), "1")
  }

  test("The number 3 must be 'fizz'") {
    assertEquals(fizzBuzz(3), "fizz")
  }

  test("The number 5 must be 'buzz'") {
    assertEquals(fizzBuzz(5), "buzz")
  }

  test("The number 15 must be 'fizzbuzz'") {
    assertEquals(fizzBuzz(15), "fizzbuzz")
  }
}
