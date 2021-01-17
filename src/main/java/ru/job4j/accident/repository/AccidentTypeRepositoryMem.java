package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.job4j.accident.model.AccidentType;

@Repository
public class AccidentTypeRepositoryMem implements AccidentTypeRepository {

  private final Map<Integer, AccidentType> types = new HashMap<>();
  {
    types.put(1, AccidentType.of(1, "Две машины"));
    types.put(2, AccidentType.of(2, "Машина и человек"));
    types.put(3, AccidentType.of(3, "Машина и велосипед"));
  }

  @Override
  public AccidentType findById(Integer id) {
    return this.types.get(id);
  }

  @Override
  public List<AccidentType> findAll() {
    return new ArrayList<>(this.types.values());
  }
}
