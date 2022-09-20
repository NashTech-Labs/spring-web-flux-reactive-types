package com.example.app.mono;

import com.example.app.model.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/mono/user")
public class MonoUserController {

    private MonoUserService monoUserService;

    public MonoUserController(MonoUserService monoUserService) {
        this.monoUserService=monoUserService;
    }

    @GetMapping
    public Mono<User> getMonoUser(){

        return monoUserService.getMonoUser();
    }

    @PostMapping(value = "/convertToUpperCase")
    public Mono<User> userNameToUpperCase(@RequestBody Mono<User> userMono){

        return monoUserService.operateOnUserName(userMono);
    }

    @PostMapping(value = "/convertToUpperCase/1")
    public Mono<User> convertUserNameToUpperCase(@RequestBody Mono<User> userMono){

        return monoUserService.operateOnUserName(userMono);
    }
}
