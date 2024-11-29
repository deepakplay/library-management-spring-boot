package org.myproj.libarrymanagementminor.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.model.Book;

import java.math.BigDecimal;

@Data
@Builder
public class BookCreationRequest {

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "Book number is required")
    private String bookNo;

    @NotNull(message = "Book type is required")
    private BookType bookType;

    @NotNull(message = "Security amount is required")
    @DecimalMin("0.01")
    private BigDecimal securityAmount;

    @Valid
    @NotNull(message = "Author is required")
    private AuthorCreationRequest author;

    public Book toBook() {
        return Book.builder()
                .title(this.title)
                .bookNo(this.bookNo)
                .bookType(this.bookType)
                .securityAmount(this.securityAmount)
                .build();
    }
}
