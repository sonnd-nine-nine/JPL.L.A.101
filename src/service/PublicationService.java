package service;

import model.Book;

public interface PublicationService {
    boolean addBook();
    boolean addMagazine();
    void show();
    boolean addAuthor();
//    void showTop10Magazine();
    Book searchBookByIsbn();
    Book searchBookByAuthor();
    Book searchBookByPublisher();
    void searchBook();
}
