package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import ru.job4j.accident.model.Accident;

@Repository
public class AccidentMem {
  private final Map<Integer, Accident> accidents = new HashMap<>();

  public Collection<Accident> findAll() {
    return this.accidents.values();
  }

  public void save(Accident accident) {
    Integer id = accident.getId();
    if (id == null) {
      id = this.accidents.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
      accident.setId(id);
    }
    this.accidents.put(id, accident);
  }

  public Accident findById(Integer id) {
    return this.accidents.get(id);
  }
}
