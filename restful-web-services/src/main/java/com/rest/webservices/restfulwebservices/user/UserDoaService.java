package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDoaService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0   ;
    static{
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Abj", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount,"Raja", LocalDate.now().minusYears(21)));
        users.add(new User(++usersCount,"Bilvesh", LocalDate.now().minusYears(22)));
    }
    public List<User> findAll(){
        return users;
    }
    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
