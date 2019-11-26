package de.eichstaedt.handschriftengraphviewer.domain.service;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph.BeschreibungsdokumentGraphRepository;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms.BeschreibungsdokumenteRDBMSRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<Beschreibungsdokument> beschreibungRDBMS = StreamSupport
            .stream(rdbmsRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());

        LocalDateTime endRDBMS = LocalDateTime.now();

        LocalDateTime startGraph = LocalDateTime.now();

        List<Beschreibungsdokument> beschreibungsdokumentGraph = StreamSupport
            .stream(beschreibungsdokumentGraphRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());;

        LocalDateTime endGraph = LocalDateTime.now();

        result.put("RDBMS_FINDALL",String.valueOf(ChronoUnit.MILLIS.between(startRDBMS,endRDBMS)));
        result.put("GRAPH_FINDALL",String.valueOf(ChronoUnit.MILLIS.between(startGraph,endGraph)));

        logger.info("Testing find all {} ", result.toString());

        logger.info("RDBMS Beschreibungen {} GRAPH {} ",beschreibungRDBMS.size(),beschreibungsdokumentGraph.size());

        return result;
    }
}
