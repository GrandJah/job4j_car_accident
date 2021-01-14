package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class IndexControl {
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("list", randList(30));
    return "index";
  }

  private List<String> randList(int max) {
    return IntStream.range(0, max).filter((i) -> 0.3 <= Math.random())
                    .mapToObj(i -> "generate row with random data i=" + i)
                    .collect(Collectors.toList());
  }
}
