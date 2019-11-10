package de.eichstaedt.handschriftengraphviewer.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.eichstaedt.handschriftengraphviewer.domain.ProvenienzResult;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-09.
 */


@SpringBootTest
public class ProvenienzRepositoryTest {

  @Autowired
  private ProvenienzRepository provenienzRepository;

  @Test
  void testFindProvenienzen() {

    List<ProvenienzResult> result = provenienzRepository.findAllProvenienz();

    assertEquals(246,result.size());
  }
}
