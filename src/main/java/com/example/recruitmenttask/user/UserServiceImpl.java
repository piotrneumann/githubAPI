package com.example.recruitmenttask.user;

import com.example.recruitmenttask.model.ApiRequestCount;
import com.example.recruitmenttask.model.dto.GitHubUserDataDto;
import com.example.recruitmenttask.model.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final String uri = "https://api.github.com/users/%s";
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);
    private final ApiRequestCountRepository apiRequestCountRepository;

    public UserServiceImpl(ApiRequestCountRepository apiRequestCountRepository) {
        this.apiRequestCountRepository = apiRequestCountRepository;
    }

    @Override
    public GitHubUserDataDto getGitHubUserData(String login) {
        WebClient client = WebClient.create();
        GitHubUserDataDto user = client.get()
                .uri(String.format(uri, login))
                .retrieve()
                .bodyToMono(GitHubUserDataDto.class)
                .onErrorResume(WebClientResponseException.NotFound.class, notFound -> Mono.empty())
                .onErrorResume(notFound -> Mono.empty())
                .block(REQUEST_TIMEOUT);
        if (user == null) throw new RuntimeException("User " + login + " not found");
        return user;
    }

    @Override
    public UserDto getUserDto(String login) {
        addRequestCount(login);
        GitHubUserDataDto gitHubUserData = getGitHubUserData(login);
        double calculations = 6 / (double) gitHubUserData.getFollowers() * (double) (2 + gitHubUserData.getPublic_repos());
        return new UserDto(gitHubUserData, calculations);
    }

    @Override
    public void addRequestCount(String login) {
        Optional<ApiRequestCount> apiRequestCountsByLogin = this.apiRequestCountRepository.findApiRequestCountsByLogin(login);
        if (apiRequestCountsByLogin.isPresent()) {
            ApiRequestCount apiRequestCount = apiRequestCountsByLogin.get();
            int requestCount = apiRequestCount.getRequestCount() + 1;
            apiRequestCount.setRequestCount(requestCount);
            this.apiRequestCountRepository.save(apiRequestCount);
        } else {
            this.apiRequestCountRepository.save(new ApiRequestCount(login, 1));
        }
    }
}
