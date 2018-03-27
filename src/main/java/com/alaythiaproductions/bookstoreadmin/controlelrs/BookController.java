package com.alaythiaproductions.bookstoreadmin.controlelrs;

import com.alaythiaproductions.bookstoreadmin.models.Book;
import com.alaythiaproductions.bookstoreadmin.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/add")
    public String addBookForm(Model model) {
        Book book = new Book();

        model.addAttribute("title", "Add Book");
        model.addAttribute("book", book);
        return "views/addBook";
    }

    @PostMapping(value = "/add")
    public String processBook(Model model, @ModelAttribute("book") Book book, HttpServletRequest request)  {

        model.addAttribute("title", "Add A Book");

        bookService.save(book);
        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/img/book/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/book/list";
    }

    @RequestMapping(value = "/bookInfo")
    public String bookInfo(@RequestParam("id") long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);

        return "views/bookInfo";
    }

    @GetMapping(value = "/list")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("title", "Book List");
        model.addAttribute("books", bookList);

        return "views/bookList";
    }
}
