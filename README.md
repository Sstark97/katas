# User Signup API

Sometimes it’s not feasible to work with real components on our code and we need to fake them. This is a trade off that
we will need to accept if we want to keep the fast-feedback principle.

In this exercise we will introduce the concept of Mock. Manually creating a mock to replace the behaviour of a component
will help us to understand better how mocks works and when they can be used.

When working with Hexagonal/Onion/Clean Architecture it is common to replace infrastructure components for testing.
We will practice this scenario developing a user sign up API.

- **Estimated time:** 3 hour
- **Format:** Pairs

## The Problem

We want to recreate an API system that receives user data that we want to persist on our system. Related to the prices
of our provider we will not be able to have a test database, so we will need to work with a Mock. Create the flow of
receiving user information (email, for example), validating it (”Is it a valid value?”) and persisting it in the
database. Keep in mind all the SOLID principles.

Once it’s done, we will add one additional validation: What happens when the user already exists in the system?

## Features
- "" -> []
- "notAnEmail.com" -> throws an Exception: "notAnEmail.com not have the email format"
- "example@gmail.com" -> 'success message'
- "example@email.com" -> ["example@email.com"]
- ["example@gmail.com"], "example@gmail.com" -> "example@gmail.com already exits"