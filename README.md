# Loki programming language

## Short examples
 - [HelloWorld.loki](examples/HelloWorld.loki)

 - [Function.loki](examples/Function.loki)

 - [Class.loki](examples/Class.loki)

 - [LinkedList.loki](examples/LinkedList.loki)

 - [Factorial.loki](examples/Factorial.loki)

For currently implemented capabilities see [tests](loki/src/test/resources/tests/)

## Compilation

Minimal java version: 8

Tested on openjdk 15.0.2

    ./gradlew assemble

## Run

    java -jar ./loki/build/libs/loki-all.jar ./examples/HelloWorld.loki

    java -jar ./loki/build/libs/loki-all.jar ./examples/Function.loki

    java -jar ./loki/build/libs/loki-all.jar ./examples/Class.loki

    java -jar ./loki/build/libs/loki-all.jar ./examples/LinkedList.loki

    java -jar ./loki/build/libs/loki-all.jar ./examples/Factorial.loki

For any questions: ArtemSidorkin1@gmail.com
