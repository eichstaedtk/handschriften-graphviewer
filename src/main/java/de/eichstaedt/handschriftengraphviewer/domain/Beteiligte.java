package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.neo4j.ogm.annotation.Id;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@Entity
@Table(name = "beteiligte")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Beteiligte {


  @Id
  String id;

  String gndid;

  String bemerkung;

  @javax.persistence.Id
  String name = UUID.randomUUID().toString();

  public String getId() {
    return id;
  }

  public String getGndid() {
    return gndid;
  }

  public String getBemerkung() {
    return bemerkung;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Beteiligte that = (Beteiligte) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Beteiligte{" +
        "id='" + id + '\'' +
        ", gndid='" + gndid + '\'' +
        ", bemerkung='" + bemerkung + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
