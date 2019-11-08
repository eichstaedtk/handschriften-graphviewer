package de.eichstaedt.handschriftengraphviewer.infrastructure.repository;

import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public interface ProvenienzRepository extends Neo4jRepository<Provenienz,Long> {

}
