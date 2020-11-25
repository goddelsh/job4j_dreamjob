package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StubStore implements Store {

    private List<Post> posts = new ArrayList<>();

    @Override
    public Collection<Post> findAllPosts() {
        return posts;
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return null;
    }

    @Override
    public void save(Post post) {
        this.posts.add(post);
    }

    @Override
    public void save(Candidate candidate) {

    }

    @Override
    public Post findPostById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Candidate findCandidateById(int id) {
        return null;
    }

    @Override
    public String getImage(int id) {
        return null;
    }

    @Override
    public int saveImage(String name) {
        return 0;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public List<City> getCities() {
        return null;
    }

    @Override
    public String getCityById(int id) {
        return null;
    }
}
