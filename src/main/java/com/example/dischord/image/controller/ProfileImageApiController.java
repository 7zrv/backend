package com.example.dischord.image.controller;


import com.example.dischord.global.response.ApiResponse;
import com.example.dischord.image.requestDto.ImgUploadRequestDto;
import com.example.dischord.image.responseDto.ImgUploadResponseDto;
import com.example.dischord.image.service.ProfileImageService;
import com.example.dischord.user.requestDto.UserSignupRequestDto;
import com.example.dischord.user.responseDto.UserResponseDto;
import com.example.dischord.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProfileImageApiController {

    private final ProfileImageService profileImageService;

    @PostMapping("/api/profileImage")
    public ApiResponse<UserResponseDto> uploadProfileImg(@RequestBody ImgUploadRequestDto requestDto) {

        ImgUploadResponseDto responseDto = profileImageService.uploadImg(requestDto);

        return ApiResponse.ok(responseDto);
    }
}
