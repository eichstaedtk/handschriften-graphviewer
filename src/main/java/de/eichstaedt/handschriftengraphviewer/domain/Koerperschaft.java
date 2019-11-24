package de.eichstaedt.handschriftengraphviewer.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
@Entity
public class Koerperschaft extends Beteiligte implements Serializable {

  protected Koerperschaft() {
  }

  public Koerperschaft(String id,String name, Ort ort) {
    this.id = id;
    this.name = name;
    Ort = ort;
  }

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Relationship("BEFINDET_SICH_IN")
  private Ort Ort;

  public Ort getOrt() {
    return Ort;
  }
}
