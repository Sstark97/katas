import 'package:fizzbuzz_dart/fizzbuzz_dart.dart';
import 'package:test/test.dart';

void main() {
  group("fizzbuzz for", () {
    test("any number divisible by 3 must be 'fizz'", () {
      expect(fizzbuzz(6), equals("fizz"));
    });

    test("any number divisible by 5 must be 'buzz'", () {
      expect(fizzbuzz(10), equals("buzz"));
    });

    test("any number divisible by 15 must be 'fizzbuzz'", () {
      expect(fizzbuzz(30), equals("fizzbuzz"));
    });

    test("the rest of the numbers must be the same number", () {
      expect(fizzbuzz(2), equals("2"));
    });
  });
}
