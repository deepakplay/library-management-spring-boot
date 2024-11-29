package org.myproj.libarrymanagementminor.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.dto.request.BookCreationRequest;
import org.myproj.libarrymanagementminor.dto.response.BookCreatedResponse;
import org.myproj.libarrymanagementminor.dto.response.BookFilterResponse;
import org.myproj.libarrymanagementminor.enums.BookFilter;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.model.Book;
import org.myproj.libarrymanagementminor.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookCreatedResponse> create(@Valid @RequestBody BookCreationRequest bookCreationRequest) {
        Book book = bookService.createFromRequest(bookCreationRequest);
        return new ResponseEntity<>(BookCreatedResponse.builder().build(), HttpStatus.CREATED);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookFilterResponse>> filter(@NotNull @RequestParam("filterBy") BookFilter bookFilter,
                                                           @NotNull @RequestParam("operator") FilterOperator operator,
                                                           @NotBlank @RequestParam("value") String value) {
        List<Book> books = bookService.filter(bookFilter, operator, value);
        List<BookFilterResponse> booksResponse = bookService.mapToResponse(books);
        return new ResponseEntity<>(booksResponse, HttpStatus.OK);
    }
}
