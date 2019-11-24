package de.eichstaedt.handschriftengraphviewer.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

@NodeEntity
@Entity
public class Ort extends Beteiligte implements Serializable {

  protected Ort() {
  }

  public Ort(String name) {
    if(name == null || name.isEmpty())
    {
      this.id = "KEINE ANGABE";
    }else {
      this.id = name;
    }

    this.name = this.id;
  }
}
