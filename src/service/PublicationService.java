package service;

import controller.LibraryMng;
import model.Book;
import model.Magazine;

import java.util.List;

public interface PublicationService {
    boolean addBook();
    boolean addMagazine();
    void show();
    boolean addAuthor();
    void showTop10Magazine();
    Book searchBookByIsbn();
    Book searchBookByAuthor();
    Book searchBookByPublisher();
    void searchBook();
    Magazine sortMagazine(List<Magazine> magazine);
}
