package service;

import model.Book;
import model.Magazine;
import model.Publication;
import util.Validator;
import view.Menu;

import java.util.*;

public class PublicationServiceImp implements PublicationService{
    private List<Publication> publications = new ArrayList<>();
    @Override
    public boolean addBook() {
        Book book = Menu.getInstance().AddBook();
        publications.add(book);
        return true;
    }

    @Override
    public boolean addMagazine() {
        Magazine magazine = Menu.getInstance().addMagazine();
        publications.add(magazine);
        return true;
    }

    @Override
    public void show() {
        Menu.getInstance().showList();
        publications.forEach(System.out::println);
    }

    @Override
    public boolean addAuthor() {
        Book book = searchBookByIsbn();
        book = Menu.getInstance().addAuthor(book);
        return true;
    }

//    @Override
//    public void showTop10Magazine() {
//        for (Publication i: publications){
//            Magazine magazine = (Magazine) i;
//            Collections.sort((Magazine)i, new Comparator<Magazine>() {
//                @Override
//                public int compare(Magazine o1, Magazine o2) {
//                    if (o1.getVolume() < o2.getVolume()) return 1;
//                    return 0;
//                }
//            });
//        }
//    }

    @Override
    public Book searchBookByIsbn() {
        String isbn = Menu.getInstance().searchBookByIsbn();
//        String isbn = Validator.getInstance().validateString();
        for (Publication p:publications){
            if (p instanceof Book){
                if(((Book) p).getIsbn().equals(isbn)){
                    return (Book) p;
                }
            }
        }
        return null;
    }

    @Override
    public Book searchBookByAuthor() {
        String author = Menu.getInstance().searchBookByAuthor();
//        String author = Validator.getInstance().validateString();
        for (Publication p:publications){
            if (p instanceof Book){
                Set<String> authors = ((Book) p).getAuthor();
                for(String s: authors){
                    if (s.equals(author))
                        return (Book) p;
                }
            }
        }
        return null;
    }

    @Override
    public Book searchBookByPublisher() {
//        String publisher = Validator.getInstance().validateString();
        String publisher = Menu.getInstance().searchBookByPublisher();
        for (Publication p:publications){
            if (p instanceof Book){
                if (p.getPublisher().equals(publisher))
                    return (Book) p;
            }
        }
        return null;
    }

    @Override
    public void searchBook() {
        int choose = Menu.getInstance().menuSearchBook();
        switch (choose){
            case 1:
//                String isbn = Menu.getInstance().searchBookByIsbn();
                System.out.println(searchBookByIsbn());
                break;
            case 2:
                System.out.println(searchBookByAuthor());
                break;
            case 3:
                System.out.println(searchBookByPublisher());
                break;
            default:
                System.out.println("must choose one func!!");
        }
    }
}
