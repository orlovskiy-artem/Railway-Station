package com.kpi.railwaystation.services;

import com.kpi.railwaystation.dto.UserDto;

public interface UserService {
    UserDto login(String email, String password);
    void changePassword(String email, String newPassword);
    void save(UserDto userDto);
    void deleteUser(Long id);

}
