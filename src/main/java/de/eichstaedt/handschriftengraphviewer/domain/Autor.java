package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

@NodeEntity
public class Autor extends Beteiligte {

  public Autor(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
