package com.example.connectUserToUser.domain;
// DTO
public class MatchUserPair {
    private User left;
    private User right;
    private String roomId;

    public MatchUserPair(User left, User right, String roomId) {
        this.left = left;
        this.right = right;
        this.roomId = roomId;
    }
}
