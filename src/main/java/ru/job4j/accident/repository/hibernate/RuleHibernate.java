package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleRepository;

@Repository
public class RuleHibernate implements RuleRepository {
  private final SessionFactory sf;

  public RuleHibernate(SessionFactory sf) {
    this.sf = sf;
  }

  @Override
  public Rule findById(Integer id) {
    try (Session session = sf.openSession()) {
      return session.createQuery("from Rule where id = :id", Rule.class).setParameter("id", id)
                    .getSingleResult();
    }
  }

  public List<Rule> findAll() {
    try (Session session = sf.openSession()) {
      return session.createQuery("from Rule", Rule.class).list();
    }
  }
}
