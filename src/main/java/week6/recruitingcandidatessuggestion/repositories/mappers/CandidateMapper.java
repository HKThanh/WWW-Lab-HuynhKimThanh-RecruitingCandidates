package week6.recruitingcandidatessuggestion.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import week6.recruitingcandidatessuggestion.entities.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateMapper implements RowMapper<Candidate> {

    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(rs.getInt("id"));
        candidate.setFullName(rs.getString("last_name") + " " + rs.getString("middle_name") + " " + rs.getString("first_name"));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setAddress(rs.getString("address"));
        candidate.setPhone(rs.getString("phone"));
        return candidate;
    }
}
