package app;
import java.io.*;
import java.util.Scanner;
import service.StdMng;

public class Main {
    public static void main(String[] args) {

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
                    "5. Exit\n" +
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
                    obj.exit();
                    return;
                default:
                    System.out.printf("\nPlease enter correct choice");
            }
        }


    }
}