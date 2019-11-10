package de.eichstaedt.handschriftengraphviewer.infrastructure.repository;

import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import de.eichstaedt.handschriftengraphviewer.domain.ProvenienzResult;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public interface ProvenienzRepository extends Neo4jRepository<Provenienz,Long> {


  @Query("MATCH (k:Koerperschaft)-[r:PROVENIENZ]-(b:Beschreibungsdokument) return k as beteiligte,r as provenienz,b as beschreibungsdokument")
  List<ProvenienzResult> findAllProvenienz();

}