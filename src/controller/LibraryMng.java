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
                    boolean res = publicationService.addBook();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("choose a func");
            }
        }while (choose!=0);
    }
}
