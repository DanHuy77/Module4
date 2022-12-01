package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.BorrowCode;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BookController {

    @Autowired
    private IBookService bookService;
//    @Autowired
//    private IBorrowCodeService borrowCodeService;

    @GetMapping("")
    public String showBookList(Model model, Pageable pageable) {
        Page<Book> bookList = bookService.findAll(pageable);
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/borrow")
    public String showBorrowForm(Integer id, Model model) {
        Book book = bookService.findById(id);
        BorrowCode borrowCode = new BorrowCode();
        String code = String.valueOf(Math.floor((Math.random() * 8999) + 1000));
        borrowCode.setId(code);
        model.addAttribute("borrowCode", borrowCode);
        model.addAttribute("book", book);
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute("book") Book book, Integer id, RedirectAttributes redirectAttributes) {
return null;
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "return1";
    }

    @PostMapping("/search")
    public String search(String borrowCode, Model model) {
        Book book = bookService.findBookByBorrowCodeContaining(borrowCode);
        model.addAttribute("book", book);
        return "return2";
    }
}
