package de.eichstaedt.handschriftengraphviewer.infrastructure.repository.rdbms;

import de.eichstaedt.handschriftengraphviewer.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-24.
 */
public interface PersonRDBMSRepository extends CrudRepository<Person,String> {

}
