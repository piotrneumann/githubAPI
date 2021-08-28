package com.example.recruitmenttask.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto extends BaseUser {

    private double calculations;

    public UserDto(GitHubUserDataDto gitHubUserData, double calculations) {
        this.setId(gitHubUserData.getId());
        this.setLogin(gitHubUserData.getLogin());
        this.setName(gitHubUserData.getName());
        this.setType(gitHubUserData.getType());
        this.setAvatarUrl(gitHubUserData.getAvatarUrl());
        this.setCreatedAt(gitHubUserData.getCreatedAt());
        this.calculations = calculations;
    }
}
