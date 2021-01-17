package ru.job4j.accident.repository.memory;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

//@Repository
public class AccidentMem implements AccidentRepository {
  private final Map<Integer, Accident> accidents = new HashMap<>();

  @Override
  public Collection<Accident> findAll() {
    return this.accidents.values();
  }

  @Override
  public Accident save(Accident accident) {
    Integer id = accident.getId();
    if (id == null) {
      id = this.accidents.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
      accident.setId(id);
    }
    this.accidents.put(id, accident);
    return accident;
  }

  @Override
  public Accident findById(Integer id) {
    return this.accidents.get(id);
  }
}
