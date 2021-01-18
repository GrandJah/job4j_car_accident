package ru.job4j.accident.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "authorities")
public class Authority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String authority;
}
