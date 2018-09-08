package pl.coderslab.model;

public class Excersise {
    private int id;
    private String title;
    private String description;

    public Excersise(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Excersise(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void loadAll() {

    }

    public void loadById(int id) {

    }

    public void delete(int id) {

    }

    public void saveToDB(String title, String description) {

    }
}
