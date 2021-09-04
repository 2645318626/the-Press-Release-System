package bean;

/**
 * @author : author
 * @date : 13:08 2021/6/24
 */
public class News {
    private int id;
    private String title;
    //    private String category; //类别
    private String content;
    private String author;
    private String getDate;
    private String imgPath = "images/default.(jpg,png,bmp,gif)";
    private String publisher;
//    private categoryEnum type;
    private String keyWords;
    private String type;

//    public static class categoryEnum {
//        private int sid;
//        private String category;
//
//        public categoryEnum() {
//        }
//
//        public categoryEnum(int sid, String category) {
//            this.sid = sid;
//            this.category = category;
//        }
//
//        public int getSid() {
//            return sid;
//        }
//
//        public void setSid(int sid) {
//            this.sid = sid;
//        }
//
//        public String getCategory() {
//            return category;
//        }
//
//        public void setCategory(String category) {
//            this.category = category;
//        }
//    }

    public News() {
    }

    public News(String title, String content, String author, String getDate, String imgPath, String publisher, String keyWords, String type) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.getDate = getDate;
        this.imgPath = imgPath;
        this.publisher = publisher;
        this.keyWords = keyWords;
        this.type = type;
    }

//    public categoryEnum getType() {
//        return type;
//    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

//    public void setType(categoryEnum type) {
//        this.type=type;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        // 要求给定的图书封面图书路径不能为空
        if (imgPath != null && !"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "News{" +
                "title=" + title +
//                ",type =" + type.getCategory() +
                ",content =" + content +
                ",author =" + author +
                ",getDate =" + getDate +
                ",publisher =" + publisher +
                ",imgPath =" + imgPath + "}";

    }
}
