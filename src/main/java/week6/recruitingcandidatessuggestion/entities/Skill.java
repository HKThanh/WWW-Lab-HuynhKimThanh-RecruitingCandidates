package week6.recruitingcandidatessuggestion.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Skill {
    @Setter(AccessLevel.NONE)
    private int id;
    private String skill_name;
    private String description;
    private String field;
}
