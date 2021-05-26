package sample;

import javafx.application.Application;

import java.io.IOException;
import java.util.Scanner;


public class Console{
    private static MyGymManager console = new MyGymManager();
    public static void main(String[] args) throws IOException {
        //Asking the user for to input choice.
        String FirstUserChoice="";
        Scanner sc = new Scanner(System.in);
        String CorrectInput = "0";
        //Validate user input
        while (CorrectInput != "1"){
            System.out.print(" Enter '1' to add Member(s)\n" +
                    " Enter '2' to Remove Member(s)\n" +
                    " Enter '3' to Sort Member's list\n" +
                    " Enter '4' to save into file\n(DISCLAIMER: All files will have to be saved before Removing/sorting or printing)\n" +
                    " Enter '5 to print List\n" +
                    " Enter '6 to to open Gui\n" +
                    " Enter here: ");
            FirstUserChoice = sc.nextLine();

            if(FirstUserChoice.equals("1")||FirstUserChoice.equals("2")||FirstUserChoice.equals("3")||FirstUserChoice.equals("4")||FirstUserChoice.equals("5")||FirstUserChoice.equals("6")){
                CorrectInput="1";
                System.out.println("--------------------------------");
            }else{
                System.out.println("Invalid input, try again...");
                System.out.println("--------------------------------");
            }
        }
            //Switch case to open respective classes depending on the choice
            switch(FirstUserChoice) {
                case "1":
                    console.AddMember(FirstUserChoice);
                    break;
                case "2":
                    console.DeleteMember();
                    break;
                case "3":
                    console.SortList();
                    break;
                case "4":
                    console.SaveToFile();
                    break;
                case "5":
                    console.PrintList();
                    break;
                case "6":
                    Application.launch(Gui.class,args);
                    main(null);
                    break;
            }
    }

}





