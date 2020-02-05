package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;

public class SimpleAuthorService implements AuthorService{

    private AuthorRepository authorRepository;

    public SimpleAuthorService() {
    }

    public SimpleAuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }



    @Override
    public boolean save(Author author) {
        boolean answer = authorRepository.save(author);
        return answer;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        Author author;
        author = authorRepository.findByFullName(name, lastname);
        return author;
    }

    @Override
    public boolean remove(Author author) {
        boolean answer = authorRepository.remove(author);
        return answer;
    }

    @Override
    public int count() {
        int size = authorRepository.count();
        return size;
    }
}
