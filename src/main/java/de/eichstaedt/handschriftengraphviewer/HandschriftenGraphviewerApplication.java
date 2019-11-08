package de.eichstaedt.handschriftengraphviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("de.eichstaedt.handschriftengraphviewer.infrastructure")
@EntityScan(basePackages = "de.eichstaedt.handschriftengraphviewer.domain")
public class HandschriftenGraphviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandschriftenGraphviewerApplication.class, args);
	}

}
