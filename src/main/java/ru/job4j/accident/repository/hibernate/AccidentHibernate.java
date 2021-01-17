package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

@Repository
@Slf4j
public class AccidentHibernate implements AccidentRepository {
  private final SessionFactory sf;

  public AccidentHibernate(SessionFactory sf) {
    this.sf = sf;
  }

  public Accident save(Accident accident) {
    try (Session session = sf.openSession()) {
      Transaction tx = session.beginTransaction();
      try {
        if (accident.getId() != null) {
          session.update(accident);
        } else {
          session.save(accident);
        }
        tx.commit();
      } catch (Exception e) {
        tx.rollback();
        log.debug(e.getMessage());
      }
      return accident;
    }
  }

  @Override
  public Accident findById(Integer id) {
    try (Session session = sf.openSession()) {
      return session.createQuery("from Accident where id = :id", Accident.class)
                    .setParameter("id", id).getSingleResult();
    }
  }

  public List<Accident> findAll() {
    try (Session session = sf.openSession()) {
      return session.createQuery("from Accident", Accident.class).list();
    }
  }
}
