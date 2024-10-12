package week6.recruitingcandidatessuggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import week6.recruitingcandidatessuggestion.entities.Candidate;
import week6.recruitingcandidatessuggestion.entities.Job;
import week6.recruitingcandidatessuggestion.repositories.CandidateRepository;
import week6.recruitingcandidatessuggestion.repositories.JobRepository;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class RecruitingCandidatesSuggestionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RecruitingCandidatesSuggestionApplication.class, args);
    }

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private JobRepository jobRepository;

    @Override
    public void run(String... args) throws Exception {
//        Candidate candidate = new Candidate();
//        candidate.setFullName("John Doe");
//        candidate.setDob(java.time.LocalDate.of(1990, 1, 1));
//        candidate.setEmail("mail@email.com");
//        candidate.setAddress("123 Main St, Springfield, IL 62701");
//        candidate.setPhone("217-555-1234");
//
//        if (candidateRepository.createCandidate(candidate)) {
//            System.out.println("Candidate created successfully");
//        } else {
//            System.out.println("Failed to create candidate");
//        }

//        List<Candidate> candidates = candidateRepository.getAllCandidates();
//        for (Candidate c : candidates) {
//            System.out.println(c);
//        }

        if (jobRepository.createJob("BA with three years experience")) {
            System.out.println("Job created successfully");
        } else {
            System.out.println("Failed to create job");
        }

//        List<Job> jobs = jobRepository.getAllJobs();
    }
}
