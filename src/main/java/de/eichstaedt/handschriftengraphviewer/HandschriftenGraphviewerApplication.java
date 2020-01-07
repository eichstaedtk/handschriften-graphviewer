package de.eichstaedt.handschriftengraphviewer;

import de.eichstaedt.handschriftengraphviewer.domain.service.TestingService;
import de.eichstaedt.handschriftengraphviewer.infrastructure.xml.XMLService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph")
@EnableJpaRepositories("de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms")
@EntityScan(basePackages = "de.eichstaedt.handschriftengraphviewer.domain")
public class HandschriftenGraphviewerApplication {

	@Value("${data.loading}")
	private Boolean dataloading;

	@Autowired
	public HandschriftenGraphviewerApplication(
			XMLService xmlService, TestingService testingService) {
		this.xmlService = xmlService;
		this.testingService = testingService;
	}

	private XMLService xmlService;

	private TestingService testingService;

	public static void main(String[] args) {
		SpringApplication.run(HandschriftenGraphviewerApplication.class, args);
	}

	@PostConstruct
	private void createTestDataSetup() {


		if(dataloading) {
			xmlService.loadingXMLData();
		}


		testingService.createTestDataSet(628,5);

	}

}
