package com.ashokit.controller;

import com.ashokit.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookRestController {

    @GetMapping(value = "/book",produces = {"application/json","application/xml"})
    public ResponseEntity<Book> getBook(){
        Book book=new Book(101,"Java",1500.00);

        return new ResponseEntity<>(book, HttpStatus.OK); // spring boot will convert java object to json to consumer
    }

    @GetMapping(value = "/books",produces = {"application/json","application/xml"})
    public ResponseEntity<List<Book>> getBooks(){
        Book book1=new Book(101,"Java",1500.00);
        Book book2=new Book(102,".Net",1250.00);
        Book book3=new Book(103,"Python",1050.50);

        List<Book> listOfBooks = Arrays.asList(book1, book2, book3);

        return new ResponseEntity<>(listOfBooks,HttpStatus.OK);
    }

    @PostMapping(value = "/book", consumes = {"application/json","application/xml"} , produces = "text/plain")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        System.out.println("Request payload : Book : "+book);

        // todo: insert book into the db

        String msg="Record Saved...";

        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @PutMapping(value = "/book/{bookId}",
            consumes = {"application/json","application/xml"},
            produces = {"application/json","application/xml"})
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId,@RequestBody Book book){
        System.out.println("Request payload - bookId : "+bookId);

        // todo: update book into the db

        System.out.printf("Book : "+book);

        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PatchMapping(value = "/book/{bookId}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> updateBookPatch(@PathVariable Integer bookId,@RequestBody Book book){
        System.out.println("Request payload - bookId : "+bookId);

        // todo: update book into the db

        System.out.printf("Book : "+book);

        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping(value = "/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
        System.out.printf("DeleteBook - request bookId : "+bookId);

        // todo: delete book into the db

        String msg="Book Deleted..";

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }





}
