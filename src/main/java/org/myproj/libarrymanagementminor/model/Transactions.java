package org.myproj.libarrymanagementminor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.myproj.libarrymanagementminor.enums.TransactionStatus;
import org.myproj.libarrymanagementminor.model.util.TimeStamps;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transactions extends TimeStamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String transaction_id;

    @Enumerated
    private TransactionStatus status;

    @Column(precision = 7, scale = 2)
    private BigDecimal settlementAmount;

    private Date issueDate;

    private Date submitedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
}
