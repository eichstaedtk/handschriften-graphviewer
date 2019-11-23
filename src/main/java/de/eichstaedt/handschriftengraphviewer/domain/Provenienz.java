package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
@RelationshipEntity()
public class Provenienz {

  public Provenienz(String id,ProvenienzTyp typ,
      Beteiligte beteiligte, String vonJahr, String bisJahr, Beschreibungsdokument beschreibungsdokument) {
    this.id = id;
    this.typ = typ;
    this.beteiligte = beteiligte;
    this.vonJahr = vonJahr;
    this.bisJahr = bisJahr;
    this.beschreibungsdokument = beschreibungsdokument;
  }

  @Id
  private String id;

  private ProvenienzTyp typ;

  @EndNode
  private Beteiligte beteiligte;

  private String vonJahr;

  private String bisJahr;

  @StartNode
  private Beschreibungsdokument beschreibungsdokument;

  public String getId() {
    return id;
  }

  public ProvenienzTyp getTyp() {
    return typ;
  }

  public Beteiligte getBeteiligte() {
    return beteiligte;
  }

  public String getVonJahr() {
    return vonJahr;
  }

  public String getBisJahr() {
    return bisJahr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Provenienz that = (Provenienz) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Provenienz{" +
        "id=" + id +
        ", typ=" + typ +
        ", beteiligte=" + beteiligte +
        ", vonJahr='" + vonJahr + '\'' +
        ", bisJahr='" + bisJahr + '\'' +
        '}';
  }
}
