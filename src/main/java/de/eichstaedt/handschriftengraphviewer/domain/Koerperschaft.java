package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class Koerperschaft extends Beteiligte {

  public Koerperschaft(String id,String name, String ort) {
    this.id = id;
    this.name = name;
    Ort = ort;
  }

  private String name;

  private String Ort;

  public String getName() {
    return name;
  }

  public String getOrt() {
    return Ort;
  }
}
