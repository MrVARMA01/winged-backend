package com.winged.backend.services;
import com.winged.backend.entities.UserAddress;

import java.util.List;

public interface UserAddressService {
    String addAddress(UserAddress address);
    List<UserAddress> allAddresses();
//    List<UserAddress> UserAddresses(long id);
    UserAddress address(long id);


}
