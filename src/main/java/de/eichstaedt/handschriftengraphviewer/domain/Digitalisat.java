package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-23.
 */

@NodeEntity
public class Digitalisat {

  private String id;

  private String name;

  @Id
  private String thumbnailURl;

  public Digitalisat(String id, String name, String thumbnailURl) {
    this.id = id;
    this.name = name;
    this.thumbnailURl = thumbnailURl;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getThumbnailURl() {
    return thumbnailURl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Digitalisat that = (Digitalisat) o;
    return Objects.equals(thumbnailURl, that.thumbnailURl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thumbnailURl);
  }

  @Override
  public String toString() {
    return "Digitalisat{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", thumbnailURl='" + thumbnailURl + '\'' +
        '}';
  }
}
