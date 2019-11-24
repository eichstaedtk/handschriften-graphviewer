package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.graph;

import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

public interface ProvenienzGraphRepository extends Neo4jRepository<Provenienz,String> {

}
