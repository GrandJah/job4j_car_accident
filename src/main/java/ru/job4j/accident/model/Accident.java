package ru.job4j.accident.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(exclude = "id")
public class Accident {

  private int id;

  private String name;

  private String text;

  private String address;
}
