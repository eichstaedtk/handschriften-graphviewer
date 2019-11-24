package de.eichstaedt.handschriftengraphviewer.domain;

import javax.persistence.Entity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

@NodeEntity
@Entity
public class Autor extends Beteiligte {

  protected Autor() {
  }

  public Autor(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
