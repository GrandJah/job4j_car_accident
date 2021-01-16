package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
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
    model.addAttribute("rules", this.accidentService.accidentRules());
    return "accident/create";
  }

  @GetMapping("/edit")
  public String edit(Model model, @RequestParam Integer id) {
    model.addAttribute("accident", this.accidentService.findAccident(id));
    model.addAttribute("types", this.accidentService.accidentTypes());
    model.addAttribute("rules", this.accidentService.accidentRules());
    return "accident/edit";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute Accident accident,
    @RequestParam(value = "rIds", required = false) List<Integer> ids) {
    if (ids != null) {
      accident
        .setRules(ids.stream().map(this.accidentService::findRules).collect(Collectors.toSet()));
    }
    this.accidentService.createOrUpdate(accident);
    return "redirect:/";
  }
}
