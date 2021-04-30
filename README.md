# Lab_8

<H2>Task</H2>
<p>Write code for UML diagram from lab 2<br>
My lab 2 task:<br>

- **Zoo**. Implement a hierarchy of animals that live in zoo aquariums. <br>
  Search for animals that live longer than 5 years. Print the result sorted by animal species.<br>
  Implement the ability to sort the animals by the volume of the aquarium, implemented as a separate method.<br>
  The implementation of sorting should provide the ability to sort both in descending and ascending order
 </p>

### Class diagram:
<p>
https://drive.google.com/file/d/1RRx1aoQ5wx8FrW66Up0_rmq-FMBfH9wd/view?usp=<br>
Also diagram was added to git as ZooClassDiagram.png.</p>

##Requirements
<p>

- Java code convention.
- Classes had to be properly divided into packages.
- Minimal working with the console.
- Code must contain only classes from the class diagram.
- Class attributes and methods should have the same visibility as in class diagram.
- Use the built-in sorting methods available in Java to sort.
- Sorting should be implemented in a separate method.
- Only one static method is allowed in code - `main`.
- Implementing element comparison and sorting should use lambda expressions.
- `Lombok` annotations should be used instead of writing setters and getters.
- Convert a project so that its assembly can be performed using maven.
- Also connect the following plugins to pom.xml:
- - Jacoco 
- - FindBugs
- - PMD
- - Checkstyle 
  
</p>
### To run the program:
- Clone repo:`git clone https://github.com/MykhailoPolnyi/Lab_8`
- Enter the repo folder via `cd` command
- Change branch to Lab_8:`git checkout Lab_8`
- Run `mvn compile`
- Run `mvn package`  
- Run `java -cp target\ZooServiceLab8-1.0-SNAPSHOT.jar ua.lviv.iot.zoo.App`

To check code errors:
- `mvn checkstyle:check`
- `mvn findbugs:gui`
- `mvn pmd:pmd`
    