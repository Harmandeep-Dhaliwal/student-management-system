package app;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.service.StdMng;
@SpringBootApplication
public class SMA {
    public static void main(String[] args) {
        SpringApplication.run(SMA.class, args);
        /**
        int choice = 0;
        StdMng obj = new StdMng();
        Scanner scn = new Scanner(System.in);
        while(true) {
            System.out.printf("\nHello and welcome!\n" +
                    "What would you like to do today?\n" +
                    "1. Add Student ID\n" +
                    "2. Delete Student ID\n" +
                    "3. Edit Student Info\n" +
                    "4. Search\n" +
                    "5. Display All\n" +
                    "6. Exit\n" +
                    "\n Enter : ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    obj.addStd();
                    break;
                case 2:
                    obj.dltStd();
                    break;
                case 3:
                    obj.edtStd();
                    break;
                case 4:
                    obj.srchStd();
                    break;
                case 5:
                    obj.displayAll();
                    break;
                case 6:
                    obj.exit();
                    return;
                default:
                    System.out.printf("\nPlease enter correct choice");
            }
        }

        */
    }
}