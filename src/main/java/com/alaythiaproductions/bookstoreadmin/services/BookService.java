package com.alaythiaproductions.bookstoreadmin.services;

import com.alaythiaproductions.bookstoreadmin.models.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
