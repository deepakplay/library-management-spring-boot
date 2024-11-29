package org.myproj.libarrymanagementminor.model.util;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCompositeKey {
    private String id;
    private String email;
}
