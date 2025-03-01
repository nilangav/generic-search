package org.example.search.enum

enum class FilterType(
    val value: String,
) {
    EQUALS("equals"),
    NOT_EQUALS("notEqual"),
    GREATER_THAN("greaterThan"),
    GREATER_THAN_OR_EQUALS("greaterThanOrEquals"),
    LESS_THAN("lessThan"),
    LESS_THAN_OR_EQUALS("lessThanOrEquals"),
    IN_RANGE("inRange"),
    BLANK("blank"),
    NOT_BLANK("notBlank"),
}
