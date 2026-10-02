package entity;

public class Book extends BaseEntity <Integer>{
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author, boolean available) {
        super(id);

        this.title = title;
        this.author = author;
        this.available = available;
    }

    public Book() {
        super();

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
