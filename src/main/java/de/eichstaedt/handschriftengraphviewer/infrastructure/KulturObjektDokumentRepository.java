package de.eichstaedt.handschriftengraphviewer.infrastructure;

import de.eichstaedt.handschriftengraphviewer.domain.KulturObjektDokument;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public interface KulturObjektDokumentRepository extends Neo4jRepository<KulturObjektDokument, String> {

}
