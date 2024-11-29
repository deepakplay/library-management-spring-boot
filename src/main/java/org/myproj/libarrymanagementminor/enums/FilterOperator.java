package org.myproj.libarrymanagementminor.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FilterOperator {
    EQUALS("="),
    LIKE("LIKE");
    private final String operator;
}
