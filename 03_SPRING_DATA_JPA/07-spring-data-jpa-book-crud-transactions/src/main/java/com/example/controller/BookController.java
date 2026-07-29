package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book saveBook = bookService.saveBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book saveBook = bookService.saveBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/booksByTitle")
    public ResponseEntity<List<Book>> findBookByTitle(@RequestParam String title){
        List<Book> bookByTitle = bookService.findBookByTitle(title);
        return new ResponseEntity<>(bookByTitle,HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
        Boolean isSave = bookService.deleteBook(bookId);
        if(isSave)
            return new ResponseEntity<>("Book record deleted",HttpStatus.OK);
        else
            return new ResponseEntity<>("Book record not deleted, some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
