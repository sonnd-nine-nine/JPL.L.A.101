package model;

import java.time.LocalDate;
import java.util.Date;

public class Magazine extends Publication{
    private String author;
    private int volume;
    private int edition;

    @Override
    public String toString() {
        return "Magazine{" +
                "author='" + author + '\'' +
                ", volume=" + volume +
                ", edition=" + edition +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Magazine(int publicationYear, String publisher, LocalDate publicationDate, String author, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public Magazine() {
    }
}
