package week6.recruitingcandidatessuggestion.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import week6.recruitingcandidatessuggestion.entities.Job;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Job> getAllJobs() {
        String sql = "SELECT * FROM jobs";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Job.class));
    }

    public boolean createJob(String description) {
        String sql = "INSERT INTO jobs (description) VALUES (?)";
        return jdbcTemplate.update(sql, description) > 0;
    }
}
