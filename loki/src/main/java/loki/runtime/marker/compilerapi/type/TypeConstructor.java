package loki.runtime.marker.compilerapi.type;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.LUnitType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LUnitType.class)
public @interface TypeConstructor {}
