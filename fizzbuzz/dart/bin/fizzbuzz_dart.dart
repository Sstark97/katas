import 'package:fizzbuzz_dart/fizzbuzz_dart.dart';

void main(List<String> arguments) {
  List<int> numbers = List<int>.generate(100, (i) => i + 1);
  Iterable<String> numbersToFizzBuzz = numbers.map(fizzbuzz);
  print(numbersToFizzBuzz.toList());
}
