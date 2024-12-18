package com.winged.backend.jwt;

import com.winged.backend.entities.Employee;
import com.winged.backend.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtEmpResponse {
    private String jwtToken;
    private Employee employee;
}
