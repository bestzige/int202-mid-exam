// 65130500073 - Watchara Santawee
package dev.bestzige.int202midexam.models;

import lombok.Getter;

@Getter
public class User {
    private static int idCount = 1;
    private int id;
    private String username;
    private String email;

    public User(String username, String email) {
        this.id = idCount++;
        this.username = username;
        this.email = email;
    }
}
