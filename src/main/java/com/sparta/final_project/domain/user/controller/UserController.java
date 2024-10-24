package com.sparta.final_project.domain.user.controller;

import com.sparta.final_project.config.AuthUser;
import com.sparta.final_project.domain.user.dto.request.DeleteUserRequestDto;
import com.sparta.final_project.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원 탈퇴
    @DeleteMapping
    public void deletedUser(@AuthenticationPrincipal AuthUser authUser,
                            @RequestBody DeleteUserRequestDto deleteUserRequestDto) {
        userService.deletedUser(authUser, deleteUserRequestDto);
    }

}