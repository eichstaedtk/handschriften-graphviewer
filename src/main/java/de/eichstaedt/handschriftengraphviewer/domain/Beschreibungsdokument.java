package de.eichstaedt.handschriftengraphviewer.domain;

import java.time.LocalDateTime;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

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


  public String getId() {
    return id;
  }

  public String getTitel() {
    return titel;
  }

  public String getSignatur() {
    return signatur;
  }
}
