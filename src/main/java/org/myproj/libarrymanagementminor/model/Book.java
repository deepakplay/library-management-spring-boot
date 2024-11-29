package org.myproj.libarrymanagementminor.model;

import jakarta.persistence.*;
import lombok.*;
import org.myproj.libarrymanagementminor.enums.BookType;
import org.myproj.libarrymanagementminor.model.util.TimeStamps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book extends TimeStamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 20, unique = true)
    private String bookNo;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @Column(precision = 7, scale = 2)
    private BigDecimal securityAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "author_id", referencedColumnName = "id"), @JoinColumn(name = "author_email", referencedColumnName = "email")})
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> transactions = new ArrayList<>();
}
















