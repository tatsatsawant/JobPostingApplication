package dev.tatsat.JobPostingApplication.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {

    private String position;
    private String description;
    private int experience;
    private String skills[];

}
