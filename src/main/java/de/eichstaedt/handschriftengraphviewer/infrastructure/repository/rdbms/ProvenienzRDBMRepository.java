package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms;

import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-24.
 */
public interface ProvenienzRDBMRepository extends CrudRepository<Provenienz,String> {

}
