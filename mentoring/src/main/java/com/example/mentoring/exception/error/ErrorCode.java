package com.example.mentoring.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(400, "Bad Request(Invalid Parameter)"),
    INVALID_AUTH_EMAIL(400,"Invalid Auth Email"),
    INVALID_AUTH_CODE(400,"Invalid Auth Code"),
    USER_NOT_SAME(400, "User Not Same"),

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    UNAUTHORIZED(401, "Authentication is required and has failed or has not yet been provided."),

    USER_NOT_FOUND(404, "User Not Found"),
    POST_NOT_FOUND(404, "Post Not Found"),
    CHAT_NOT_FOUND(404, "Chat Not Found"),
    MESSAGE_NOT_FOUND(404, "Message Not Found"),
    BUY_LIST_NOT_FOUND(404, "BuyList Not Found"),

    PASSWORD_SAME(409, "Password Same Before"),
    USER_DUPLICATION(409, "User is Already Exists"),
    USER_NICKNAME_DUPLICATION(409, "User NickName is Already Exists"),
    USER_PHONE_NUMBER_DUPLICATION(409, "User PhoneNumber is Already Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}