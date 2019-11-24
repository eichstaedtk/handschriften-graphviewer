package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

@NodeEntity
@Entity
@Table(name = "elemente")
public class DokumentElement {

  protected DokumentElement() {
  }

  @javax.persistence.Id
  @Id
  private String id;

  private String name;

  @Lob
  private String beschreibungsText;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Relationship(type = "ENTHAELT")
  private Set<DokumentElement> bestandteile;

  @ManyToMany(fetch = FetchType.EAGER)
  @Relationship(type = "DIGITAL")
  private Set<Digitalisat> digitalisate;

  @ManyToMany(fetch = FetchType.EAGER)
  @Relationship(type = "AUTOR")
  private Set<Person> autoren;

  public DokumentElement(String id, String name, String beschreibungsText) {
    this.id = id;
    this.name = name;
    this.beschreibungsText = beschreibungsText;
    this.bestandteile = new HashSet<>();
    this.digitalisate = new HashSet<>();
    this.autoren = new HashSet<>();
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

  public Set<DokumentElement> getBestandteile() {
    return bestandteile;
  }

  public Set<Digitalisat> getDigitalisate() {
    return digitalisate;
  }

  public Set<Person> getAutoren() {
    return autoren;
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
        ", bestandteile=" + bestandteile +
        ", digitalisate=" + digitalisate +
        ", autoren=" + autoren +
        '}';
  }
}
