package com.jobhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Article;
import com.jobhive.model.Event;
import com.jobhive.model.Post;
import com.jobhive.model.User;
import com.jobhive.repository.SearchRepository;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<Post> searchPosts(String query) {
        return searchRepository.searchPosts(query);
    }

    public List<User> searchPeople(String query) {
        return searchRepository.searchPeople(query);
    }

    public List<Article> searchArticles(String query) {
        return searchRepository.searchArticles(query);
    }

    public List<Event> searchEvents(String query) {
        return searchRepository.searchEvents(query);
    }
}
