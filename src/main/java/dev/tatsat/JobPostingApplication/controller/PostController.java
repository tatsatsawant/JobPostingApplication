package dev.tatsat.JobPostingApplication.controller;

import dev.tatsat.JobPostingApplication.model.PostModel;
import dev.tatsat.JobPostingApplication.repository.PostRepository;
import dev.tatsat.JobPostingApplication.repository.SearchPostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchPostRepository searchPostRepository;

    @GetMapping("/allPosts")
    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }


    @PostMapping("/addPost")
    public PostModel addPost(@RequestBody PostModel postModel) {
        postModel.setId(new ObjectId());
        return postRepository.save(postModel);
    }

    @GetMapping("/searchPost/{text}")
    public List<PostModel> getSearchedPost(@PathVariable String text) {
        return searchPostRepository.findByText(text);
    }
}
