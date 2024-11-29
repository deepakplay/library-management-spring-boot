package org.myproj.libarrymanagementminor.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.model.Author;

import java.util.ArrayList;

@Data
@Builder
public class AuthorCreationRequest {
    @NotBlank(message = "Author email is required")
    private String email;
    @NotBlank(message = "Author name is required")
    private String name;

    public Author toAuthor() {
        return Author.builder()
                .name(this.name)
                .email(this.email)
                .books(new ArrayList<>())
                .build();
    }
}
