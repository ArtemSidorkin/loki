package loki.runtime.marker.compilerapi.string;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.unit.data.LString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LString.class)
public @interface StringConstructor {}
