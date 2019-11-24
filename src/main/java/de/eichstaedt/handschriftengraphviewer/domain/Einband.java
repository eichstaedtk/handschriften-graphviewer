package de.eichstaedt.handschriftengraphviewer.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */

@NodeEntity
@Entity
@Table(name = "einband")
public class Einband {

  public Einband(String beschreibung, String befundJahr, String material) {
    this.beschreibung = beschreibung;
    this.befundJahr = befundJahr;
    this.material = material;
  }

  @javax.persistence.Id
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
