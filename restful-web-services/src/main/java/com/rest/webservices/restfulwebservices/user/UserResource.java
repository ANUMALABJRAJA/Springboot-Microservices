package com.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    private UserDoaService userDoaService;
    public UserResource(UserDoaService service){
        userDoaService = service;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDoaService.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<User> retriveSpecificUser(@PathVariable int id){
       User user = userDoaService.findById(id);
       if(user ==null){
           throw new UserNotFoundException("Id:"+id);
       }
       EntityModel<User> em = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        em.add(link.withRel("all-users"));
       return em;
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User userSaved = userDoaService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location","http://localhost:8080/users/"+userSaved.getId());
//        return ResponseEntity.created(null).headers(headers).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteuser(@PathVariable int id){
        userDoaService.deleteById(id);

    }

}
