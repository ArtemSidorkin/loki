package loki.runtime.compilerapi.number;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.unit.data.number.LNumber;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LNumber.class)
public @interface NumberConstructor {}
