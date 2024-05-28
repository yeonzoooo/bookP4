package com.mysite.bookp4;

import com.mysite.bookp4.entity.Book;
import com.mysite.bookp4.entity.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")

public class BookControllor {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam (required = false) String title ,
                                  @RequestParam (required = false) String author) {
        if (title !=null) {
            return bookService.findByTitle(title);
        }else if (author != null) {
            return bookService.findByAuthor(author);
        } else {
            return bookService.findAll();
        }
    }
    @PostMapping
    public  Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PostMapping("/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setCategory(bookDetails.getCategory());
            book.setAvailable(bookDetails.isAvailable());
            return bookService.save(bookDetails);
        }).orElseThrow(() -> new RuntimeException("Book not found whit id" + id));

    }
@DeleteMapping("/{id}")
        public void deleteBook(@PathVariable Long id) {
    bookService.deleteById(id);
      }
      }

