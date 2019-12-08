package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */


public interface BeschreibungsdokumentGraphRepository extends Neo4jRepository<Beschreibungsdokument,String> {

  List<Beschreibungsdokument> findByTitelAndSignatur(String titel, String signatur);

  @Query("MATCH (b:Beschreibungsdokument{titel:{titel} & signatur:{signatur}})-[:r]->(n) return b")
  List<Beschreibungsdokument> findWithTitelAndSignatur(String titel, String signatur);
}
