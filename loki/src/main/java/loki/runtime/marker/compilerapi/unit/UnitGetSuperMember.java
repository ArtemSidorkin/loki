package loki.runtime.marker.compilerapi.unit;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.unit.unit.LUnit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@DescribingMethodClass(LUnit.class)
public @interface UnitGetSuperMember {}
