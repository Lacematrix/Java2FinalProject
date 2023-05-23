package com.example.stackoverflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({"/", "/demo"})
  public String homepage() {
    return "homepage";
  }

  @GetMapping({"/ShowAPI"})
  public String showAPI() {
    return "showAPI";
  }

}
