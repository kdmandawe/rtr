# Toy Robot Simulator

The Toy Robot Simulator is a representation of a system that simulates a **Toy Robot** moving around a **Table Top**. 
For the robot to make movements, it must take some **Commands** from an **Input** coming from the robot-fanatic 'Player'
or client.

Please see [PROBLEM.md](PROBLEM.md) for a more detailed description of what the simulator does including constraints and
example input and output.

## Prerequisites
- [JDK 1.8]
- [Maven 3.5.x]

## How to run 

1. Download/clone the project.
2. From base directory of project, execute: 

    ```
    mvn clean package
    ``` 
3.  Go to `<baseDir>/target/`. You should find the jar files being created. Use the one ending 'with-dependencies.jar' 
    as it is the 'fat jar' containing all dependencies already. When running it, there's no need to specify any other 
    dependencies in the classpath.
4.  Run the jar file with either of the following:
    - Supplying an input file(supply correct **version** and **filename** present on the same directory):
        ```
            $ java -jar rea-toyrobot-<version>-jar-with-dependencies.jar <filename>
        ```  
    - Directly input commands on the terminal like the below actual example:
        ```
            $ java -jar rea-toyrobot-1.0-SNAPSHOT-jar-with-dependencies.jar
            
            Enter the commands(one per line).
            To end, input 'q!'
            
            PLACE 0,0,NORTH
            MOVE
            REPORT
            q!

        ``` 

## Testing and Profiles

There are three predefined profiles in this project: 'dev', 'integration-test', and 'ci'. By default, 'dev' is activated.

Running `mvn clean package` runs the unit tests.

To run integration tests only, execute:

```
mvn clean verify -P integration-test
```

To run both unit tests and integration tests, execute:

```
mvn clean verify -P ci
```

## Solution and Design Considerations

### Real World Objects
*Uri, my two-year old boy walks by the toy section of a department store. A **robot-fanatic** as he is, he suddenly 
stopped by a **setup** of a **table** and a shiny **robot** wondering what it does. A salesman immediately turned on the
the **setup** and gave commands like 'PLACE 0,0,NORTH', 'MOVE', 'LEFT', 'RIGHT', 'REPORT'. Awesome! it's like a 
'your-wish-is-my-command' experience! The robot moved and reported the correct **placement**!*

### OOP Goodness

So much of the story, the design is purely object-oriented. That's the story I'm imagining while I'm thinking of how to
implement the solution.

#### Key Players (or Objects :)
- ToyRobot - the shiny smart robot in the story above. This is the main player. It performs accordingly depending on what 
command is fed.
- TableTop - the table in the story above. This is where the robot will perform its movements. The ToyRobot therefore has
to be assigned with a TableTop.
- ToyRobotSimulator - this corresponds to the 'setup' on the story above. This will hold the key Objects above. First it
receives the raw commands and then translate those into Command objects which the robot can understand for the 
corresponding action.
- InputHandler - the ToyRobotSimulator will have this to understand input commands.
- ToyRobotPlayer - this is the robot-fanatic kid. This is the client that wants to 'play' the simulator.

#### DESIGN PATTERNS

- Command Pattern - this is being used to make the ToyRobotSimulator oblivious of the actual action the robot does for
each command. The simulator's main responsibility is to accept commands and call 'perform' method in each command. This 
promotes loose coupling and extensibility.
- Factory Pattern - provides convenience to clients when trying to create instances of the object especially if there are
conditions that would determine which type of instance to create. Some classes that are factories are: 
`Commands`, `InputHandlers`, `ToyRobots`, `TableTops` and `PropertyProviders`
- Step Builder Pattern - The creation of ToyRobotSimulator instance is somehow complex. A first time client/user will 
need to dig into the constructors and javadocs probably. This pattern solves it! Just start with 
`SimulatorBuilder.newBuilder()` and follow with succeeding dot(.), it will then give you what's the next method that you
should invoke before finally arriving to `.build()` which will give the final instance.

#### LOOSE COUPLING, OPEN-CLOSED PRINCIPLE

- Can I add Commands easily?
- Can I add something like AdvancedToyRobot that does some fancier stuff than the BasicToyRobot?
- Will I touch already released codes when I want to modify something or worse will I introduce bugs?
- Will someone new to the team understand my code easily and doesn't have to call me to fix something or do an extensive
walkthrough?

The above are top considerations on the design of this solution. To promote loose coupling, you'll be seeing heavy use of 
interfaces and as mentioned above, design patterns.

## Author

Kenneth Mandawe <kdmandawe06@gmail.com>

## Acknowledgments

* The awesome people at REA group
* Tech Talent Scout Simon Hedt
* A very respected friend and professional connection Bob Danani

[JDK 1.8]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[Maven 3.5.x]: https://maven.apache.org/install.html