package com.example.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, String> {
    // <ReturnType> [operation]By[attribute]([]parameter)
    Greeting findByid(int id);
    String deleteByid(int id);
//    String deleteByid(int id);
}
