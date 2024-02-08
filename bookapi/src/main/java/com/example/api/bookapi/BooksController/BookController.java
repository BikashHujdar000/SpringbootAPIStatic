package com.example.api.bookapi.BooksController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.api.bookapi.Services.BookService;
import com.example.api.bookapi.entities.Book;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getallBook();

    }

    @GetMapping("/books/{id}")
public Book getBooksById(@PathVariable("id") int id)
{
    return bookService.getBookById(id);
}

// craating book 
@PostMapping("/books")
public Book addBook(@RequestBody Book b)
{
   Book book = this.bookService.addBook(b);
   return book;
}

@DeleteMapping("/books/{bookId}")
public void deleteBook( @PathVariable("bookId") int bookId )
{
    this.bookService.deleteBook(bookId);
}
@PutMapping("/books/{bookId}")
public Book updateBook(@RequestBody Book b ,@PathVariable("bookId") int bookID)
{
   this.bookService.updateBook(bookID,b);
    return b;

}



 
}
