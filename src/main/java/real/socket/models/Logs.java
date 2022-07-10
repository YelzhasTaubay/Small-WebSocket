package real.socket.models;

public class Logs {
    private String content;
    private String command;


    public Logs() {
    }
    public Logs(String content, String command) {
        this.content = content;
        this.command = command;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
