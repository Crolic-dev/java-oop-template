package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService {

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(Book book) {
        boolean isSave;
        Author author;
        SchoolBook books = (SchoolBook)book;
        author = authorService.findByFullName(books.getAuthorName(), books.getAuthorLastName());
        if(author == null){
            isSave = false;
        }
        else{
            schoolBookBookRepository.save((SchoolBook) book);
            isSave = true;
        }

        return isSave;
    }

    @Override
    public Book[] findByName(String name) {
        Book [] books;
        books = schoolBookBookRepository.findByName(name);
        return books;
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        int count;
        Book [] books;
        books = schoolBookBookRepository.findByName(name);
        count = books.length;
        return count;
    }

    @Override
    public boolean removeByName(String name) {
        boolean answer = schoolBookBookRepository.removeByName(name);
        return answer;
    }

    @Override
    public int count() {
        int size = schoolBookBookRepository.count();
        return size;
    }

    @Override
    public Author findAuthorByBookName(String name) {
        String fName;
        String lName;
        Author author;
        SchoolBook [] book;
        book = (SchoolBook[]) schoolBookBookRepository.findByName(name);
        if (book.length > 0) {
            fName = book[0].getAuthorName();
            lName = book[0].getAuthorLastName();
            author = authorService.findByFullName(fName, lName);
        }
        else
            author = null;
        return author;
    }
}
