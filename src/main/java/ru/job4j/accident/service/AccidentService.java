package ru.job4j.accident.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;

@Service
public class AccidentService {
  private final AccidentMem accidentRepository;

  public AccidentService(AccidentMem accidentRepository) {
    this.accidentRepository = accidentRepository;
  }

  public Collection<Accident> findAllAccidents() {
    return this.accidentRepository.findAll();
  }

  public void createOrUpdate(Accident accident) {
    this.accidentRepository.save(accident);
  }

  public Accident findAccident(Integer id) {
    return this.accidentRepository.findById(id);
  }

  public List<AccidentType> accidentTypes() {
    return this.accidentRepository.getTypes();
  }
}
