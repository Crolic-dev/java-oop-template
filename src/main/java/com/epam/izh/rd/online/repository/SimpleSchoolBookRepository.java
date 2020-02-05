package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    private SchoolBook[] schoolBooks ={};


    @Override
    public boolean save(SchoolBook book) {
        int size = schoolBooks.length;
        size++;
        SchoolBook [] books = new SchoolBook[size];
        for(int i = 0, j = 0;i < schoolBooks.length; i++, j++){
            books[i] = schoolBooks[j];
        }
        books[size - 1] = book;
        schoolBooks = books;

        return true;
    }

    @Override
    public Book[] findByName(String name) {
        int size = 0;
        String nameB;
        for(int i = 0; i < schoolBooks.length; i++){
            nameB = schoolBooks[i].getName();
            if(nameB == name)
                size++;
        }
        SchoolBook [] book = new SchoolBook[size];
        for(int i = 0, j = 0;i < schoolBooks.length; i++){
            nameB = schoolBooks[i].getName();
            if(nameB == name){
                 book [j] = schoolBooks[i];
                j++;
            }
        }
        return book;
    }

    @Override
    public boolean removeByName(String name) {
        boolean isDelete = false;
        String BName;
        int size = schoolBooks.length;
        for(int i = 0; i < schoolBooks.length; i++){
            BName = schoolBooks[i].getName();
            if(BName == name) {
                size--;
                isDelete = true;
            }
        }
        SchoolBook [] books = new SchoolBook[size];
        for(int i = 0, j = 0; i < schoolBooks.length; i++){
            BName = schoolBooks[i].getName();
            if(BName != name){
                books[j] = schoolBooks[i];
                j++;
            }
        }
        schoolBooks = books;
        return isDelete;
    }

    @Override
    public int count() {
        int size = schoolBooks.length;
        return size;
    }
}
