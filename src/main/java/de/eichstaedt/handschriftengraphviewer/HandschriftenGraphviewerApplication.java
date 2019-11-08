package de.eichstaedt.handschriftengraphviewer;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.domain.KulturObjektDokument;
import de.eichstaedt.handschriftengraphviewer.infrastructure.KulturObjektDokumentRepository;
import java.time.LocalDateTime;
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
			KulturObjektDokumentRepository kulturObjektDokumentRepository) {
		this.kulturObjektDokumentRepository = kulturObjektDokumentRepository;
	}

	private KulturObjektDokumentRepository kulturObjektDokumentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HandschriftenGraphviewerApplication.class, args);
	}

	@PostConstruct
	private void createTestDataSetup() {

		KulturObjektDokument kulturObjektDokument = new KulturObjektDokument("31275197", LocalDateTime.now());

		Beschreibungsdokument beschreibungsdokument = new Beschreibungsdokument("31275197",kulturObjektDokument,LocalDateTime.now());

		kulturObjektDokument.getBeschreibungen().add(beschreibungsdokument);

		kulturObjektDokumentRepository.save(kulturObjektDokument);
	}

}
