package com.example.a.spring.intro.myProject.services.abstracts;

import com.example.a.spring.intro.myProject.services.dtos.user.requests.AddUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.requests.UpdateUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse;

import java.util.List;

public interface UserService {
    void add(AddUserRequest request);

    void update(UpdateUserRequest request);

    void delete(int id);
    List<GetListUserResponse> orderById();
    List<GetListUserResponse> getByLastName();


}
