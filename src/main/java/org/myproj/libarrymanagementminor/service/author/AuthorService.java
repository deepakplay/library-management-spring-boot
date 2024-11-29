package org.myproj.libarrymanagementminor.service.author;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.dto.request.AuthorCreationRequest;
import org.myproj.libarrymanagementminor.model.Author;
import org.myproj.libarrymanagementminor.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public Author createAuthorFromRequest(AuthorCreationRequest authorCreationRequest) {
        String authorEmail = authorCreationRequest.getEmail();
        Author author = authorRepository.findByEmail(authorEmail);

        if (author == null) {
            author = authorCreationRequest.toAuthor();
            author.setId(UUID.randomUUID().toString());
            author = authorRepository.save(author);
        }

        return author;
    }
}
