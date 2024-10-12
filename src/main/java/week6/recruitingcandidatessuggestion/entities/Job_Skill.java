package week6.recruitingcandidatessuggestion.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Job_Skill {
    private int jobId;
    private int skillId;
    private int level;
}
