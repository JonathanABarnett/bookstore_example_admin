package com.alaythiaproductions.bookstoreadmin.controlelrs;

import com.alaythiaproductions.bookstoreadmin.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "book")
public class BookController {

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        Book book = new Book();

        model.addAttribute("title", "Add Book");
        model.addAttribute("book", book);
        return "views/addBook";

    }
}
