package de.eichstaedt.handschriftengraphviewer.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class TestingServiceTest {

    @Autowired
    private TestingService testingService;

    @Test
    void testFindAll() {

        Map<String,String> result = testingService.findAllBeschreibungenTest();

        Assertions.assertNotNull(result);
    }
}
