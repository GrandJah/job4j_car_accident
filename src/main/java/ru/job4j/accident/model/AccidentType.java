package ru.job4j.accident.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class AccidentType {
  private Integer id;

  private String name;

  public static AccidentType of(int id, String name) {
    AccidentType type = new AccidentType();
    type.id = id;
    type.name = name;
    return type;
  }
}
