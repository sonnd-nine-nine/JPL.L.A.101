package controller;

import service.PublicationService;
import service.PublicationServiceImp;
import view.Menu;

public class LibraryMng {
    private static PublicationService publicationService = new PublicationServiceImp();

    public static void main(String[] args) {
        int choose;
        do {
            choose = Menu.getInstance().Menu();
            switch (choose){
                case 0:
                    return;
                case 1:
                    boolean resBook = publicationService.addBook();
                    System.out.println("Add book " + (resBook ? "success" : "fail, again!"));
                    break;
                case 2:
                    boolean resMagazine = publicationService.addMagazine();
                    System.out.println("Add Magazine " + (resMagazine ? "success" : "fail, again"));
                    break;
                case 3:
                    publicationService.show();
                    break;
                case 4:
                    publicationService.addAuthor();
                    break;
                case 5:
                    break;
                case 6:
                    publicationService.searchBook();
                    break;
                default:
                    System.out.println("choose a func");
            }
        }while (choose!=0);
    }
}
