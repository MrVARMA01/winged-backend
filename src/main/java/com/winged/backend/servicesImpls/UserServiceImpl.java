package com.winged.backend.servicesImpls;
import com.winged.backend.entities.User;
import com.winged.backend.entities.UserAddress;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.PaintingAndRenovation.PaintingAndRenovationTicketService;
import com.winged.backend.services.UserService;
import com.winged.backend.services.electronics.ElectronicsTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PaintingAndRenovationTicketService PRService;
    @Autowired
    private ElectronicsTicketService electronicsService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) throws NullPointerException {
        try {
            if (user.getName().equals("") || user.getName().equals(null)){
                System.out.println("Please Enter The Name");
                throw new NullPointerException();
            }
            else if (user.getPhoneNumber() == 0 || user.getPhoneNumber() == 91){
                System.out.println("Please Enter The PhoneNumber");
                throw new NullPointerException();
            }
            else if (user.getEmail().equals("") || user.getEmail().equals(null)){
                System.out.println("Please Enter The Email");
                throw new NullPointerException();
            }
            else if (user.getPassword().equals("") || user.getPassword().equals(null)){
                System.out.println("Please Enter The Password");
                throw new NullPointerException();
            }
            else if (user.getAddresses() == null){
                System.out.println("Invalid UserAddress");
                throw new NullPointerException();
            }
            else {
                String str = Long.toString(user.getPhoneNumber());
                Pattern phonePtrn = Pattern.compile("(0/91)?[6-9][0-9]{11}");
                Matcher match = phonePtrn.matcher(str);
                boolean isValid1 = match.find() && match.group().equals(str);

                Pattern emailPtrn = Pattern.compile("^(.+)@(.+)$");
                match = emailPtrn.matcher(user.getEmail());
                boolean isValid2 = match.find() && match.group().equals(user.getEmail());

                if(isValid1 != true || isValid2 != true){
                    System.out.println("\n-Invalid PhoneNumber or Email");
                    throw new NullPointerException();
                }
                else {
                    if (user.getProfilePic().equals("") || user.getProfilePic().equals(null)){
                        user.setProfilePic("assets/User/p01.png");
                    }
                    UserAddress address = user.getAddresses().get(0);
                    user.setRegisteredDate(LocalDate.now());
                    String encodedPassword = passwordEncoder.encode(user.getPassword());
                    user.setPassword(encodedPassword);
                    repository.save(user);
                    user.setAddressId(address.getId());
                    return repository.save(user);
                }
            }

        }catch (Exception e){
            System.out.println(e);
            throw new NullPointerException();
        }
    }


    @Override
    public List<User> allUsers() {
        return repository.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return repository.findByEmail(userName);
    }

    @Override
    public User findByPhoneNumber(long phone) {
        return repository.findByPhoneNumber(phone);
    }

    @Override
    public String forgetPassword(User userdata) {
        User user = findByUserName(userdata.getEmail());
        if (user != null) {
            user.setPassword(passwordEncoder.encode(userdata.getPassword()));
            repository.save(user);
            return "Password Change Successful !";
        }
        else {
            return "User does not exist !";
        }
    }

    @Override
    public String updateUser(long userid, User user) {
        User existingUserData = repository.findByUserId(userid);
        if (user.getName() != null && user.getName() !=""){
            existingUserData.setName(user.getName());
        }
        if (user.getPhoneNumber() != 0 && user.getPhoneNumber() != 91){
            existingUserData.setPhoneNumber(user.getPhoneNumber());
        }
        if (user.getAddressId() != 0){
            existingUserData.setAddressId(user.getAddressId());
        }
        if (user.getEmail() != null && user.getEmail() != ""){
            existingUserData.setEmail(user.getEmail());
        }if (user.getProfilePic() != null && user.getProfilePic() != ""){
            existingUserData.setProfilePic(user.getProfilePic());
        }
        repository.save(existingUserData);
        return "Record updated !";
    }

    @Override
    public String newUserAddress(long userid, UserAddress address) {
        User existingUserData = repository.findByUserId(userid);
        if (existingUserData!=null){
            List<UserAddress> updatedAddressList = existingUserData.getAddresses();
            updatedAddressList.add(address);
            existingUserData.setAddresses(updatedAddressList);
            repository.save(existingUserData);
            return "Record Saved!";
        }
        return "Record Failed To Save!";
    }

//    @Override
//    public List<Object> allUserTickets(long userId) {
//        List<Object> responseList = new ArrayList<>(); // Initialize the list
//        if (userId != 0) {
//            responseList.add(PRService.allUserTickets(userId));
//            responseList.add(electronicsService.allUserTickets(userId));
//        }
//        return responseList;
//    }


}
