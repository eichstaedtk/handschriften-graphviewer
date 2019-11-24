package de.eichstaedt.handschriftengraphviewer.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */

@Entity
public class Buchbinder extends Beteiligte implements Serializable {

  protected Buchbinder() {
  }

  public Buchbinder(String id,String name,Ort ort) {
    this.id = id;
    this.name = name;
    this.ort = ort;
  }

  @Column(insertable = false,updatable = false)
  private String name;

  @OneToOne(fetch = FetchType.EAGER)
  @Relationship("BEFINDET_SICH_IN")
  private Ort ort;

  public String getName() {
    return name;
  }

  public Ort getOrt() {
    return ort;
  }
}
