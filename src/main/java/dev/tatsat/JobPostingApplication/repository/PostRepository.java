package dev.tatsat.JobPostingApplication.repository;

import dev.tatsat.JobPostingApplication.model.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostModel, String> {

}
