package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public class AbstractHIDAXPATHValues {

  public static final String BESCHREIBUNGEN = "//DocumentSet/Document";

  public static final String BESCHREIBUNGS_ID = "//Document/@DocKey";

  public static final String BESCHREIBUNGS_TITEL = "//Field[@Type='5209']/@Value";

  public static final String BESCHREIBUNGS_SIGNATURE = "//Block[@Type=\"obj\"]/Field[@Type='bezsoz' and @Value='Verwaltung']/Field[@Type='4650']/@Value";

  public static final String BESCHREIBUNGS_BESITZER_SEIT = "//Block[@Type=\"obj\"]/Field[@Type='bezsoz' and @Value='Verwaltung']/Field[@Type='4996']/@Value";

}
