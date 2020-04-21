package top.weiyigeek.main;

public class SearchBean {
    private int id;
    private String title;
    
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
    @Override
    public String toString() {
        return "SearchBean [id=" + id + ", title=" + title + "]";
    }
    
    
}
