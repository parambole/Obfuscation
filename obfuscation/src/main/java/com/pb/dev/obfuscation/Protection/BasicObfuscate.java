package com.pb.dev.obfuscation.Protection;

import java.util.List;

public class BasicObfuscate implements  Obfuscator {

    @Override
    public Object obfuscateData(Object body, List<String> obfuscationList) {
        // Obfuscation logic to modify the response body
        return body;
    }

}

