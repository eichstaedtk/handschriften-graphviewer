package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class Koerperschaft extends Beteiligte {

  public Koerperschaft(String id,String name, Ort ort) {
    this.id = id;
    this.name = name;
    Ort = ort;
  }

  @Relationship("BEFINDET_SICH_IN")
  private Ort Ort;

  public Ort getOrt() {
    return Ort;
  }
}
