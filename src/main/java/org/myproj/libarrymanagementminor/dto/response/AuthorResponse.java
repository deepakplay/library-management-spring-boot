package org.myproj.libarrymanagementminor.dto.response;

import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.model.Author;

@Data
@Builder
public class AuthorResponse {
    private String email;
    private String name;

    public static AuthorResponse fromAuthor(Author author) {
        return AuthorResponse.builder()
                .name(author.getName())
                .email(author.getEmail())
                .build();
    }
}
