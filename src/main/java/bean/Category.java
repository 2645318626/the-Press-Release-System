package bean;

/**
 * @author : author
 * @date : 22:18 2021/7/1
 */
public class Category {
    private int sid;
    private String type;

    public Category() {
    }

    public Category(int sid, String type) {
        this.sid = sid;
        this.type = type;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "sid=" + sid +
                ", type='" + type + '\'' +
                '}';
    }
}
