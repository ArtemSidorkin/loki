package loki.runtime.marker.compilerapi.modulecontext;

import assembler.methoddescriptor.DescribingMethodClass;
import loki.runtime.context.LModuleContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@DescribingMethodClass(LModuleContext.class)
public @interface ModuleContextConstructor {}
