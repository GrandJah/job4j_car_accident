package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ru.job4j.accident.model.Accident;

@Repository
public class AccidentMem {
  private final Map<Integer, Accident> accidents = new HashMap<>();


  public AccidentMem() {
    this.accidents.putAll(IntStream.range(0, 30).filter((i) -> 0.3 <= Math.random()).boxed()
                                   .collect(Collectors.toMap(i -> i,
                                     i -> Accident.builder().name("unknown")
                                                  .text("generate row with random data i=" + i)
                                                  .address("").build())));
  }

  public Collection<Accident> findAll() {
    return this.accidents.values();
  }
}
