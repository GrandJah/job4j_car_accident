package ru.job4j.accident.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

@Service
public class AccidentService {
  private final AccidentRepository accidentRepository;
  private final AccidentTypeRepository accidentTypeRepository;
  private final RuleRepository ruleRepository;

  public AccidentService(AccidentRepository accidentRepository,
    AccidentTypeRepository accidentTypeRepository, RuleRepository ruleRepository) {
    this.accidentRepository = accidentRepository;
    this.accidentTypeRepository = accidentTypeRepository;
    this.ruleRepository = ruleRepository;
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

  public Collection<AccidentType> accidentTypes() {
    return this.accidentTypeRepository.findAll();
  }

  public Rule findRules(Integer id) {
    return this.ruleRepository.findById(id);
  }

  public Collection<Rule> accidentRules() {
    return this.ruleRepository.findAll();
  }
}
