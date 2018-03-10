# Loki programming language

##Short examples
 - [examples/HelloWorld.loki](HelloWorld.loki)

 - [examples/Function.loki](Function.loki)

 - [examples/Class.loki](Class.loki)

 - [examples/LinkedList.loki](LinkedList.loki)

##Compilation

    mvn clean compile assembly:single

##Running

    java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar HelloWorld.loki

    java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar Function.loki

    java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar Class.loki

    java -jar ./target/CLoki-0.0.1-jar-with-dependencies.jar LinkedList.loki
