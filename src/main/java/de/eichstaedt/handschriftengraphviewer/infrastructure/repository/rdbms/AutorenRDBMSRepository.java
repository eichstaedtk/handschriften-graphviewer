package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms;

import de.eichstaedt.handschriftengraphviewer.domain.Autor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-24.
 */
public interface AutorenRDBMSRepository extends CrudRepository<Autor,String> {

}
