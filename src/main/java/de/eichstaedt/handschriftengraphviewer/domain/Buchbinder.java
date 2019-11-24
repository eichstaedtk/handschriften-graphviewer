package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */

public class Buchbinder extends Beteiligte {

  public Buchbinder(String id,String name,Ort ort) {
    this.id = id;
    this.name = name;
    this.ort = ort;
  }

  private String name;

  @Relationship("BEFINDET_SICH_IN")
  private Ort ort;

  public String getName() {
    return name;
  }

  public Ort getOrt() {
    return ort;
  }
}
