package org.myproj.libarrymanagementminor.service.book.filter;

import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.enums.BookFilter;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BookFilterFactory {
    private final HashMap<BookFilter, BookFilterStrategy> strategy;

    public BookFilterFactory(BookNoFilter bookNoFilter, BookTitleFilter bookTitleFilter, BookTypeFilter bookTypeFilter) {
        strategy = new HashMap<>();
        strategy.put(BookFilter.BOOK_NO, bookNoFilter);
        strategy.put(BookFilter.BOOK_TYPE, bookTypeFilter);
        strategy.put(BookFilter.TITLE, bookTitleFilter);
    }

    public BookFilterStrategy getFilter(BookFilter filter) {
        return strategy.get(filter);
    }
}
