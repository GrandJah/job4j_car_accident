package ru.job4j.accident.repository.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleRepository;

//@Repository
public class RuleRepositoryMem implements RuleRepository {
  private final Map<Integer, Rule> rules = new HashMap<>();

  {
    rules.put(1, Rule.of(1, "Статья. 1"));
    rules.put(2, Rule.of(2, "Статья. 2"));
    rules.put(3, Rule.of(3, "Статья. 3"));
  }

  @Override
  public Rule findById(Integer id) {
    return this.rules.get(id);
  }

  @Override
  public Collection<Rule> findAll() {
    return new ArrayList<>(this.rules.values());
  }
}
