package dev.tatsat.JobPostingApplication.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.tatsat.JobPostingApplication.model.PostModel;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchPostRepositoryImpl implements SearchPostRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<PostModel> findByText(String text) {
        final List<PostModel> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("JobSearchPortal");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "auto-search")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("skills", "description", "position")))),
                new Document("$sort",
                        new Document("experience", 1L))));

        result.forEach(doc -> posts.add(converter.read(PostModel.class, doc)));

        return posts;
    }
}
