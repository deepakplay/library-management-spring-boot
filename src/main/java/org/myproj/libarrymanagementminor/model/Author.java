package org.myproj.libarrymanagementminor.model;

import jakarta.persistence.*;
import lombok.*;
import org.myproj.libarrymanagementminor.model.util.AuthorCompositeKey;
import org.myproj.libarrymanagementminor.model.util.TimeStamps;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(AuthorCompositeKey.class)
public class Author extends TimeStamps {
    @Id
    private String id;

    @Id
    @Column(unique = true, length = 50, nullable = false)
    private String email;


    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}
