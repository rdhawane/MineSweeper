package com.application.minesweeper.util;

public enum IconEnum {
    ICON_NOT_VISITED(" . "),
    ICON_IS_MARKED_AS_BOMB(" @ "),
    ICON_IS_BOMB(" X ");

    private final String icon;

    IconEnum(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }

}
