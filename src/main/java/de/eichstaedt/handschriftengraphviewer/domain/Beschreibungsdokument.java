package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class Beschreibungsdokument {

  public Beschreibungsdokument(String id, String titel, String signatur) {
    this.id = id;
    this.titel = titel;
    this.signatur = signatur;
  }

  @Id
  private String id;

  private String titel;

  private String signatur;


  public String getId() {
    return id;
  }

  public String getTitel() {
    return titel;
  }

  public String getSignatur() {
    return signatur;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Beschreibungsdokument that = (Beschreibungsdokument) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
