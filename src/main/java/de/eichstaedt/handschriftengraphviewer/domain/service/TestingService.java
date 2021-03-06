package de.eichstaedt.handschriftengraphviewer.domain.service;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.domain.DokumentElement;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph.BeschreibungsdokumentGraphRepository;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms.BeschreibungsdokumenteRDBMSRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public void createTestDataSet(int number, int depth) {


        List<Beschreibungsdokument> testDokumente = new ArrayList<>();

        IntStream.range(1,number+1).forEach(c -> {
            String uuid = UUID.randomUUID().toString();

            Beschreibungsdokument beschreibungsdokument = new Beschreibungsdokument(uuid,"TestBeschreibung "+uuid,"TestSignatur "+uuid);

            IntStream.range(1,10).forEach(i -> {
                DokumentElement element = new DokumentElement(uuid+'-'+i,"Element "+i,"Beschreibungstext");
                beschreibungsdokument.getBestandteile().add(element);

                addChild(element,depth,0);

            });

            testDokumente.add(beschreibungsdokument);

        });

        logger.info("Save synthetic testdata of size {} ", testDokumente.size());

        final AtomicInteger counter = new AtomicInteger();

        testDokumente.stream()
            .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 50)).values().forEach(l -> {

            beschreibungsdokumentGraphRepository.saveAll(l);

            logger.info("Saved graph number of entities {} {} ",counter,l.size());

            rdbmsRepository.saveAll(l);

            logger.info("Saved rdbms number of entities {} {} ",counter,l.size());
        });

        logger.info("Saved synthetic testdata to GRAPH DB and RDBMS");
    }

    private DokumentElement addChild(DokumentElement element, int d, int counter) {

        DokumentElement child = new DokumentElement(UUID.randomUUID().toString() + '-' + counter,
            "Child " + counter, "Beschreibungstext");
        element.getBestandteile().add(child);

        logger.debug("Add DokumentElement {} with counter {} ",child,counter);

        counter++;

        if (counter <= d)
        {
            addChild(child,d,counter);
        }

        return child;
    }
}
