package org.myproj.libarrymanagementminor.repository;

import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.model.Book;
import org.myproj.libarrymanagementminor.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
    List<Book> findByTitleContains(String title);

    // email
    List<Book> findByBookNo(String bookNo);
    List<Book> findByBookNoContains(String bookNo);

    // phone
    List<Book> findByBookType(BookType bookType);
}
