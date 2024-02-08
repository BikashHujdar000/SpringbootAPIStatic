package com.example.api.bookapi.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.api.bookapi.entities.Book;

@Service
public class BookService {

    private static List <Book> list = new ArrayList<Book>();
    
    static{

        list.add(new Book(1,"Man","mpu"));
        list.add(new Book(2,"Universe","mpu"));
        list.add(new Book(3,"Sar","mpu"));
        list.add(new Book(4,"Tta","mpu"));
        list.add(new Book(5,"Man","mpu"));
        list.add(new Book(6,"Man","mpu"));


    }
// get all books 
public List<Book> getallBook()
{
    return list ;
}
// get any one books by id 

public Book getBookById(int id)
{
  Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
  return book;
}

// add a books 
 public Book addBook(Book book)
 {
    list.add(book);
    return book;
 }
 //delete a book 
 public void deleteBook(int bid)
 {
    list = list.stream().filter(book -> book.getId()!= bid).
    collect(Collectors.toList());

 }
 public void  updateBook( int bookId, Book book )
 {

    list.stream().map(b->{
        if (b.getId()==bookId) {
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
        }
        return b;


    }). collect(Collectors.toList());
 }



    
}
