package org.myproj.libarrymanagementminor.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCreatedResponse {
    @Builder.Default
    private String message = "Book Created Successfully";
}
