package com.my.member.dto;

import com.my.member.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String nickname;

    // 엔티티를 받아서 Dto로 변환해 주는 함수
    public static UserDto fromEntity(UserEntity user) {
        return new UserDto(
                user.getEmail(),
                user.getPassword(),
                user.getNickname()
        );
    }

    // DTO를 받아서 Entity에 넣는 작업
    public static UserEntity toDto(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        userEntity.setNickname(dto.getNickname());
        return userEntity;
    }
}
