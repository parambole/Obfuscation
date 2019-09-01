package com.pb.dev.obfuscation;

import com.pb.dev.obfuscation.Protection.BasicObfuscate;
import com.pb.dev.obfuscation.Protection.Obfuscator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObfuscationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObfuscationApplication.class, args);
	}

	@Bean
	Obfuscator obfuscator() {
		return new BasicObfuscate();
	}

}
