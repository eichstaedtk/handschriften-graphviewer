package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@Entity
@Table(name = "beschreibungen")
@NodeEntity
public class Beschreibungsdokument {

  protected Beschreibungsdokument() {
  }

  public Beschreibungsdokument(String id, String titel, String signatur) {
    this.id = id;
    this.titel = titel;
    this.signatur = signatur;
    this.bestandteile = new HashSet<>();
    this.orte = new HashSet<>();
  }

  @javax.persistence.Id
  @Id
  private String id;

  @Column(length = 4096)
  private String titel;

  private String signatur;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Ort> orte;

  @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
  @Relationship(type = "BUCHBINDER")
  private Beteiligte buchbinder;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
  @Relationship(type = "ENTHAELT")
  private Set<DokumentElement> bestandteile;

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

  public Set<DokumentElement> getBestandteile() {
    return bestandteile;
  }

  public Set<Ort> getOrte() {
    return orte;
  }

  public void setBestandteile(
      Set<DokumentElement> bestandteile) {
    this.bestandteile = bestandteile;
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

