package view;

import model.Book;
import model.Magazine;
import model.Publication;
import util.Validator;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class Menu {
    private static Menu instance;
    public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }
    public int Menu(){
        System.out.println("Library Mng...\n" +
                "1. Add book\n" +
                "2. Add magazine\n" +
                "3. Display all\n" +
                "4. Add author book\n" +
                "5. Display top 10 of magazines by volume\n" +
                "6. Search book by isbn, author, publisher\n" +
                "0. Out app.\n" +
                "You must choose one func..");
        return Validator.getInstance().validateInt();
    }

    public Publication addPublication(){
        System.out.print("Publisher: ");
        String publisher = Validator.getInstance().validateString();
        System.out.print("Publication Date: ");
        LocalDate pubDate = null;
        try{
            pubDate = Validator.getInstance().validateDate();
        }catch (ParseException e){
            System.out.println(e);
        }
        int pubYear = pubDate.getYear();
        return new Publication(pubYear, publisher, pubDate);
    }

    public Book AddBook(){
        System.out.printf("Add book info");
        System.out.print("Isbn: ");
        String isbn = Validator.getInstance().validateIsbn();
        System.out.print("Author: ");
        Set<String> authors = Validator.getInstance().validateAuthor();
        System.out.print("Publication place: ");
        String pubPlace = Validator.getInstance().validateString();
        Publication publication = Menu.getInstance().addPublication();
        return new Book( publication.getPublicationYear(),
                publication.getPublisher(), publication.getPublicationDate(),isbn, authors, pubPlace);
    }

    public Magazine addMagazine(){
        System.out.println("Add Magazine info");
        System.out.print("Author: ");
        String author = Validator.getInstance().validateString();
        System.out.print("Volume: ");
        int volume = Validator.getInstance().validateInt();
        System.out.print("Edition: ");
        int edition  =Validator.getInstance().validateInt();
        Publication publication = Menu.getInstance().addPublication();
        return new Magazine(publication.getPublicationYear(), publication.getPublisher(),
                publication.getPublicationDate(), author, volume,edition);
    }

    public void showList(){
        System.out.println("Library..........");
    }

    public String searchBookByIsbn(){
        System.out.println("Enter Isbn book");
        return Validator.getInstance().validateIsbn();
    }

    public String searchBookByAuthor(){
        System.out.println("Enter author book");
        return Validator.getInstance().validateString();
    }

    public String searchBookByPublisher(){
        System.out.println("Enter Publisher book");
        return Validator.getInstance().validateString();
    }

    public Book addAuthor(Book book){
        System.out.println("Add new author");
        String author = Validator.getInstance().validateString();
        Set<String> authors = book.getAuthor();
        for(String s:authors){
            if(s.equals(author)){
                System.out.println("Author exist");
                return book;
            }
        }
        authors.add(author);
        return book;
    }

    public void showTop10Magazine(){

    }
}