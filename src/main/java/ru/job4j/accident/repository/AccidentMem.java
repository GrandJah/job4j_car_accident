package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

@Repository
public class AccidentMem {
  private final Map<Integer, Accident> accidents = new HashMap<>();

  private final Map<Integer, AccidentType> types = new HashMap<>();

  private final Map<Integer, Rule> rules = new HashMap<>();

  {
    types.put(1, AccidentType.of(1, "Две машины"));
    types.put(2, AccidentType.of(2, "Машина и человек"));
    types.put(3, AccidentType.of(3, "Машина и велосипед"));

    rules.put(1, Rule.of(1, "Статья. 1"));
    rules.put(2, Rule.of(2, "Статья. 2"));
    rules.put(3, Rule.of(3, "Статья. 3"));
  }

  public Collection<Accident> findAll() {
    return this.accidents.values();
  }

  public void save(Accident accident) {
    Integer id = accident.getId();
    if (id == null) {
      id = this.accidents.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
      accident.setId(id);
    }
    accident.setType(types.get(accident.getType().getId()));
    this.accidents.put(id, accident);
  }

  public Accident findById(Integer id) {
    return this.accidents.get(id);
  }

  public List<AccidentType> getTypes() {
    return new ArrayList<>(this.types.values());
  }

  public Rule findRuleById(Integer id) {
    return this.rules.get(id);
  }

  public List<Rule> getRules() {
    return new ArrayList<>(this.rules.values());
  }
}
