package ru.job4j.accident.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import ru.job4j.accident.model.Accident;
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
}
