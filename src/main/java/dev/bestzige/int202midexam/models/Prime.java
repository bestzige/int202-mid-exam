package dev.bestzige.int202midexam.models;

import lombok.Getter;

@Getter
public class Prime {
    private static int idCount = 1;

    private int id;
    private int number;
    private boolean isPrime;

    public Prime(int number, boolean isPrime) {
        this.id = idCount++;
        this.number = number;
        this.isPrime = isPrime;
    }
}
