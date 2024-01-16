package com.example.a.spring.intro.myProject.repositories;

import com.example.a.spring.intro.myProject.entities.User;
import com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT NEW com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse(u.id, u.lastName) " +
            "FROM User u ORDER BY u.id DESC")
    List<GetListUserResponse> orderById();
    @Query("Select NEW com.example.a.spring.intro.myProject.services.dtos.user.responses.GetListUserResponse(u.id, u.lastName)" +
            "FROM User u WHERE u.lastName LIKE 's%'")
    List<GetListUserResponse> findByLastNameLike();
    boolean existsByMail (String mail);
    boolean existsByAdress(String adress);
    Optional<User> findByMail(String mail);
}
