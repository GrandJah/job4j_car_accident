package ru.job4j.accident.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accident {

  private Integer id;

  private String name;

  private String text;

  private String address;

  private AccidentType type;
}
