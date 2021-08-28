package com.example.recruitmenttask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ApiRequestCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    public ApiRequestCount(String login, int requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }
}
