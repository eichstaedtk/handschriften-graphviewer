package de.eichstaedt.handschriftengraphviewer.domain;

import java.time.LocalDateTime;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@NodeEntity
public class Beschreibungsdokument {

  public Beschreibungsdokument(String id,
      KulturObjektDokument kod, LocalDateTime beschreibungsDatum) {
    this.id = id;
    this.kod = kod;
    this.beschreibungsDatum = beschreibungsDatum;
  }

  @Id
  private String id;

  private KulturObjektDokument kod;

  private LocalDateTime beschreibungsDatum;

  public String getId() {
    return id;
  }

  public KulturObjektDokument getKod() {
    return kod;
  }

  public LocalDateTime getBeschreibungsDatum() {
    return beschreibungsDatum;
  }

  @Override
  public String toString() {
    return "Beschreibungsdokument{" +
        "id='" + id + '\'' +
        ", kod=" + kod +
        ", beschreibungsDatum=" + beschreibungsDatum +
        '}';
  }
}
