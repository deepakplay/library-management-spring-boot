package org.myproj.libarrymanagementminor.model;

import jakarta.persistence.*;
import lombok.*;
import org.myproj.libarrymanagementminor.enums.UserStatus;
import org.myproj.libarrymanagementminor.enums.UserType;
import org.myproj.libarrymanagementminor.model.util.TimeStamps;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends TimeStamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true, length = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transactions> transactions = new ArrayList<>();
}


























