package com.example.recruitmenttask.core;


import com.example.recruitmenttask.model.dto.GitHubUserDataDto;
import com.example.recruitmenttask.model.dto.UserDto;
import com.example.recruitmenttask.user.UserServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class TaskLoader implements ApplicationRunner {

    private final UserServiceImpl userSerive;

    public TaskLoader(UserServiceImpl userSerive) {
        this.userSerive = userSerive;
    }

    @Override
    public void run(ApplicationArguments args) {
//        UserDto piotrneumann = userSerive.getUserDto("octocat");
//        piotrneumann.getCalculations();
    }
}
