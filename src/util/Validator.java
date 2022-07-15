package util;

import model.Magazine;
import model.Publication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class Validator {
    private static Validator instance;
    private static Scanner scanner = new Scanner(System.in);
    public static Validator getInstance(){
        if(instance == null){
            instance = new Validator();
        }
        return instance;
    }

    public String validateIsbn(){
        String isbn = scanner.nextLine();
        String regex = "^\\-[0-9\\-]+$";
        if (isbn.matches(regex) && isbn.length()>9 && isbn.length()<18){
            System.out.println(isbn);
            return isbn;
        }
        System.out.println("You can enter [0-9] and '-' (ex: 123-3-21-1234) and len=[10-17]");
        return validateIsbn();
    }

    public int validateInt(){
        if(scanner.hasNextInt()){
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        }
        System.out.println("Int type please!!");
        return validateInt();
    }

    public String validateString(){
        return scanner.nextLine();
    }
    public LocalDate validateDate() throws ParseException {
        System.out.println("Enter date format dd/mm/yyyy");
        LocalDate date = null;
        String inputDate = Validator.getInstance().validateString();
        try {
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(inputDate, dt);
            System.out.println(date);
            return date;
        }catch (DateTimeParseException e){
        }
        return validateDate();
    }

    public Set<String> validateAuthor(){
        Set<String> authors = new HashSet<String>();
        String check = "";
        do {
//            System.out.print("Author:");
            authors.add(Validator.getInstance().validateString());
            System.out.print("Continue (Y):");
            check = Validator.getInstance().validateString();
        }while (check.equals("Y"));
        return authors;
    }

    public List<Magazine> getListMagazine(List<Publication> publications){
        List<Magazine> magazines = new ArrayList<>();
        for (Publication i: publications){
            if (i instanceof Magazine){
                magazines.add((Magazine) i);
            }
        }
        return magazines;
    }
}
