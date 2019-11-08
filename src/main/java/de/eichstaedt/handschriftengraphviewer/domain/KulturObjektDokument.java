package de.eichstaedt.handschriftengraphviewer.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class KulturObjektDokument implements Serializable {

  public KulturObjektDokument(String id, LocalDateTime generierungsDatum) {
    this.id = id;
    this.generierungsDatum = generierungsDatum;
    this.beschreibungen = new HashSet<>();
  }

  @Id
  private String id;

  private LocalDateTime generierungsDatum;

  @Relationship(type = "BESCHREIBUNGEN_VON", direction = Relationship.UNDIRECTED)
  private Set<Beschreibungsdokument> beschreibungen;

  public String getId() {
    return id;
  }

  public LocalDateTime getGenerierungsDatum() {
    return generierungsDatum;
  }

  public Set<Beschreibungsdokument> getBeschreibungen() {
    return beschreibungen;
  }

  @Override
  public String toString() {
    return "KulturObjektDokument{" +
        "id='" + id + '\'' +
        ", generierungsDatum=" + generierungsDatum +
        ", beschreibungen=" + beschreibungen +
        '}';
  }
}
