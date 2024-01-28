package dev.tatsat.JobPostingApplication.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "JobPost")
public class PostModel {

    private String position;
    private String description;
    private int experience;
    private String skills[];

}
