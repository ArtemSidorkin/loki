package loki.runtime.marker.compilerapi.array;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.unit.data.array.LArray;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LArray.class)
public @interface ArrayConstructor {}
