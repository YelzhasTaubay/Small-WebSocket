package real.socket.service;

import real.socket.models.Logs;

import java.util.List;


public class GreeterService {
    private String content;
    private List<Logs> contentList;

    public GreeterService() {
    }

    public GreeterService(String content) {
        this.content = content;
    }

    public GreeterService(String content, List<Logs> contentList) {
        this.content = content;
        this.contentList=contentList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Logs> getContentList() {
        return contentList;
    }

    public void setContentList(List<Logs> contentList) {
        this.contentList = contentList;
    }
}
