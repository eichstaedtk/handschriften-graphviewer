package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.Id;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

public class DokumentElement {

  @Id
  private String id;

  private String name;

  private String beschreibungsText;

  public DokumentElement(String id, String name, String beschreibungsText) {
    this.id = id;
    this.name = name;
    this.beschreibungsText = beschreibungsText;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getBeschreibungsText() {
    return beschreibungsText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DokumentElement that = (DokumentElement) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "DokumentElement{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", beschreibungsText='" + beschreibungsText + '\'' +
        '}';
  }
}
