package at.htl.mydate;
import  at.htl.mydate.MyDate;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "";
        MyDate datumJung = new MyDate("0.0.0");
        MyDate datum;
        int counter = 1;
        Boolean younger;
        System.out.println("Date-Manager");
        System.out.println("============");
        System.out.println();


        for (int i = 1; !input.equals("quit"); i++) {
            System.out.print(i +". Datum: ");
            input = scanner.nextLine();
            if(!input.equals("quit")){
               datum = new MyDate(input);
               if (counter == 1){
                   datumJung = datum;
                   counter ++;
               }else {
                   if (datum.isYoungerThan(datumJung)){
                       datumJung = datum;
                   }
               }
                System.out.println("Jüngstes Datum: "+datumJung.formatDate(input));
            }
        }
        // not yet implemented

    }
}
