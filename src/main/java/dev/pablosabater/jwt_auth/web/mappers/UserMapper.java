package dev.pablosabater.jwt_auth.web.mappers;

import dev.pablosabater.jwt_auth.dom.dto.UserDto;
import dev.pablosabater.jwt_auth.dom.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.id)
                .userName(userDto.name)
                .email(userDto.email)
                .password(userDto.password)
                .build();
    }

    public List<User> toEntities(List<UserDto> userDtos) {
        var userArrayList = new ArrayList<User>();
        for (UserDto userDto : userDtos) {
            userArrayList.add(toEntity(userDto));
        }
        return userArrayList;
    }
}
