package com.hu.algs.pets;

import java.util.*;

/**
 * 一个可以放进 Cat 和 Dog 的队列
 * 新增一个 PetInfo 类，包含 Pet对象和 类似时间戳的cnt
 */
public class PetQueue {
    private Queue<PetInfo> dogQueue;
    private Queue<PetInfo> catQueue;
    private int cnt;

    public PetQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        cnt = 0;
    }

    public void add(Pet pet) {
        PetInfo petInfo = new PetInfo(pet, cnt++);
        if (pet.getPetType().equals("dog"))
            dogQueue.add(petInfo);
        else
            catQueue.add(petInfo);
    }

    public boolean isEmpty() {
        return (dogQueue.isEmpty() && catQueue.isEmpty());
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return  catQueue.isEmpty();
    }

    public Pet poll() {
        if (isEmpty())
            return null;
        if (isCatEmpty()){
            PetInfo petInfo = dogQueue.poll();
            return petInfo.getPet();
        }else if (isDogEmpty()){
            PetInfo petInfo = catQueue.poll();
            return petInfo.getPet();
        }else {
            PetInfo petInfo;
            if (dogQueue.peek().getCnt() < catQueue.peek().getCnt())
                petInfo = dogQueue.poll();
            else petInfo = catQueue.poll();
            return petInfo.getPet();
        }
    }

    public Dog pollDog(){
        if (isDogEmpty())
            throw new RuntimeException("no dog!");
        return (Dog)(dogQueue.poll().getPet());
    }

    public Cat pollCat(){
        if (isCatEmpty())
            throw new RuntimeException("no Cat!");
        return (Cat)(catQueue.poll().getPet());
    }


}
