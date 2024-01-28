package dev.tatsat.JobPostingApplication.repository;

import dev.tatsat.JobPostingApplication.model.PostModel;

import java.util.List;

public interface SearchPostRepository {

    List<PostModel> findByText(String text);
}
