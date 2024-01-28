package dev.tatsat.JobPostingApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "JobPost")
public class PostModel {

    @Id
    private ObjectId id;

    private String position;
    private String description;
    private int experience;
    private String[] skills;
}
