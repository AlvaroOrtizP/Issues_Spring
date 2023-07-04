package com.alvaro.spring.msvc.usuarios.msvcusuarios.exception;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.dto.ResultEnum;

public class PersoException extends Exception{
    private static final long serialVersionUID = 1L;

    private ResultEnum result;

    public PersoException(Exception cause){
        this(ResultEnum.DB_ERROR, "Error predeterminado", cause);
    }

    public PersoException(ResultEnum result, String message, Exception cause) {
        super(message);
        this.result = result;
    }

    public ResultEnum getResult(){
        return result;
    }
}
