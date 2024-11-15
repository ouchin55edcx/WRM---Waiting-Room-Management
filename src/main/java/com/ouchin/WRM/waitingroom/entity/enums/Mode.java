package com.ouchin.WRM.waitingroom.entity.enums;

public enum Mode {
    PART_TIME("Part Time"),
    FULL_TIME("Full Time");

    private final String displayName;

    Mode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}