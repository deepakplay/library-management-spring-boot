package org.myproj.libarrymanagementminor.dto.response;

import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.model.User;

@Data
@Builder
public class UserFilterResponse {
    private String name;
    private String email;
    private String phone;
    private String address;

    public static UserFilterResponse fromUser(User user) {
        return UserFilterResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhoneNo())
                .address(user.getAddress()).build();
    }
}
