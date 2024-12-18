package com.winged.backend.services;
import com.winged.backend.entities.User;
import com.winged.backend.entities.UserAddress;

import java.util.List;
import java.util.Map;

public interface UserService {
     User register(User user);
     List<User> allUsers();
     User findByUserName(String userName);
     User findByPhoneNumber(long phone);
     String forgetPassword(User user);
//     String changePassword(User user);
     String updateUser(long userid,User user);
     String newUserAddress(long userid, UserAddress address);

//     List<Object> allUserTickets(long userId);

}
