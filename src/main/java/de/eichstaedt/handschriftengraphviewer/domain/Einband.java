package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.Id;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */
public class Einband {

  public Einband(String beschreibung, String befundJahr, String material) {
    this.beschreibung = beschreibung;
    this.befundJahr = befundJahr;
    this.material = material;
  }

  @Id
  private String beschreibung;

  private String befundJahr;

  private String material;

  public String getBeschreibung() {
    return beschreibung;
  }

  public String getBefundJahr() {
    return befundJahr;
  }

  public String getMaterial() {
    return material;
  }
}
