package com.example.a.spring.intro.myProject.services.concretes;

import com.example.a.spring.intro.myProject.entities.User;
import com.example.a.spring.intro.myProject.repositories.UserRepository;
import com.example.a.spring.intro.myProject.services.abstracts.UserService;
import com.example.a.spring.intro.myProject.services.dtos.user.requests.AddUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.requests.UpdateUserRequest;
import com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service

public class UserManager implements UserService {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(AddUserRequest request) {
        if (userRepository.existsByMail(request.getMail())){
            throw new RuntimeException("Farklı bir mail adresi girin");
        }
        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setAdress(request.getAdress());
        user.setMail(request.getMail());
        userRepository.save(user);
        
    }


    @Override
    public void update(UpdateUserRequest request) {
        if(userRepository.existsByAdress(request.getAdress())){
            throw new RuntimeException("Aynı adresi giremezsiniz");
        }
        User user = userRepository.findById(request.getId()).orElseThrow();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setAdress(request.getAdress());
        user.setMail(request.getMail());
        userRepository.save(user);
        
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);


    }

    @Override
    public List<GetListUserResponse> orderById() {

        return userRepository.orderById().stream()
                .map(customer->new GetListUserResponse(customer.getId(), customer.getLastName()))
                .sorted(Comparator.comparing(GetListUserResponse::getId)).toList();
    }

    @Override
    public List<GetListUserResponse> getByLastName() {
        return userRepository.findByLastNameLike().stream()
                        .map(customer->new GetListUserResponse(customer.getId(), customer.getLastName()))
                        .filter(customer->customer.getLastName().contains("s")).toList();


    }


}
