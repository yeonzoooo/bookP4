package com.mysite.bookp4;

import com.mysite.bookp4.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
   public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
