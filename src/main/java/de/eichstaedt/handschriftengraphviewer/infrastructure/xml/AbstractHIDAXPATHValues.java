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

  public static final String BESCHREIBUNGS_VORBESITZER = "//Block[@Type=\"obj\"]/Field[@Type='bezsoz' or @Type='bezper' and @Value='Vorbesitz']";

  public static final String BESCHREIBUNGS_VORBESITZER_PERSON_ID = "//Field[@Type='z001']/@Value";

  public static final String BESCHREIBUNGS_VORBESITZER_PERSON_NAME = "//Field[@Type='4100']/@Value";

  public static final String BESCHREIBUNGS_VORBESITZER_KOEPERSCHAFTS_ID = "//Field[@Type='4500']/@Value";

  public static final String BESCHREIBUNGS_VORBESITZER_KOERPERSCHAFTS_NAME = "//Field[@Type='4600']/@Value";

  public static final String BESCHREIBUNGS_VORBESITZER_KOERPERSCHAFTS_VON_JAHR = "//Field[@Type='4996']/@Value";

  public static final String BESCHREIBUNGS_VORBESITZER_KOERPERSCHAFTS_ORT = "//Field[@Type='4564']/@Value";

}
