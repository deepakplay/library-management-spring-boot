package org.myproj.libarrymanagementminor.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreatedResponse {
    @Builder.Default
    private String message = "User Created Successfully";
}
