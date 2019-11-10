package de.eichstaedt.handschriftengraphviewer.application.controller;

import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.ProvenienzRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-10.
 */

@Controller
public class ProvenienzController {

  @Autowired
  public ProvenienzController(
      ProvenienzRepository provenienzRepository) {
    this.provenienzRepository = provenienzRepository;
  }

  private static final Logger logger = LoggerFactory.getLogger(ProvenienzController.class);

  private ProvenienzRepository provenienzRepository;

  @GetMapping("/provenienzen")
  public ModelAndView getProvenienzenView() {

    logger.info("Trying to open the provienzenen view ... ");

    ModelAndView modelAndView = new ModelAndView();

    modelAndView.addObject("provenienzen",provenienzRepository.findAllProvenienz());

    modelAndView.setViewName("/provenienzen");

    return modelAndView;
  }


}
