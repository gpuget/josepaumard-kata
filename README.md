# josepaumard-kata
[https://josepaumard.github.io/]
* FizzBuzz: [https://josepaumard.github.io/katas/introductory/fizzbuzz-kata.html]
* String Calculator: [https://josepaumard.github.io/katas/introductory/stringcalculator-kata.html]
* Leap Years: [https://josepaumard.github.io/katas/introductory/leapyears-kata.html]
* RPN Calculator: [https://josepaumard.github.io/katas/introductory/rpncalculator-kata.html]
* One Two: [https://josepaumard.github.io/katas/introductory/onetwo-kata.html]

# The FizzBuzz Kata
The FizzBuzz kata is the first kata of our serie. It is very simple and inspired by a game told to young children to teach them the division. Because it is very simple, we can use it to see the first principles of clean code and software crafstmanship.

## The Kata
We want to be able to print the numbers between 1 and 100. If the number is divisible by 3, we want to print Fizz instead of this number. If the number is divisible by 5, we want to print Buzz instead. And if the number is divisible by both 3 and 5, we want to print FizzBuzz. Easy enough?

## Comments
This first kata is really so easy to solve, that you are probably asking yourself: why bother working on such an easy problem? In fact, the `FizzBuz` is a non-problem, and this is why I like to use it as the very first kata for people who never gave a try at Test Driven Development (TDD).

I usually just ask the people: ok, go for it, could you show me how to write this code using TDD. I just look at the code people are writing for a few minutes (no more than 10), and then begin to explain them the first principles of clean coding and TDD.

I added a fizzbuz-kata branch in this repo with a way of solving this kata, commit by commit. You can access the first commit of this branch here.

### First Questions
Some questions soon arise: what should we write? Is it a class? With which method? What does this method should take as an argument, what should it return?

For me it is the right time to explain the role of a business analyst, or whatever you call this role. A business analyst does not have necessarily any programming skills or knowledge, but she should be able to answer any kind of questions about the specifications. Since in these specifications there is no mention of any class or method or even method signature, you, as a developer, should have the reflex to ask these questions to the right person. Of course, you should know this person. If you do not, it probably means that there is a problem in the organization of your team.

So in this case, yes, you should create a class, with a method that takes an argument as an `int`, and return a `String`.

### Naming Test Methods
Most of the people will name their test methods like this `testFizz()` of `testBuzz()` of even worse `testFizz0()`, `testFizz1()` and so on. So one of the first point is to explain that a test method should explain what it does test, in a name that should be self explanatory. The reason being, when all you have is your Sonar report, having to dig into the code to understand what is wrong with your application or your module is just a waste of time. The only thing Sonar will give you is the name of the failed test method, so this name should give you all the information you need to understand where you should go to fix this test.

Yes, we have been told for ages that a Java method should begin with a lower case letter, should use camel case, should not use the underscore character, and should not be too long. And maybe should begin with a verb. A method named `getAge()` is a perfect example, `toString()` is another one.

For test methods, things are different. Most of the time the are lengthy, and it is a fact that camel case makes lengthy name unreadable. Having a test method that used snake case (with underscores) instead of camel case makes perfect sense. Your first method for this kata could be: `should_return_1_when_called_with_1()`. It does not look like the name of a Java method at all, but it does look like the name of a test method following the clean code rules. It will be hard for a seasoned Java programmer to accept that, but don’t worry, it is not the first thing she wil have to admit.

### How to Write a Test
Once the name of the method is correct and explains the intent of the test method, we can move on to the body of the method. Most of the time, this body is correct in the overall. An instance of a `FizzBuzz` class is created, then the method is called with an argument, and the returned `String` captured in a variable.

Some people write their tests without assertions in them, and prefer to print our the result. Of course this is wrong, a test without an assertion is not a test.

Some people write more than one call to the tested method, with corresponding assertions. It is not the right way to write a test method. A test method should call the tested method once, capture the result and test it against the expected result. Why? Because if the first assertion fails, then the rest of the method is not executed. Maybe there are more failures in the other assertions, but you will not know it.

I usually ask people to write their test method using the AAA principle: Arrange / Act / Assert. And instead of calling it AAA, I like to call it Given / When / Then, which is exactly the same thing named differently. I have the feeling that it better prepares the people to the BDD approach.

So a test method, in my mind should look like the following.

```
@Test
public void should_return_1_when_called_with_1() {

    // Given
    FizzBuzz fizzBuzz = new FizzBuzz();
    int input = 1;
    String expectedOutput = "1";

    // When
    String output = fizzBuzz.fizzer(input);

    // Then
    assertThat(output).isEqualTo(expectedOutput);
}
```
Some technical notes: the `@Test` annotation is rather agnostic. Most of the people will use JUnit, which is fine. I prefer to use TestNG, and have been used to it for years.

The `assertThat()` call does not come from JUnit neither TestNG, it comes from the AssertJ framework and the imported class is the `Assertions` class. This assertion framework is so great, I think that every project should use it.

The first questions that will probably come is about the copy / paste of some parts of this method to the next one. I would think that in the case of this kata, it is not such a big deal. Sure, copy / paste should be avoided in application code. But in the case of this kata, I really do not mind. If people know their testing framework well, they will create setup methods to avoid repeating things. They can even create parametrized tests if they like. For me, it is not the focus of this kata though, so I would not push them to do that.

### Coding in Baby Steps
Understanding the baby step approach is fundamental in TDD. Being able to extract a trivial sub-problem from a complex problem is not an easy task. On this trivial kata, since it could be done in one step by any average developer, it is even more difficult. This is the reason why I like to insist very much on using baby steps on this kata. Slicing a simple problem is not easy, but it has to be done. When it comes to difficult problems, having this reflex proves very useful. So yes, slicing this problem in 3 or 4 slices should be done.

The first slice could be: let us solve the case for numbers that are not divisible by 3, not divisible by 5. Then address the numbers divisible by 3, then divisible by 5.

### Constant Creation of Value
I observed that many developers are not fully aware of the concept of creating value. For them, writing some code to implement a specification cannot really be split into steps, each step having its own value. The only value is the final value of the fully implemented spec. They do not see that delivering some code that is a partial implementation of a spec or feature has indeed some value. Explaining them that value can be partly delivered always leads to very interesting discussions. I like to explain it like that: once a functionality has been added to the code, even if it is a partial implementation of a larger spec, and its test is green, then the value is there, and can be pushed in the Github repo.

What the people may not see, is that this partial, fully tested feature could use by other parts of the team, that will be able to use it to build their own module. It may be a graphical user interface, a REST or SOAP service, whatever. Even if the piece of code that was delivered works only for the value 1 (instead of all the numbers up to 100, in the case of this FizzBuzz kata), it might be enough for them to begin their work. While they are working on their module, I can improve mine, delivering an updated version that correctly handles all the numbers, as long as they are not divisible by 3 or 5. An updated version that the other teams are free to use (or not!) as they see fit.

Being able to deliver value small amounts by small amounts is a value in itself since it can ease the work of other teams that are waiting for my module to be fully working. TDD and baby steps are very good at that!

### Refactoring to Explain the Intent of the Code
The last thing I like to explain to people on this kata is the first goal of code refactor: making clear the intent of the code.

At one point or another, in this very simple kata, we will ned up with this kind of code:
```
if (number % 3 == 0) {
   // Some cunning computation
}
```
Any seasoned developer will know that `number % 3 == 0` is a trick to know if `number` is divisible by three. And indeed, for those numbers, we have a special processing to do. But is the intent of the code really clear? Wouldn’t it be be better to write it like this:
```
if (isDivisibleBy3(number)) {
   // The same cunning computation
}
```
The difference between the two versions if tiny. But in the second case, the link with the specification rule is made so obvious that you cant miss it!

For me this trivial example is in fact very good: take a trivial piece of code, and show the difference with a trivial readable piece of code. Even in very simple lines of code, refactor, method extraction and explicit naming can greatly improve the quality of the code.

### Wrapup
I think that this very simple kata is in fact a great introduction to the most important concepts of clean code and TDD. When I coach people on this kata, I usually tell them that we are not going to spend more than 15 minutes on it, not to scary them! What would be the point in spending more time than this on such a trivial example? In fact, I know very well that we are going to spend a full hour on it, talking about the different Clean Code and TDD principles, discussing everything, laying things for the upcoming coaching sessions.

# The String Calculator Kata
## The Kata
### 1) Create a simple String calculator with a method int add(String numbers)

The method can take 0, 1 or 2 numbers, and will return their sum. For an empty string it will return 0. For example ` ` or 1 or 1,2.

* Start with the simplest test case of an empty string and move to 1 and two numbers.
* Remember to solve things as simply as possible so that you force yourself to write tests you did not think about.
* Remember to refactor after each passing test.

### 2) Allow the add() method to handle an unknown amount of numbers.

### 3) Allow the add() method to handle new lines between numbers instead of commas.

* the following input is ok: 1\n2,3, the result is 6.
* the following input is NOT ok: 1,\n (not need to prove it - just clarifying).

### 4) Support different delimiters.

* To change a delimiter, the beginning of the string will contain a separate line that looks like this: //[delimiter]\n[numbers…] for example //;\n1;2 should return three where the default delimiter is ;.
* The first line is optional. all existing scenarios should still be supported

### 5) Calling add() with a negative number will throw an exception negatives not allowed - and the negative that was passed. If there are multiple negatives, show all of them in the exception message.

### 6) Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2

## Comments
This kata is very interesting to practice the slicing of a problem. Here the slicing is explained in the kata itself, which is not always the case. So it should not be a problem to begin to write the first tests and then features to solve this problem.

The problem itself is not a very complicated one.

There are two things interesting to stress out in the Java version of this kata: the splitting of strings of characters and the exceptions.

I added a stringcalculator-kata branch in this repo with a way of solving this kata, commit by commit. You can access the first commit of this branch here.

### Splitting strings of characters
There is a well known way of splitting strings in Java, which is the String.split() method. This method takes a regular expression, which is just perfect for this problem. Using this method is fine, we just have to analyze the content of the array to solve the problem.

With Java 8, there is a nicer pattern, that leads to the use of streams to solve the kata. The new method is Pattern.splitAsStream(). This instance method on a Pattern object generates a stream from a regular expression and a string to be split, passed as a parameter to this method.

The big difference between both patterns is that the second one splits the string lazily, as needed by the rest of processing of the stream. In this case, the strings to be split are rather small, and the number of elements generated is also very small, so it will not make much difference. But this pattern is interesting to know, because on large strings it can really make a difference. In the case where the terminal operation of the stream is a findFirst() for instance, then the splitting will only occur if needed. With a String.split() pattern, the whole string is split in an array before the terminal processing is launched.

### Exceptions in Java
The exception part may be a good occasion to check the elements every Java developer should know about exceptions.

1) We have three types of exceptions in java : runtime exceptions which are unchecked, checked exceptions and errors. Runtime exceptions extend RuntimeException and are not checked. Examples are NullPointerException, NumberFormatException and many others. Errors extend Error are unchecked and should not be used in our applications. Examples are OutOfMemoryError, StackOverflowError and others. Checked exceptions extend Exception and are checked. Examples are IOException, SQLException and so many others. In this kata, creating a checked exception will lead to a compiler error. So should we create a checked exception, refactor the code, but take the risk that other unknown part of our application could fail because we changed the contract of a public API? Food for thought…

2) When we rethrow an exception by wrapping a root exception in an application exception, we should always add the root cause exception as a parameter to the constructor of our application exception. That supposes the right constructor has been created in our home made exception. The problem is that this constructor has been added in the JDK in Java 6. So legacy applications might not have it. Adding it is harmless and will make debugging possible. Not easier, possible.

3) All the exceptions extend Throwable in Java, and Throwable is serializable. So all the exception we create should have an explicit empty constructor. Believe me, you do not want to debug an application that crashed because a remote exception cannot be recreated in the client due to as missing empty constructor.

### Wrap-up
StringCalculator is a nice kata, not very hard, another good occasion to work on problem slicing and TDD. And for the Java version of this kata, a good occasion to make sure everything is known about exceptions!

# The LeapYears Kata
## The Kata
Write a function that returns true or false depending on whether its input integer is a leap year or not. A leap year is defined as one that is divisible by 4, but is not otherwise divisible by 100 unless it is also divisible by 400.

For example 2001 is a typical common year and 1996 is a typical leap year, whereas 1900 is an atypical common year and 2000 is an atypical leap year.

## Comments
The LeapYear kata is a very good kata to be made second after the FizzBuzz kata. Why? Because people learning TDD need to fail somewhere to fully understand that TDD is there to help them. So I usually give this kata just after FizzBuzz, and let people do what they want, especially if they do not follow the right TDD path. In fact, what I like, is seeing them jumping in the implementation of the specification, writing a first version that will not work, and then falling in a doomed fix / run the test / fix again loop that will lead them to more complexity, more bugs, and loose them in the end.

This may seem cruel, but it is sometimes good to be put in front of one’s weaknesses. The logical expression of a leap year is quite complex, and not that easy to correctly implement in one go.

Beside this, all the principles I tell people during the FizzBuzz kata are just the same here: baby steps, the importance of naming elements (fields, variables, methods, test methods), extracting technical code in correctly named private methods, etc.

On the overall, this kata is very similar to the FizzBuzz kata, slightly more difficult.

I added a leapyears-kata branch in this repo with a way of solving this kata, commit by commit. You can access the first commit of this branch here.

## Wrap-up
The LeapYear kata is a nice introductory kata, a little harder than the FizzBuzz one, mainly due to a quite complex boolean expression to write. This being said, the baby steps approach works very well here, and the problem is very easy to split.

# The RPN Calculator Kata
## The Kata
A RPN calculator program computes expressions written in RPN (Reverse Polish Notation).

A RPN expression (or a postfix expression) is one of the following:

* a number X, in which case the value of the expression is that of X;
* a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an arithmetic operation; in this case, the value of the expression is that of E1 O E2

The following are RPN expressions:

* `1` => `1`
* `1 2 +` => `(1 + 2) = 3`
* `20 5 /` => `(20 / 5) = 4`
* `4 2 + 3 -` => `(4 + 2) - 3 = 3`
* `3 5 8 * 7 + *` => `3*((5*8) + 7) = 141`

Once this calculator works, add the `SQRT` operator:

* `9 SQRT` => `3`

Once the `SQRT` operator has been added, add the `MAX` operator:

`5 8 1 4 2 MAX` => `8`

## Comments
The RPN Calculator kata is also a very classical kata, seen everywhere. It is a good and fairly simple training to learn TDD. Splitting the kata in simple subproblems is fairly straightforward: taking all the operations one by one is a good approach.

The right solution to implement such a problem is to use a stack. This structure is not very widely used in business applications, so it might be a good idea to work on this point, and realize how simple it is to use it in this problem.

The version proposed here has two more questions than the basic version usually found everywhere: it asks for the support of the `SQRT` operation, and the `MAX` operation. I explain in the following why I added them.

I added a rpncalculator-kata branch in this repo with a way of solving this kata, commit by commit. You can access the first commit of this branch here.

### The Strategy Pattern
Once the stack is in place, the code will probably be organized around a big `if then else` structure, with all the operations in it.

It is probably a good occasion to remind people of the open-close principle. Once the code is written and the functionality is implemented, you should not have to rewrite it. If you have to do it, it means that your code is not closed. So once you have implemented the addition and the substraction, for instance, you realize that to add the support for the multiplication, you need to add a branch to this `if then else` structure. By doing that, you reopen your code, thus it is not closed.

A way of dealing with this could be to use the Template Method pattern from the GoF. It consists in putting the code that analyzes the stack in a class, and create an abstract class, called `Operation` for instance, with an abstract `compute()` method. Instances of this class can be used as delegate objects in the main structure, that also holds the stack. It is then possible to implement this class with a `Add`, `Sub`, etc… concrete classes. This approach will work, but used the Template Method pattern of the GoF, which is in violation of the First Principle of the GoF: prefer delegation over inheritance. Yes, the Gof does not always follow the GoF principles…

There are two reasons for not using the Template Method pattern as is. First it violates one of the principle of the GoF itself: prefer delegation over inheritance, we just saw that. Second, we have a very good tool in Java to implement this pattern using delegation: the enumerations.

This leads to the Strategy Pattern: each branch of the `if then else` is encoded in a method of an enumerated value. This way, it turns out that adding an operation simply adds an enumerated value to the enumeration. Moreover, with Java 8, we can leverage lambdas to fully implement those enumerated values. If we need to stick to Java 7, we can create an abstract method in our enumeration, and implement it with the code of the operation in the enumerated value.

Here is a possible implementation of this enumeration for Java 8.
```
enum Operation {
    ADD((x, y) -> x + y), 
    SUB((x, y) -> x - y), 
    MULT((x, y) -> x*y), 
    DIV((x, y) -> x/y);
    
    private BinaryOperator<Integer> operator;
    
    private Operation(BinaryOperator<Integer> operator) {
        this.operator = operator;
    }
    
    public int compute(int x, int y) {
        return operator.apply(x, y);
    }
}
```

The Java 7 version of this code is a little more complicated, since it cannot use lambdas.
```
abstract enum Operation {
    ADD {
        public int compute(int x, int y) { return x + y;}
    }, 
    SUB {
       public int compute(int x, int y) { return x - y;}
   }, 
    MULT {
        public int compute(int x, int y) { return x * y;}
    }, 
    DIV {
       public int compute(int x, int y) { return x / y;}
   };
    
    public abstract int compute(int x, int y);
}
```

### Dealing with SQRT and MAX
When the four basic operations have been implemented, we have an enumeration with four enumerated values, and a field holding the corresponding lambda. The signature of this lambda is probably a `BinaryOperator`, taking two arguments and returning the value.

So what happens if we want to implement an operation that takes one argument, or more than two arguments? This is the reason why I decided to add the `SQRT` and the `MAX` operations to the first version of this kata.

Obviously, whether it is implemented using a lambda or by any other means, the method that implements this operation cannot be a binary operator anymore. Choosing a solution that would consist in specifying the number of arguments, and then having a switch to the right lambda will lead to very complex code, that violates the open close principle. You can end up writing a method in the abstract part of your code (in the Template Method sense), that will depend on the concrete part of it! Which is a very, very wrong thing to do…

I think that the simplest way to deal with this problem, especially for the `MAX` operation, is to pass the stack itself, do the computation, and push the result to the stack before returning. Using a side effect is certainly not a solution that I would recommend, but I think that, in this case, it is the simplest one. What I do not like with side-effects, is that you need to document it very precisely in the Javadoc of your API, and that nobody reads the docs. So you end up with bugs due to unexpected behavior most of the time.

## Wrap-up
Th RPN Calculator is a nice kata, not too complicated, but still more complex than the FizzBuzz or Leap Years. It is a good kata to work on the Strategy Pattern, lambdas and enumerations in the Java language. It is also a good way to work with stack based algorithms, vey often overlooked.

## Side note
I saw many Java developers using the `Stack` class to create a stack. All of them knew that `Vector` is an old class from the early days of the Java language, that should not be used anymore. And they are right, `Vector` has been made thread-safe in the most basic way (not to say dumb), by synchronizing all of its methods. Stay away from that!

Quite oddly very few of them realize that `Stack extends Vector`… To implement a stack, `ArrayDeque` is the right choice most of the time. If you need thread-safey, `ArrayBlockingQueue` is nice, but can only hold a fixed amount of elements (it does not magically extends itself as `ArrayList` does). If you want an auto-extensible feature, (that can break you application, be careful, you are in a concurrent world!) the `ConcurrentLinkedQueue` is the structure you want to use.

# The One Two Kata
## The Kata
### Part 1
We need a method to convert strings to other strings in the following way. To understand the conversion, just read the input string. The first example string shows one two. There is indeed one number, and this number is two.

* `2` -> `one two`
* `1 2` -> `one one one two`
Easy. Now, we can also count numbers, as in the following examples.

* `2 2` -> `two two`
* `3 9 9 9 8 8` -> `one three three nine two eight`
* `1 1 1 1 1 1 1` -> `seven one` (Brasilians will love this example)
* `2 4 4 4 6 6 6 6 6` -> one two three four five six
Got it? Now, to keep things simple, we do not count past 9. Thus the conversion of the following string.

`5 5 5 5 5 5 5 5 5 5 5 5` -> `nine five three five`

## Part 2
And of course we would like a second method to do the opposite conversion.

## Comments
This kata is pretty straightforward, a good occasion to rehearse what has been seen in Fizz Buzz, Leap Years and the like. It is easily solved with a queue, which is another good occasion to work with this structure. This kata is a little more complex than those two though, and proposes a nice refactoring on the queue-based algorithm. It shows how to expand a single, big block if else to several smaller blocks, in order to apply the Single Responsibility Principle. The intermediate state (of the code) is not very nice, but leads to an easier method extraction, which was not really possible in the previous state.

I added a onetwo-kata branch in this repo with a way of solving this kata, commit by commit. You can access the first commit of this branch here.

### Strategy and Queues
There are several interesting points in this kata. First, quite obviously, there is a strategy pattern that is going to emerge, to convert numbers to their equivalent in letters. Second, there is a queue based algorithm in both conversions, with a state that depends on a commutation of the values when we do the first conversion.

Basically, the first conversion needs to count the elements that are the same, then create a pair once the element changes, made of the number of same elements we saw, and the element itself. This can be easily done with the following code, very basic:
```
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    if (deque.peek() == currentValue) {
        deque.poll();
        count++;
    } else {
        result.add(count);
        result.add(currentValue);
        count = 1;
        currentValue = deque.poll();
    }
}
result.add(count);
result.add(currentValue);
```
We need to refactor this code. Why? Well, first because its complexity is out ot control: a `if else` inside a `while`. Second because it breaks the single responsibility principle: the `if` branch does two things, and the `else` branch does three (at least). If we want to have a `while` with clear, readable, methods calls in it and no `if else`, we need to organize the code differently. And the easiest first step, is to have one action in each `if` or `else` branch.

The consequence of breaking the SRP is that it is much more difficult to extract the technical code into meaningful methods.

### Expanding if
The price to pay is to first create as many `if else` as we need to apply the single responsibility principle. We can rewrite this code like that.
```
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    if (deque.peek() != currentValue) {
        result.add(count);
        result.add(currentValue);
    }
    if (deque.peek() == currentValue) {
        count++;
    } else {
        count = 1;
    }
    if (deque.peek() == currentValue) {
        deque.poll();
    } else {
        currentValue = deque.poll();
    }
}
result.add(count);
result.add(currentValue);
```
We just need to be careful because the order in which those `if` are written is not random… But we have tests, don’t we?

### Extracting methods
Of course this code is not in its final state. But now, since the SRP holds for each if branch we can now easily extract methods.
```
List<Integer> result = new ArrayList<>();
int currentValue = deque.peek();
int count = 0;
while (!deque.isEmpty()) {
    boolean isValueChanging = deque.peek() != currentValue;

    addToResultIfChanging(result, currentValue, count, isValueChanging);
    count = incrementOrResetIfChanging(count, isValueChanging);
    currentValue = consumeAndUpdateIfChanging(deque, currentValue, isValueChanging);
}
addToResult(result, currentValue, count);
```
There is still one thing I do not really like in this code: the side effect we have in `addToResultIfChanging()`. We could return the `result` list, or return a sublist and add it all to the result main list.

There is another side effect in the `consumeAndUpdateIfChaning()` call. This method does in fact two things: it updates the current value, and modifies the state of the queue. Not that great, but in queue based algorithms, it is very common.

### Reverse conversion
The refactorings we do in the reverse conversion are almost the same and based on the same principles.