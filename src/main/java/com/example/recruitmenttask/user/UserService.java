package com.example.recruitmenttask.user;

import com.example.recruitmenttask.model.dto.GitHubUserDataDto;
import com.example.recruitmenttask.model.dto.UserDto;

public interface UserService {

    GitHubUserDataDto getGitHubUserData(String login);

    UserDto getUserDto(String login);

    void addRequestCount(String login);
}
