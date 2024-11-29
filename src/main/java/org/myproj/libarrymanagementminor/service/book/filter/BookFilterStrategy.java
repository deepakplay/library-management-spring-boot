package org.myproj.libarrymanagementminor.service.book.filter;

import org.myproj.libarrymanagementminor.enums.BookFilter;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.model.Book;

import java.util.List;

public interface BookFilterStrategy {
    List<Book> filterBook(FilterOperator operator, String value);
}
