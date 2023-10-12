import 'package:fizzbuzz_dart/fizzbuzz_dart.dart';
import 'package:test/test.dart';

void main() {
  group("fizzbuzz for", () {
    test("the number 1 must be '1'", () {
      expect(fizzbuzz(1), equals("1"));
    });

    test("the number 3 must be 'fizz'", () {
      expect(fizzbuzz(3), equals("fizz"));
    });

    test("the number 5 must be 'buzz'", () {
      expect(fizzbuzz(5), equals("buzz"));
    });

    test("the number 15 must be 'fizzbuzz'", () {
      expect(fizzbuzz(15), equals("fizzbuzz"));
    });
  });
}
