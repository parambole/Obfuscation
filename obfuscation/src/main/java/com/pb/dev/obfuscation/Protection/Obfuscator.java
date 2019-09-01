package com.pb.dev.obfuscation.Protection;

import java.util.List;

public interface Obfuscator {

    Object obfuscateData(Object body, List<String> obfuscationList);

}
