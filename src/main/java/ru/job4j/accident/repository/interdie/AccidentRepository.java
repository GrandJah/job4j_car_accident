package ru.job4j.accident.repository.interdie;

import ru.job4j.accident.model.Accident;

public interface AccidentRepository extends RepositoryInterface<Integer, Accident> {
  Accident save(Accident accident);
}
