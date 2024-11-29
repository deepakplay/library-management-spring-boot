package org.myproj.libarrymanagementminor.dto.response;

import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.model.Author;
import org.myproj.libarrymanagementminor.model.Book;
import org.myproj.libarrymanagementminor.model.User;

import java.math.BigDecimal;

@Data
@Builder
public class BookFilterResponse {
    private String title;
    private String bookNo;
    private BigDecimal securityAmount;
    private BookType type;
    private UserResponse user;
    private AuthorResponse author;

    public static BookFilterResponse fromBook(Book book) {
        BookFilterResponse.BookFilterResponseBuilder bookFilterResponseBuilder = BookFilterResponse.builder()
                .title(book.getTitle())
                .bookNo(book.getBookNo())
                .type(book.getBookType())
                .securityAmount(book.getSecurityAmount())
                .author(AuthorResponse.fromAuthor(book.getAuthor()));

        User student = book.getUser();
        if (student != null) {
            bookFilterResponseBuilder = bookFilterResponseBuilder.user(UserResponse.fromUser(student));
        }

        return bookFilterResponseBuilder.build();
    }
}
