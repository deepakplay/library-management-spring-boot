package org.myproj.libarrymanagementminor.service.user;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.dto.request.UserCreateRequest;
import org.myproj.libarrymanagementminor.dto.response.UserCreatedResponse;
import org.myproj.libarrymanagementminor.dto.response.UserFilterResponse;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.enums.UserFilter;
import org.myproj.libarrymanagementminor.enums.UserType;
import org.myproj.libarrymanagementminor.model.User;
import org.myproj.libarrymanagementminor.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserCreatedResponse create(@Valid UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.toUser();
        user.setUserType(UserType.STUDENT);
        user = userRepository.save(user);

        return UserCreatedResponse.builder().build();
    }


    public List<User> filter(UserFilter filterBy, FilterOperator operator, String value) {
        return switch (filterBy) {
            case UserFilter.NAME -> switch (operator) {
                case EQUALS -> userRepository.findByName(value);
                case LIKE -> userRepository.findByNameContains(value);
            };
            case UserFilter.EMAIL -> switch (operator) {
                case EQUALS -> userRepository.findByEmail(value);
                case LIKE -> userRepository.findByEmailContains(value);
            };
            case UserFilter.PHONE -> switch (operator) {
                case EQUALS -> userRepository.findByPhoneNo(value);
                case LIKE -> userRepository.findByPhoneNoContains(value);
            };
        };
    }

    public List<UserFilterResponse> mapToUserResponse(List<User> users) {
        return users.stream().map(UserFilterResponse::fromUser).collect(Collectors.toList());
    }
}








