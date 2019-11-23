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

  public static final String BESCHREIBUNGS_PERSON_ID = "//Field[@Type='z001' or @Type='4000']/@Value";

  public static final String BESCHREIBUNGS_PERSON_NAME = "//Field[@Type='4100']/@Value";

  public static final String BESCHREIBUNGS_KOEPERSCHAFTS_ID = "//Field[@Type='4500']/@Value";

  public static final String BESCHREIBUNGS_KOERPERSCHAFTS_NAME = "//Field[@Type='4600']/@Value";

  public static final String BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR = "//Field[@Type='4996']/@Value";

  public static final String BESCHREIBUNGS_KOERPERSCHAFTS_ORT = "//Field[@Type='4564']/@Value";

  public static final String BESCHREIBUNGS_PROVENIENZ_HERSTELLUNG = "//Block[@Type=\"obj\"]/Field[@Type='bezper' and @Value='Herstellung']";

  public static final String BESCHREIBUNGS_BUCHBINDER_HERSTELLUNG = "//Block[@Type=\"t2\"]/Field[@Type='bezsoz' and @Value='Herstellung']";

  public static final String BESCHREIBUNGS_BESTANDTEILE_LEVEL2 = "//Block[@Type=\"obj\"]/Block[@Type=\"t2\"]";

  public static final String BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL2 = "//Block[@Type=\"t2\"]/Field[@Type='5001']/@Value";

  public static final String BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL2 = "//Block[@Type=\"t2\"]/Field[@Type='5230']/@Value";

  public static final String BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL2 = "//Block[@Type=\"t2\"]/Field[@Type='par09']/@Value";

  public static final String BESCHREIBUNGS_BESTANDTEILE_LEVEL3 = "//Block[@Type=\"t2\"]/Block[@Type=\"t3\"]";

  public static final String BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL3 = "//Block[@Type=\"t3\"]/Field[@Type='5230']/@Value";

  public static final String BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL3 = "//Block[@Type=\"t3\"]/Field[@Type='5002']/@Value";

  public static final String BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL3 = "//Block[@Type=\"t3\"]/Field[@Type='par08']/@Value";

  public static final String DIGITALISATE = "//Field[@Type='8450' and @Value='digitale Reproduktion']";

  public static final String DIGITALISAT_NAME = "//Field[@Type='8450' and @Value='digitale Reproduktion']/Field[@Type='8540']/@Value";

  public static final String AUTORENSCHAFTEN = "//Field[@Type='bezper' and @Value='Autorschaft']";

  public static final String AUTORENSCHAFTEN_NAME = "//Field[@Type='4100']/@Value";

  public static final String AUTORENSCHAFTEN_ID = "//Field[@Type='z001']/@Value";

  public static final String BESCHREIBUNGS_EINBAND = "//Block[@Type=\"t2\"]/Field[@Type='5230' and @Value='Einband']";

  public static final String BESCHREIBUNGS_EINBAND_BESCHREIBUNG = "//Block[@Type=\"t2\"]/Field[@Type='5240']/@Value";

  public static final String BESCHREIBUNGS_EINBAND_JAHR = "//Block[@Type=\"t2\"]/Field[@Type='5060' and @Value='Materialbefund']/Field[@Type='5064']/@Value";

  public static final String BESCHREIBUNGS_EINBAND_MATERIAL_NAME = "//Block[@Type=\"t2\"]/Field[@Type='5260']/@Value";


}
