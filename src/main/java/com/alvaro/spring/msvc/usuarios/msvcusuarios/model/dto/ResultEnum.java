package com.alvaro.spring.msvc.usuarios.msvcusuarios.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResultEnum {
    OK("OK"),
    DB_ERROR("DB_ERROR"),
    LIST_NOTFOUND("LIST_NOTFOUND");

    private String value;

    ResultEnum(String value) {
        this.value = value;
    }
@JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
