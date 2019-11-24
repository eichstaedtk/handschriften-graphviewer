package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms;

import de.eichstaedt.handschriftengraphviewer.domain.Ort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-24.
 */
public interface OrtRDBMSRepository extends CrudRepository<Ort,String> {

}
