package com.example.recruitmenttask.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@Data
public class GitHubUserDataDto extends BaseUser{

    private int public_repos;
    private int followers;

}
