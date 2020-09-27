package loki.runtime.marker.compilerapi.unitcontext;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.context.LUnitContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@DescribingMethodClass(LUnitContext.class)
public @interface UnitContextGetVariable {}
