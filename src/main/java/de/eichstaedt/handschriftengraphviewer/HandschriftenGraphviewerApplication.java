package de.eichstaedt.handschriftengraphviewer;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.domain.Koerperschaft;
import de.eichstaedt.handschriftengraphviewer.domain.Person;
import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import de.eichstaedt.handschriftengraphviewer.domain.ProvenienzTyp;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.ProvenienzRepository;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("de.eichstaedt.handschriftengraphviewer.infrastructure")
@EntityScan(basePackages = "de.eichstaedt.handschriftengraphviewer.domain")
public class HandschriftenGraphviewerApplication {

	@Autowired
	public HandschriftenGraphviewerApplication(
			ProvenienzRepository provenienzRepository) {
		this.provenienzRepository = provenienzRepository;
	}

	private ProvenienzRepository provenienzRepository;

	public static void main(String[] args) {
		SpringApplication.run(HandschriftenGraphviewerApplication.class, args);
	}

	@PostConstruct
	private void createTestDataSetup() {

		Beschreibungsdokument beschreibungsdokument = new Beschreibungsdokument("31275199","Humanistische Schulsammelhandschrift","S 83");

		Koerperschaft bonn = new Koerperschaft("30002387","Universitäts- und Landesbibliothek Bonn","Bonn");

		Person anton = new Person("31275311","Anton","Heuglin");

		Provenienz besitzer = new Provenienz(ProvenienzTyp.Besitzer,bonn,beschreibungsdokument,"1578","2019");

		Provenienz vorbesitzer = new Provenienz(ProvenienzTyp.Vorbesitzer,anton,beschreibungsdokument,"1513/1530","1578");

		provenienzRepository.saveAll(Arrays.asList(besitzer,vorbesitzer));

	}

}
