package org.myproj.libarrymanagementminor.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum UserType {
    ADMIN,
    STUDENT,
    BOTH
}
