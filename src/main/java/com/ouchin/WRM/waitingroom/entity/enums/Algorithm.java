package com.ouchin.WRM.waitingroom.entity.enums;

public enum Algorithm {
    FIFO("First In First Out"),
    SJF("Shortest Job First"),
    HPF("Highest Priority First");

    private final String displayName;

    Algorithm(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}