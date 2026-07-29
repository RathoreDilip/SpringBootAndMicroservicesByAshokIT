package com.example.service;

import com.example.entity.Book;
import com.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // create & update
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    // retrieve
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // find by title
    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    // delete
    public Boolean deleteBook(Integer id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
