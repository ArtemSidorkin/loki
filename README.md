# Loki programming language

Loki is under development now, in middle stage of version 0.0.1.
For now implemented variables, arrays, arithmetic, loop while, conditions, functions/lambdas, oop (partially).
For now working on tests.

##Short examples
HelloWorld.cloki

Function.cloki

Class.cloki

LinkedList.cloki

##Compilation
 mvn clean compile assembly:single

##Running
!Important! Pass file without extension.

java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar HelloWorld

java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar Function

java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar Class

java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar LinkedList
