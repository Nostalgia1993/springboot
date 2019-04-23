package com.example.config;

import com.example.annotation.SelectAnnotation;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class HelloWorldSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String,Object> map = annotationMetadata.getAnnotationAttributes(SelectAnnotation.class.getName());
        boolean isLinux = (boolean)map.get("isLinux");
        if(isLinux){
            return new String[]{HelloWorld.class.getName()};
        }else{
            return new String[]{HelloWorld2.class.getName()};
        }
    }
}
