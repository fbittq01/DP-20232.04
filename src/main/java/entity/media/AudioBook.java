package entity.media;

import java.sql.SQLException;
import java.util.Date;

public class AudioBook extends Media {

    String author;
    String format;
    String language;
    Date accent;
    int lengthInMinutes;

    public AudioBook() throws SQLException{

    }

    public AudioBook(int id, String title, String category, int price, int quantity, String type, String author,
                     String format, String language, Date accent, int lengthInMinutes) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.format = format;
        this.language = language;
        this.accent = accent;
        this.lengthInMinutes = lengthInMinutes;
    }

    // getter and setter
    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public AudioBook setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public AudioBook setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public AudioBook setLanguage(String language) {
        this.language = language;
        return this;
    }

    public Date getAccent() {
        return this.accent;
    }

    public AudioBook setAccent(Date accent) {
        this.accent = accent;
        return this;
    }

    public int getLengthInMinutes() {
        return this.lengthInMinutes;
    }

    public AudioBook setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
        return this;
    }


    @Override
    public String toString() {
        String basicInformation = "{" +
                " id='" + id + "'" +
                ", title='" + title + "'" +
                ", category='" + category + "'" +
                ", price='" + price + "'" +
                ", quantity='" + quantity + "'" +
                ", type='" + type + "'" +
                ", imageURL='" + imageURL + "'" +
                "}";
        return "{" +
                basicInformation +
                " author='" + author + "'" +
                ", coverType='" + coverType + "'" +
                ", publisher='" + publisher + "'" +
                ", publishDate='" + publishDate + "'" +
                ", numOfPages='" + numOfPages + "'" +
                ", language='" + language + "'" +
                ", bookCategory='" + bookCategory + "'" +
                "}";
    }
}