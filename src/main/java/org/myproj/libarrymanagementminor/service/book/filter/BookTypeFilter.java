package org.myproj.libarrymanagementminor.service.book.filter;

import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.enums.BookFilter;
import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.model.Book;
import org.myproj.libarrymanagementminor.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookTypeFilter implements BookFilterStrategy {
    private static final Logger logger = LoggerFactory.getLogger(BookTypeFilter.class);
    private final BookRepository bookRepository;

    @Override
    public List<Book> filterBook(FilterOperator operator, String value) {
        logger.info("Book Type Filter");
        return switch (operator) {
            case EQUALS -> bookEquals(value);
            case LIKE -> new ArrayList<>();
        };
    }

    private List<Book> bookEquals(String value) {
        return bookRepository.findByBookType(BookType.valueOf(value));
    }
}
