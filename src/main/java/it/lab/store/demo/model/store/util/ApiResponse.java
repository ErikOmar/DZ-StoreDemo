package it.lab.store.demo.model.store.util;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse<T> {

    private T element;
    private boolean hasError;
    private boolean hasWarning;
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

    public boolean getHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    public List<ApiMessage> getListMessages() {
        return listMessages;
    }

    public void setListMessages(List<ApiMessage> listMessages) {
        this.listMessages = listMessages;
    }

    public void addMessage(ApiMessage.MessageType messageType, String message){
        if (listMessages == null){
            listMessages = new ArrayList<>();
        }
        if(messageType == ApiMessage.MessageType.Error){
            hasError = true;
        }

        if(messageType == ApiMessage.MessageType.Warning){
            hasWarning = true;
        }

        listMessages.add(new ApiMessage(message, messageType));
    }
}
