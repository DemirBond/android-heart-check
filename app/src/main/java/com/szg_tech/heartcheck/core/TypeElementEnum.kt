package com.szg_tech.heartcheck.core

enum class TypeElementEnum(enum: Int) {
    BOOLEAN(0),
    STRING(1),
    NUMERICAL(2),
    SECTION(3),
    RADIO_BUTTON_GROUP(4),
    SECTION_PLACE_HOLDER(5),
    BOLD(6),
    MINUTES_SECONDS(7),
    SECTION_CHECKBOX(8),
    NUMERICAL_DEPENDANT(9),
    EMPTY_CELL(10),
    DATE_PICKER(11),
    TEXT(12),
    UNKNOWN(-1)
}