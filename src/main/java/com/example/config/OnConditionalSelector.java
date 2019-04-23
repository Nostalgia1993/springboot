package com.example.config;

import com.example.annotation.OnConditionalAnnotation;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnConditionalSelector implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(OnConditionalAnnotation.class.getName());
        String system = (String) map.get("system");
        return system.equals("windows");
    }
}
