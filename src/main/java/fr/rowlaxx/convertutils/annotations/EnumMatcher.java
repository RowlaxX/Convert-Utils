package fr.rowlaxx.convertutils.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface EnumMatcher {

	public String[] possibleMatchs() default {};
	public boolean caseSensitiv() default true;
	
}
