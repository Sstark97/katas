// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class FizzBuzz extends munit.FunSuite {
  test("The number 1 must be '1'") {
    assertEquals(fizzBuzz(1), "1")
  }

  test("The number 3 must be 'Fizz'") {
    assertEquals(fizzBuzz(3), "fizz")
  }
}
