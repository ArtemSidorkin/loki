package loki.runtime.compilerapi.type;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.LType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LType.class)
public @interface TypeConstructor {}
