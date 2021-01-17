package ru.job4j.accident.repository;

import java.util.Collection;

public interface RepositoryInterface<I,T> {
  T findById(I id);

  Collection<T> findAll();
}
