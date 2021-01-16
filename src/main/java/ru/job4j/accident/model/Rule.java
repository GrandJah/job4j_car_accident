package ru.job4j.accident.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Rule {

  private int id;
  private String name;

  public static Rule of(int id, String name) {
    Rule rule = new Rule();
    rule.id = id;
    rule.name = name;
    return rule;
  }
}
