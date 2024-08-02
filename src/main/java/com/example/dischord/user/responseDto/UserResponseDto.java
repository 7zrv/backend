package com.example.dischord.user.responseDto;


import com.example.dischord.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final Long id;
    private final String email;
    private final String nickname;
    private final LocalDateTime signupAt;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getEmail(), user.getNickname(), user.getCreatedAt());
    }
}
