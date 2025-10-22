## Observer Pattern Summary

The Observer Pattern defines a foundational way for objects to interact while maintaining flexibility and low interdependence.

### Core Definition and Roles

The Observer Pattern defines a **one-to-many dependency between objects** so that when one object changes state, all of its dependents are notified and updated automatically.

This relationship involves two primary roles:

1.  **Subject (Publisher):** The Subject is the object that contains and controls the state, and it is responsible for managing its observers.
2.  **Observer (Subscriber):** The Observers are dependent objects that use the Subject's state. They register with the Subject to receive automatic notifications when the Subject's state changes.

The structure often involves **Subject** and **Observer** interfaces:

*   The `Subject` interface includes methods like `registerObserver()`, `removeObserver()`, and `notifyObservers()`.
*   The `Observer` interface requires a method, typically `update()`, which is called when the Subject's state changes.

### The Power of Loose Coupling

A major benefit of the Observer Pattern is the promotion of **loosely coupled designs** between objects that interact.

Loose coupling is achieved because:

*   The Subject only knows about an Observer through its implementation of the **Observer interface**. The Subject does not need to know the Observer's concrete class, what it does, or any other implementation details.
*   New observers can be added or removed at any time without requiring modification to the Subject's code.
*   Changes made to either the Subject or an Observer will not affect the other party, provided they continue to fulfill their obligations to implement their respective interfaces.

### Application Example: The Weather Station

The sources use the development of a Weather Monitoring application to demonstrate the Observer Pattern.

*   **System Components:** The core system includes a physical weather station, a `WeatherData` object (which tracks incoming data and calls `measurementsChanged()` whenever new data is available), and multiple display elements (Current Conditions, Weather Statistics, Forecast).
*   **Applying the Pattern:** The `WeatherData` class is designated as the **Subject** because it holds the state (temperature, humidity, pressure). The various display elements are the **Observers** because they depend on the Subject's state to update their presentation.
*   **Implementation Strategy:** Instead of hardcoding updates for specific display classes within `WeatherData` (which violates encapsulation and flexibility principles), the `WeatherData` class implements the `Subject` interface, managing a list of `Observer` instances. When the data changes, `notifyObservers()` is called, which loops through the registered observers and calls their shared `update()` method.

### Data Transfer: Push vs. Pull

When the Subject notifies the Observers via the `update()` method, there are two primary ways to transfer the data:

1.  **Push:** The Subject passes the updated state (e.g., temperature, humidity) directly as parameters to the Observer's `update()` method.
2.  **Pull:** The Observer is merely notified that a change occurred (e.g., calling an `update()` method with no parameters) and then calls getter methods directly on the Subject to retrieve the specific data it needs.

The pull model is often considered more "correct" in flexible designs because if the Subject adds new data (like wind speed), Observers that do not need that data are not forced to change their `update()` method signature, reducing necessary modifications across the system.

### Observer Pattern in the Real World

The Observer Pattern is frequently found in many libraries and frameworks:

*   **Java SDK:** Both the **JavaBeans** and **Swing** libraries use the Observer Pattern.
*   **Swing:** In user interface programming, components like buttons are subjects that accept listeners (observers). The `ActionListener` interface often functions as the `Observer` interface.
*   **Other Frameworks:** The pattern is also used in JavaScript events and other language frameworks.

### Key Design Principles Reinforced

The Observer Pattern helps developers adhere to key object-oriented design principles:

*   **Encapsulate what varies:** The Subject's notification system and the dependency relationships are encapsulated.
*   **Program to interfaces, not implementations:** Subjects interact solely with the `Observer` interface, not concrete classes.
*   **Strive for loosely coupled designs between objects that interact:** This principle is the entire motivation for the pattern.