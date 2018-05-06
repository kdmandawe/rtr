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
## Author

Kenneth Mandawe <kdmandawe06@gmail.com>

## Acknowledgments

* The awesome people at REA group
* Tech Talent Scout Simon Hedt
* A very respected friend and professional connection Bob Danani

[JDK 1.8]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[Maven 3.5.x]: https://maven.apache.org/install.html