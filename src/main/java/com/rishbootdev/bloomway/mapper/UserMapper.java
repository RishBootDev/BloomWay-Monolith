package com.rishbootdev.bloomway.mapper;


import com.rishbootdev.bloomway.dto.auth.SignupRequest;
import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import com.rishbootdev.bloomway.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
