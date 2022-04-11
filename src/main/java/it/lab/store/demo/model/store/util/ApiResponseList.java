package it.lab.store.demo.model.store.util;

import java.util.ArrayList;
import java.util.List;

public class ApiResponseList<T> {

    private List<T> list;
    private boolean hasError;
    private boolean hasWarning;
    private List<ApiMessage> listMessages;

    public ApiResponseList() {
        listMessages = new ArrayList<>();
        hasError = false;
    }

    public ApiResponseList(List<T> list) {
        this.list = list;
        hasError = false;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
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
        if(listMessages == null){
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
