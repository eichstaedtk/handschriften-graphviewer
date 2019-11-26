package de.eichstaedt.handschriftengraphviewer.domain.service;

import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph.BeschreibungsdokumentGraphRepository;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms.BeschreibungsdokumenteRDBMSRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestingService {

    private static final Logger logger = LoggerFactory.getLogger(TestingService.class);

    @Autowired
    public TestingService(BeschreibungsdokumenteRDBMSRepository rdbmsRepository, BeschreibungsdokumentGraphRepository beschreibungsdokumentGraphRepository) {
        this.rdbmsRepository = rdbmsRepository;
        this.beschreibungsdokumentGraphRepository = beschreibungsdokumentGraphRepository;
    }

    private BeschreibungsdokumenteRDBMSRepository rdbmsRepository;

    private BeschreibungsdokumentGraphRepository beschreibungsdokumentGraphRepository;

    public Map<String,String> findAllBeschreibungenTest() {
        Map<String,String> result = new HashMap<>();

        LocalDateTime startRDBMS = LocalDateTime.now();

        rdbmsRepository.findAll();

        LocalDateTime endRDBMS = LocalDateTime.now();

        LocalDateTime startGraph = LocalDateTime.now();

        beschreibungsdokumentGraphRepository.findAll();

        LocalDateTime endGraph = LocalDateTime.now();

        result.put("RDBMS_FINDALL",String.valueOf(ChronoUnit.MILLIS.between(startRDBMS,endRDBMS)));
        result.put("GRAPH_FINDALL",String.valueOf(ChronoUnit.MILLIS.between(startGraph,endGraph)));

        logger.info("Testing find all {} ", result.toString());

        return result;
    }
}
