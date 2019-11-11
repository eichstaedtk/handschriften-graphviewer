package de.eichstaedt.handschriftengraphviewer.domain;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-11.
 */
public class Buchbinder extends Beteiligte {

  public Buchbinder(String id,String name,String ort,Einband einband) {
    this.id = id;
    this.name = name;
    this.ort = ort;
    this.einband = einband;
  }

  private String name;

  private String ort;

  private Einband einband;

  public String getName() {
    return name;
  }

  public Einband getEinband() {
    return einband;
  }

  public String getOrt() {
    return ort;
  }
}
