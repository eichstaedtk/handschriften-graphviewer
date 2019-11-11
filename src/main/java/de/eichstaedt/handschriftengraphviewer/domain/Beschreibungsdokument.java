package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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

  @Relationship(type = "BUCHBINDER")
  private Beteiligte buchbinder;

  @Relationship(type = "EINBAND")
  private Einband einband;

  public String getId() {
    return id;
  }

  public String getTitel() {
    return titel;
  }

  public String getSignatur() {
    return signatur;
  }

  public Beteiligte getBuchbinder() {
    return buchbinder;
  }

  public void setBuchbinder(Beteiligte buchbinder) {
    this.buchbinder = buchbinder;
  }

  public Einband getEinband() {
    return einband;
  }

  public void setEinband(Einband einband) {
    this.einband = einband;
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
