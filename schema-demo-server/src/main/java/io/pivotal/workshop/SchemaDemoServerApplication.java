package io.pivotal.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;

@EnableSchemaRegistryServer
@SpringBootApplication
public class SchemaDemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaDemoServerApplication.class, args);
	}
}
