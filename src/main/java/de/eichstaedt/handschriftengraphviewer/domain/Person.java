package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class Person extends Beteiligte {

  public Person(String id, String vorname, String nachname) {
    this.id = id;
    this.vorname = vorname;
    this.nachname = nachname;
  }


  private String vorname;

  private String nachname;

  public String getVorname() {
    return vorname;
  }

  public String getNachname() {
    return nachname;
  }
}
