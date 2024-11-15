package com.ouchin.WRM.waitingroom.entity.enums;


public enum Status {
    WAITING("Waiting"),
    IN_PROGRESS("In Progress"),
    FINISHED("Finished"),
    CANCELED("Canceled");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
