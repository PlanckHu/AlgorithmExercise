package com.hu.algs.pets;

public class PetInfo {
    private Pet pet;
    private int cnt;

    public PetInfo(Pet pet, int cnt) {
        this.pet = pet;
        this.cnt = cnt;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCnt() {
        return cnt;
    }
}
