package org.myproj.libarrymanagementminor.service.book;


import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.dto.request.AuthorCreationRequest;
import org.myproj.libarrymanagementminor.dto.request.BookCreationRequest;
import org.myproj.libarrymanagementminor.dto.response.BookFilterResponse;
import org.myproj.libarrymanagementminor.enums.BookFilter;
import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.model.Author;
import org.myproj.libarrymanagementminor.model.Book;
import org.myproj.libarrymanagementminor.repository.BookRepository;
import org.myproj.libarrymanagementminor.service.author.AuthorService;
import org.myproj.libarrymanagementminor.service.book.filter.BookFilterFactory;
import org.myproj.libarrymanagementminor.service.book.filter.BookFilterStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookFilterFactory bookFilterFactory;

    @Transactional
    public Book createFromRequest(BookCreationRequest bookCreationRequest) {
        AuthorCreationRequest authorCreationRequest = bookCreationRequest.getAuthor();
        Author author = authorService.createAuthorFromRequest(authorCreationRequest);

        Book book = bookCreationRequest.toBook();
        book.setAuthor(author);
        author.getBooks().add(book);
        book = bookRepository.save(book);
        return book;
    }

    public List<Book> filter(BookFilter bookFilter, FilterOperator operator, String value) {
        BookFilterStrategy filterStrategy = bookFilterFactory.getFilter(bookFilter);
        return filterStrategy.filterBook(operator, value);
    }

    public List<BookFilterResponse> mapToResponse(List<Book> books) {
        return books.stream().map(BookFilterResponse::fromBook).toList();
    }
}
