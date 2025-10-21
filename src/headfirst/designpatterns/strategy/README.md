### 1. The Design Problem and Solution

The core knowledge about the Strategy Pattern is derived from solving the initial design flaw in the SimUDuck simulator:

*   **The Initial Flaw:** The original design used **inheritance** (subclassing) from a common `Duck` superclass for sharing behaviors like `quack()` and `fly()`. This approach became problematic when new requirements mandated different behaviors (e.g., making ducks fly). Ducks like `RubberDuck` should not fly, and modifying the inherited behavior required tracking down and changing code in multiple subclasses, potentially introducing new bugs. Using interfaces also failed because it provided no code reuse.
*   **The Solution Goal:** The objective was to create a flexible design that is maintainable and can cope with change. The solution required separating the parts of the code that frequently change (flying and quacking behaviors) from the parts that remain constant.

### 2. Core Object-Oriented (OO) Design Principles Applied

The Strategy Pattern is a direct application of three fundamental OO principles demonstrated in the solution:

1.  **Encapsulate what varies:** This principle directs the developer to **identify the aspects of the application that vary and separate them from what stays the same**. In the SimUDuck application, the `fly()` and `quack()` methods were the parts that varied, so they were pulled out of the `Duck` class and placed into separate behavior classes. This concept forms the basis for almost every design pattern.
2.  **Program to interfaces, not implementations:** The duck behaviors are implemented as interfaces (`FlyBehavior` and `QuackBehavior`) rather than concrete classes. This principle means programming to a supertype (like an interface or abstract class) to ensure the client is not locked into the actual runtime object, exploiting polymorphism.
3.  **Favor composition over inheritance:** The Strategy Pattern achieves flexibility by relying on **composition**. Instead of inheriting behavior (**IS-A** relationship), the `Duck` class holds a reference to a behavior object (**HAS-A** relationship). Composition allows for greater flexibility and lets behavior be changed dynamically at runtime.

### 3. Mechanism: Composition and Delegation

The pattern establishes a method for integrating the new behaviors:

*   **Delegation:** The `Duck` class is equipped with two instance variables of the behavior interface types (`flyBehavior` and `quackBehavior`). When a behavior is requested (e.g., `performQuack()`), the `Duck` object delegates the request to its associated behavior object (`quackBehavior.quack()`).
*   **Encapsulation of Behaviors:** By using delegation and interfaces, the implementation of flying and quacking behaviors is sealed off, allowing these behaviors to be viewed as a **"family of algorithms"** that are interchangeable.

### 4. Formal Strategy Pattern Definition

The Strategy Pattern is formally introduced on page 24 as the solution resulting from applying these principles to the SimUDuck application.

**Definition:** **The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it**.