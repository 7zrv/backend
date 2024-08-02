package com.example.dischord.user.requestDto;


import com.example.dischord.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserSignupRequestDto {


    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    public String email;

    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 6자 ~ 20자의 비밀번호여야 합니다.")
    public String password;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 1, max = 15)
    public String nickname;


    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phoneNumber;


    public User toEntity(String encryptedPassword){
        return User.builder()
                .email(email)
                .password(encryptedPassword)
                .nickname(nickname)
                .phoneNumber(phoneNumber)
                .build();
    }


}
