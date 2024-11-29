package org.myproj.libarrymanagementminor.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.myproj.libarrymanagementminor.enums.UserStatus;
import org.myproj.libarrymanagementminor.enums.UserType;
import org.myproj.libarrymanagementminor.model.User;

@Data
@Builder
public class UserCreateRequest {
    @NotBlank(message = "Name field is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    public User toUser() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .phoneNo(this.phone)
                .address(this.address)
                .userStatus(UserStatus.ACTIVE)
                .userType(UserType.STUDENT)
                .build();

    }
}
