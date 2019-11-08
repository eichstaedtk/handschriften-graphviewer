package de.eichstaedt.handschriftengraphviewer.domain;

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
}
