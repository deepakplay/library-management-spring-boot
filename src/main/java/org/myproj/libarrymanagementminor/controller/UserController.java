package org.myproj.libarrymanagementminor.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.myproj.libarrymanagementminor.dto.request.UserCreateRequest;
import org.myproj.libarrymanagementminor.dto.response.UserCreatedResponse;
import org.myproj.libarrymanagementminor.dto.response.UserFilterResponse;
import org.myproj.libarrymanagementminor.enums.FilterOperator;
import org.myproj.libarrymanagementminor.enums.UserFilter;
import org.myproj.libarrymanagementminor.model.User;
import org.myproj.libarrymanagementminor.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserCreatedResponse> create(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        UserCreatedResponse userCreatedResponse = userService.create(userCreateRequest);

        return new ResponseEntity<>(userCreatedResponse, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserFilterResponse>> search(@NotNull @RequestParam("filterBy") UserFilter filterBy,
                                                           @NotNull @RequestParam("operator") FilterOperator operator,
                                                           @NotBlank @RequestParam("value") String value) {
        List<User> users = userService.filter(filterBy, operator, value);
        List<UserFilterResponse> userResponses = userService.mapToUserResponse(users);
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }


}
// create, search, updated, delete



















