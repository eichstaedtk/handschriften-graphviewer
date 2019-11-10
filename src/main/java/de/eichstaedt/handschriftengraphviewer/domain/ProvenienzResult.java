package de.eichstaedt.handschriftengraphviewer.domain;

import java.util.Objects;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-09.
 */

@QueryResult
public class ProvenienzResult {

  Beteiligte beteiligte;

  Provenienz provenienz;

  Beschreibungsdokument beschreibungsdokument;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvenienzResult that = (ProvenienzResult) o;
    return Objects.equals(beteiligte, that.beteiligte) &&
        Objects.equals(provenienz, that.provenienz) &&
        Objects.equals(beschreibungsdokument, that.beschreibungsdokument);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beteiligte, provenienz, beschreibungsdokument);
  }

  public Beteiligte getBeteiligte() {
    return beteiligte;
  }

  public void setBeteiligte(Beteiligte beteiligte) {
    this.beteiligte = beteiligte;
  }

  public Provenienz getProvenienz() {
    return provenienz;
  }

  public void setProvenienz(Provenienz provenienz) {
    this.provenienz = provenienz;
  }

  public Beschreibungsdokument getBeschreibungsdokument() {
    return beschreibungsdokument;
  }

  public void setBeschreibungsdokument(
      Beschreibungsdokument beschreibungsdokument) {
    this.beschreibungsdokument = beschreibungsdokument;
  }
}
