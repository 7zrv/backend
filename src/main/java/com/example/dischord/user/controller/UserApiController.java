package com.example.dischord.user.controller;


import com.example.dischord.global.response.ApiResponse;
import com.example.dischord.user.requestDto.UserSignupRequestDto;
import com.example.dischord.user.responseDto.UserResponseDto;
import com.example.dischord.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ApiResponse<UserResponseDto> signupUser(@RequestBody UserSignupRequestDto requestDto) {

        UserResponseDto responseDto = userService.signupUser(requestDto);

        return ApiResponse.ok(responseDto);
    }

    @GetMapping("/api/user/{userId}")
    public ApiResponse<UserResponseDto> getUser(@PathVariable Long userId) {

        UserResponseDto responseDto = userService.getUser(userId);

        return ApiResponse.ok(responseDto);
    }

    @DeleteMapping("/api/user/{userId}")
    public ApiResponse<?> signOutUser(@PathVariable Long userId) {

        userService.deleteUser(userId);

        return ApiResponse.ok();
    }





}
