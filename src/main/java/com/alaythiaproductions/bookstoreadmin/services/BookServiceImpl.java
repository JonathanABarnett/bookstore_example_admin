package com.alaythiaproductions.bookstoreadmin.services;

import com.alaythiaproductions.bookstoreadmin.models.Book;
import com.alaythiaproductions.bookstoreadmin.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
