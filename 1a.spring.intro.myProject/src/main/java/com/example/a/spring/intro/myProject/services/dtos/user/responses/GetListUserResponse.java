package com.example.a.spring.intro.myProject.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetListUserResponse {
    private int id;
    private String lastName;
}
