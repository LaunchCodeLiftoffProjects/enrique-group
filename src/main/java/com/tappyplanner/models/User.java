package com.tappyplanner.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Task> userTasks = new ArrayList<>();

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    public User() {

    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User (String username, String password) {

        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
