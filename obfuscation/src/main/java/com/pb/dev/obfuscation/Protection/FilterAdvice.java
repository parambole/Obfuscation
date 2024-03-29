package com.pb.dev.obfuscation.Protection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class FilterAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    Obfuscator obfuscator;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        List<Annotation> annotations = Arrays.asList(returnType.getMethodAnnotations());
        return annotations.
                stream().
                anyMatch(annotation -> annotation.annotationType().
                        equals(Filter.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        List<String> obfuscationList =
                Arrays.asList(returnType.getMethodAnnotation(Filter.class).keys());
        return obfuscator.obfuscateData(body, obfuscationList);
    }
}
