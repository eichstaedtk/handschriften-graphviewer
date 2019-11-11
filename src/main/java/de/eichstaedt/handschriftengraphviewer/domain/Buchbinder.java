package de.eichstaedt.handschriftengraphviewer.domain;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */
public class Buchbinder extends Beteiligte {

  public Buchbinder(String id,String name,String ort) {
    this.id = id;
    this.name = name;
    this.ort = ort;
  }

  private String name;

  private String ort;

  public String getName() {
    return name;
  }

  public String getOrt() {
    return ort;
  }
}
