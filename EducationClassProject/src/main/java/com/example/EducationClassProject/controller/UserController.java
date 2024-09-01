package com.example.EducationClassProject.controller;

import com.example.EducationClassProject.apiPayload.BaseResponse;
import com.example.EducationClassProject.converter.UserConverter;
import com.example.EducationClassProject.domain.User;
import com.example.EducationClassProject.dto.user.UserRequestDTO;
import com.example.EducationClassProject.dto.user.UserResponseDTO;
import com.example.EducationClassProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 회원 가입
    @PostMapping("api/v1/join/users")
    public BaseResponse<UserResponseDTO.JoinResultDTO> joinUser(@RequestBody UserRequestDTO.JoinDTO joinDTO) {
        User user = userService.joinUser(joinDTO);
        return BaseResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    //유저 단건 조회
    @GetMapping("api/v1/fing/user/{userId}")
    public BaseResponse<UserResponseDTO.FindUserResultDTO> findUser(@PathVariable UUID userId) {
            User user = userService.findUser(userId);
            return BaseResponse.onSuccess(UserConverter.toFindUserResultDTO(user));
    }

    // 유저 전체 조회
    @GetMapping("api/v1/find/users")
    public BaseResponse<UserResponseDTO.FindUsersListDTO> findAllUser() {
        List<User> userList = userService.findAllUsers();
        return BaseResponse.onSuccess(UserConverter.toFindUserListResultDTO(userList));
    }

    // 유저 삭제
    @DeleteMapping("api/v1/delete/user/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return "삭제되었습니다";
    }

}
