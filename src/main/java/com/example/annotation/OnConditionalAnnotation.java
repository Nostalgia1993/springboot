package com.example.annotation;


import com.example.config.OnConditionalSelector;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Conditional(OnConditionalSelector.class)
public @interface OnConditionalAnnotation {

    String system() default "";

}
