package de.eichstaedt.handschriftengraphviewer.domain;

import javax.persistence.Entity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@Entity
@NodeEntity
public class Person extends Beteiligte {

  protected Person() {
  }

  public Person(String id,String name) {
    this.id = id;
    this.name = name;
  }
}
