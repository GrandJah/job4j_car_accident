package ru.job4j.accident.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.interdie.AccidentRepository;

//@Repository
public class AccidentJdbcTemplate implements AccidentRepository {
  private final JdbcTemplate jdbc;

  private RowMapper<Accident> accidentRowMapper = (rs, rowNum) -> Accident.builder()
                                                                          .id(rs.getInt("id")).name(
      rs.getString("name")).address(rs.getString("address")).text(rs.getString("text")).build();

  public AccidentJdbcTemplate(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Accident save(Accident accident) {
    if (accident.getId() != null) {
      jdbc.update("update accident set name = ?, address = ?, text = ? where id = ?",
        accident.getName(), accident.getAddress(), accident.getText(), accident.getId());
    } else {
      jdbc.update("insert into accident (name,address,text) values (?,?,?)", accident.getName(),
        accident.getAddress(), accident.getText());
    }
    return accident;
  }

  @Override
  public Accident findById(Integer id) {
    return jdbc.queryForObject("select * from accident where id = ?", accidentRowMapper, id);
  }

  @Override
  public Collection<Accident> findAll() {
    return jdbc.query("select * from accident", accidentRowMapper);
  }
}
