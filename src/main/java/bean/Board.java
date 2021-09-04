package bean;

/**
 * @author : author
 * @date : 18:24 2021/7/2
 */
public class Board {
    private int id;
    private String title;
    private String group;
    private String content;
    private String detailTime;

    public Board() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(String detailTime) {
        this.detailTime = detailTime;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", group='" + group + '\'' +
                ", content='" + content + '\'' +
                ", detailTime='" + detailTime + '\'' +
                '}';
    }
}
