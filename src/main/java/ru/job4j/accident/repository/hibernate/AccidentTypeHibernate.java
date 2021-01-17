package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeRepository;

@Repository
public class AccidentTypeHibernate implements AccidentTypeRepository {
  private final SessionFactory sf;

  public AccidentTypeHibernate(SessionFactory sf) {
    this.sf = sf;
  }

  @Override
  public AccidentType findById(Integer id) {
    try (Session session = sf.openSession()) {
      return session.createQuery("from AccidentType where id = :id", AccidentType.class)
                    .setParameter("id", id).getSingleResult();
    }
  }

  public List<AccidentType> findAll() {
    try (Session session = sf.openSession()) {
      return session.createQuery("from AccidentType", AccidentType.class).list();
    }
  }
}
