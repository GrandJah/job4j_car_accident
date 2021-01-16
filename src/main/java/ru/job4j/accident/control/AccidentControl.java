package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller
public class AccidentControl {
  private final AccidentService accidentService;

  public AccidentControl(AccidentService accidentService) {
    this.accidentService = accidentService;
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("types", this.accidentService.accidentTypes());
    return "accident/create";
  }

  @GetMapping("/edit")
  public String edit(Model model, @RequestParam Integer id) {
    model.addAttribute("accident", this.accidentService.findAccident(id));
    model.addAttribute("types", this.accidentService.accidentTypes());
    return "accident/edit";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute Accident accident) {
    this.accidentService.createOrUpdate(accident);
    return "redirect:/";
  }
}
