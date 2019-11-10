package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.Id;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public abstract class Beteiligte {

  @Id
  String id;

  String gndid;

  String bemerkung;

  public String getId() {
    return id;
  }

  public String getGndid() {
    return gndid;
  }

  public String getBemerkung() {
    return bemerkung;
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
}
