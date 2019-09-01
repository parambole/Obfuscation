# Obfuscation: Data Privacy in API response

As a developer, we need to make sure not to publish personally identifiable information (PII) of our users. Majority of times, we achieve this by hiding data at the UI side usually by hiding the element. But, the API response will still contain the PII data.

## How to achieve Data Privacy in API response
In JAVA, this can be achieved using a combination of Annotations and ResponseBodyAdvice.


1. The first step is to create a new Annotation that can be used to mark an API which has sensitive information. The annotation can also contain the response keys that need to be obfuscated.

```
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Filter {
// JSON keys that will be filtered
    String[] keys() default {};
}
```

2. The second step is to implement the ResponseBodyAdvice: which Allows customizing the response after the execution of a controller method but before the body is written.
```
@ControllerAdvice
public class FilterAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    Obfuscator obfuscator;
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // Check if the API is annotated
}
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // write code to obfuscate the data
    }
}
```

3. The third and final step is to annotate the API.

```
@RestController
public class ObfuscationExample {

    @RequestMapping("/greeting")
    @Filter(keys = {"Name"})
    public Map<String,Object> greeting() {
        Map<String,Object> response = new HashMap<>();
        response.put("Name","Justine");
        return response;
    }

}
```
