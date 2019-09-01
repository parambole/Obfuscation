package com.pb.dev.obfuscation.Protection;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Filter {

    // JSON keys that will be filtered
    String[] keys() default {};
}
