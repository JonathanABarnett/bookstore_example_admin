package com.alaythiaproductions.bookstoreadmin.controlelrs;

import com.alaythiaproductions.bookstoreadmin.models.Book;
import com.alaythiaproductions.bookstoreadmin.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    public String processBook(Model model, @ModelAttribute("book") Book book, HttpServletRequest request) throws IOException {

        bookService.save(book);
        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:views/bookList";

    }
}
