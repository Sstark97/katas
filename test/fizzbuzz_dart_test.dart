import 'package:fizzbuzz_dart/fizzbuzz_dart.dart';
import 'package:test/test.dart';

void main() {
  group("fizzbuzz", () {
    test("number 1 must be '1'", () {
      expect(fizzbuzz(1), equals("1"));
    });
  });
}

fizzbuzz(int number) {
}
