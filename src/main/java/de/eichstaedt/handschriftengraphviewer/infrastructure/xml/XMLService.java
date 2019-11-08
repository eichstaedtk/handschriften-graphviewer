package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;


import java.lang.annotation.Documented;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@Service
public class XMLService {

  private static final Logger logger = LoggerFactory.getLogger(XMLService.class);

  public void loadingXMLData() {

    logger.info("Start loading data from xml file ...");



  }

}
