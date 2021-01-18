package ru.job4j.accident.service;

import org.springframework.stereotype.Service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.data.AccidentRepository;
import ru.job4j.accident.repository.data.AccidentTypeRepository;
import ru.job4j.accident.repository.data.RuleRepository;

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

  public Iterable<Accident> findAllAccidents() {
    return this.accidentRepository.findByOrderByIdDesc();
  }

  public void createOrUpdate(Accident accident) {
    this.accidentRepository.save(accident);
  }

  public Accident findAccident(Integer id) {
    return this.accidentRepository.findById(id).orElse(null);
  }

  public AccidentType findType(Integer id) {
    return this.accidentTypeRepository.findById(id).orElse(null);
  }

  public Iterable<AccidentType> accidentTypes() {
    return this.accidentTypeRepository.findAll();
  }

  public Rule findRule(Integer id) {
    return this.ruleRepository.findById(id).orElse(null);
  }

  public Iterable<Rule> accidentRules() {
    return this.ruleRepository.findAll();
  }
}
