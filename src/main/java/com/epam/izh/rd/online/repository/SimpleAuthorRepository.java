package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author [] authors = {};

    @Override
    public boolean save(Author author) {
        int count = authors.length;
        boolean answer = true;
        if(findByFullName(author.getName(), author.getLastName()) == author){
            answer = false;
        }

        if(answer == true){
            count++;
            Author [] array1 = new Author[count];
            for (int j = 0, k =0; j < authors.length; j++, k++){
                array1[j] = authors[k];
            }
            array1[count - 1] = author;
            authors = array1;
        }

        return answer;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        Author answer = null;
        for(int i = 0; i < authors.length; i++){
            String fName = authors[i].getName();
            String sName = authors[i].getLastName();
            if(fName == name & sName == lastname) {
                answer = authors[i];
                break;
            }
        }

        return answer;
    }

    @Override
    public boolean remove(Author author) {
        boolean isInArray = false;
        int size = authors.length;
        for (int i = 0;i < size; i++){
            if (authors[i] == author){
                isInArray = true;
                size--;
                for(int j = i;j < size;j++){
                    authors[j] = authors[j + 1];
                }
                break;
            }
        }
        Author [] array = new Author[size];
        for (int i = 0, j = 0; i < size; i++, j++){
            array[i] = authors[j];
        }
        authors = array;
        return isInArray;
    }

    @Override
    public int count() {
        int count = authors.length;
        return count;
    }
}
