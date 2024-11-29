package org.myproj.libarrymanagementminor.repository;


import org.myproj.libarrymanagementminor.model.Author;
import org.myproj.libarrymanagementminor.model.util.AuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {
    Author findByEmail(String authorEmail);
}
