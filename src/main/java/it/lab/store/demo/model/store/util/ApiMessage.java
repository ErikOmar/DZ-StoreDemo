package it.lab.store.demo.util;


public class ApiMessage {

    private MessageType messageType;

    private String message;

    public ApiMessage(String message, MessageType messageType){
        this.message = message;
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public enum MessageType {
        Success, Info, Warning, Error
    }

}
