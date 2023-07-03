# Camel Case Converter Kata

## Description
Write a function that converts a text, whose words are delimited by dashes, both low and high and spaces, in camel case 
format.

## Task List
- [x] An empty string returns an empty string. E.g. "" -> ""
- [x] For a single word with the firts letter in upper case, it returns the same word. E.g. "Foo" -> "Foo"
- [x] For a text that contains all words with the first letter in upper case separated by spaces, it returns the words
joined in camel case format. E.g. "Foo Bar" -> "FooBar"
- [x] For a text that contains all words with the first letter in upper case separated by dashes, it returns the words
  joined in camel case format. E.g. "Foo_Bar-Foo" -> "FooBarFoo"
- [x] For a word with the first letter in lower case, it returns the same word with the first letter in upper case. 
E.g. "foo" -> "Foo"
- [x] For a text that contains all words with the first letter in lower case, it returns the words joined with the first
  letter in upper case. E.g. “foo_bar foo-bar” -> “FooBarFooBar”