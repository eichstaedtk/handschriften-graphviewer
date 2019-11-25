package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;

import com.rtfparserkit.converter.text.StringTextConverter;
import com.rtfparserkit.parser.RtfStreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by konrad.eichstaedt@sbb.spk-berlin.de on 12.09.2019.
 */
public class RTFConvert {

  public static String convertRTF(String freitext) throws IOException {

    StringTextConverter converter = new StringTextConverter();
    converter.convert(new RtfStreamSource(new ByteArrayInputStream(
        freitext.replaceAll("ansicpg0", "ansi").getBytes())));
    String extractedText = converter.getText();

    return extractedText;
  }

}
