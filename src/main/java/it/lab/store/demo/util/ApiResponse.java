package it.lab.store.demo.util;


import java.util.ArrayList;
import java.util.List;

public class ApiResponse<T> {

    private T element;
    private boolean hasError;
    private List<ApiMessage> listMessages;

    public ApiResponse() {
        listMessages = new ArrayList<>();
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean getHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<ApiMessage> getListMessages() {
        return listMessages;
    }

    public void setListMessages(List<ApiMessage> listMessages) {
        this.listMessages = listMessages;
    }

    public void addMessage(ApiMessage.MessageType messageType, String message){
        if(messageType == ApiMessage.MessageType.Error){
            hasError = true;
        }

        listMessages.add(new ApiMessage(message, messageType));
    }
}
