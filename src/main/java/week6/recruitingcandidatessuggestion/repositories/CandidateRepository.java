package week6.recruitingcandidatessuggestion.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import week6.recruitingcandidatessuggestion.entities.Candidate;
import week6.recruitingcandidatessuggestion.repositories.mappers.CandidateMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CandidateRepository {
    private final Logger logger = Logger.getLogger(CandidateRepository.class.getName());
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Candidate> getAllCandidates() {
        String sql = "SELECT * FROM candidates";
        return jdbcTemplate.query(sql, new CandidateMapper());
    }

    public boolean createCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidates (last_name, middle_name, first_name, dob, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String fullName = candidate.getFullName();
        String[] names = fullName.split(" ");
        switch (names.length) {
            case 1:
                jdbcTemplate.update(sql, names[0], "", "", candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
                break;
            case 2:
                jdbcTemplate.update(sql, names[0], "", names[1], candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
                break;
            case 3:
                jdbcTemplate.update(sql, names[0], names[1], names[2], candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
                break;
            case 4:
                jdbcTemplate.update(sql, names[0], names[1], names[2] + " " + names[3], candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
                break;
            case 5:
                jdbcTemplate.update(sql, names[0], names[1], names[2] + " " + names[3] + " " + names[4], candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
                break;
            default:
                return false;
        }

        return true;
    }


}
