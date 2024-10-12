package week6.recruitingcandidatessuggestion.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Candidate {
    private int id;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String address;
    private String phone;
}
