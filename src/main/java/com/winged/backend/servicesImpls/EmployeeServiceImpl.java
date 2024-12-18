package com.winged.backend.servicesImpls;

import com.winged.backend.entities.Employee;
import com.winged.backend.entities.Role;
import com.winged.backend.entities.User;
import com.winged.backend.repositories.EmployeeRepository;
import com.winged.backend.repositories.RoleRepository;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.EmployeeService;
import com.winged.backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private RoleService roleService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Employee register(Employee employee) {
        validateEmployee(employee);
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        if (employee.getProfilePic() == null || employee.getProfilePic().isEmpty()) {
            employee.setProfilePic("p01");
        }
        Role roleData = roleService.roleById(employee.getRole().getId());
        employee.setRole(roleData);
        return repository.save(employee);
    }

    private void validateEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Please Enter The Name");
        }
        if (employee.getPhoneNumber() == 0 || employee.getPhoneNumber() == 91) {
            throw new IllegalArgumentException("Please Enter The PhoneNumber");
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Please Enter The Email");
        }
        if (employee.getPassword() == null || employee.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Please Enter The Password");
        }
        if (employee.getRole() == null) {
            throw new IllegalArgumentException("Invalid Role ID");
        }

        Pattern phonePattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        if (!phonePattern.matcher(String.valueOf(employee.getPhoneNumber())).matches()) {
            throw new IllegalArgumentException("Invalid PhoneNumber");
        }

        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        if (!emailPattern.matcher(employee.getEmail()).matches()) {
            throw new IllegalArgumentException("Invalid Email");
        }
    }



    @Override
    public List<Employee> allEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Employee findByPhoneNumber(long phone) {
        return repository.findByPhoneNumber(phone);
    }

    @Override
    public String forgetPassword(Employee empData) {
        Employee employee = findByEmail(empData.getEmail());
        if (employee != null) {
            employee.setPassword(passwordEncoder.encode(empData.getPassword()));
            repository.save(employee);
            return "Password Change Successful !";
        }
        else {
            return "User does not exist !";
        }
    }

    @Override
    public String updateEmployee(long empId, Employee employee) {
        Employee existingEmpData = repository.findById(empId);
        if (employee.getName() != null && employee.getName() !=""){
            existingEmpData.setName(employee.getName());
        }
        if (employee.getPhoneNumber() != 0 && employee.getPhoneNumber() != 91){
            existingEmpData.setPhoneNumber(employee.getPhoneNumber());
        }
        if (employee.getAddress() != null && employee.getAddress() != ""){
            existingEmpData.setAddress(employee.getAddress());
        }
        if (employee.getEmail() != null && employee.getEmail() != ""){
            existingEmpData.setEmail(employee.getEmail());
        }if (employee.getProfilePic() != null && employee.getProfilePic() != ""){
            existingEmpData.setProfilePic(employee.getProfilePic());
        }
        repository.save(existingEmpData);
        return "Record updated !";
    }
}
