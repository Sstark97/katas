# Katas 🥷🏻
In this repository, all the katas/coding dojos that I have done are grouped together, with some solutions being 
different or using different programming languages.
The goal is to have all the solutions I have worked on grouped together, see different approaches to the same problem, 
and be able to compare them.

## Structure ⚙️
The repository, in turn, contains different projects for each kata, each organized by the different programming languages 
I have used. The directory structure is as follows:
```
katas
├── kata1
│   ├── first_language
│   ├── second_language
│   ├── third_language
├── kata2
│   ├── first_language
│   ├── second_language
│   ├── ...
├── kata3
```
In each of the programming language directories, there is a README.md file with the kata's description.

## Clone only one kata
If we want to clone only one or several katas, we can do so using git's sparse-checkout:
```bash
# Clone the empty repository
$ git clone --no-checkout https://github.com/Sstark97/katas.git

# Move inside the repository
$ cd katas

# Initialize sparse-checkout
$ git sparse-checkout set <kata-directory>

# Update the workspace to see the changes
$ git read-tree -mu HEAD
```

It's important to enable "sparse-checkout" mode to do this; otherwise, we won't see any changes. We can do this as follows:
```bash
$ git config core.sparseCheckout true
```
To perform this, we need a version of Git that is greater than or equal to 2.25.

## List of Katas 📚
- [FizzBuzz](./fizzbuzz/README.md)
- [User Signup](./user_signup/README.md)
- [Mars Rover](./mars_rover/README.md)
- [Password Validator](./password_validator/README.md)
- [String Calculator](./string_calculator/README.md)
- [Word Wrap](./word_wrap/README.md)
- [Markdown Kata](./markdown/README.md)
- [Roman Numerals](./roman_numerals/README.md)
- [Maxibon](./maxibon/README.md)
- [Template Engine](./template_engine/README.md)
- [Mouse Event](./mouse_event/README.md)
- [Camel Case Converter](./camel_case_converter/README.md)
- [Surveillance Controller](./surveillance_controller/README.md)