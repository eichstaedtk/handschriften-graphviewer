package de.eichstaedt.handschriftengraphviewer.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@RelationshipEntity(type = "PROVENIENZ")
public class Provenienz {

  public Provenienz(ProvenienzTyp typ,
      Beteiligte beteiligte, Beschreibungsdokument beschreibungsdokument, String vonJahr, String bisJahr) {
    this.typ = typ;
    this.beteiligte = beteiligte;
    this.beschreibungsdokument = beschreibungsdokument;
    this.vonJahr = vonJahr;
    this.bisJahr = bisJahr;
  }

  @Id
  @GeneratedValue
  private Long id;

  private ProvenienzTyp typ;

  @StartNode
  private Beteiligte beteiligte;

  @EndNode
  private Beschreibungsdokument beschreibungsdokument;

  private String vonJahr;

  private String bisJahr;

  public Long getId() {
    return id;
  }

  public ProvenienzTyp getTyp() {
    return typ;
  }

  public Beteiligte getBeteiligte() {
    return beteiligte;
  }

  public Beschreibungsdokument getBeschreibungsdokument() {
    return beschreibungsdokument;
  }

  public String getVonJahr() {
    return vonJahr;
  }

  public String getBisJahr() {
    return bisJahr;
  }
}
