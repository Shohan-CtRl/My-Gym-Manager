package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MyGymManager implements GymManager{
    //Creates list to store all object type including DefaultMember,StudentMember and Over60Member
    public static DefaultMember[] theList = new DefaultMember[100];
    private static int i = 0;




    //List to add Default members to list
    public  void add(DefaultMember d){
        if(i < theList.length ){
            theList[i]=d;
            System.out.println("Member added at index "+i);
            i++;
        }else{
            System.out.println("List has 100 Members. Maximum capacity. ");
        }
    }
    //List to add Student members to list
    public  void add2(StudentMember a){
        if(i < theList.length ){
            theList[i]=a;
            System.out.println("Member added at index "+i);
            i++;
        }else{
            System.out.println("List has 100 Members. Maximum capacity. ");
        }
    }
    //List to add Over 60 members to list
    public  void add3(Over60Member b){
        if(i < theList.length ){
            theList[i]=b;
            System.out.println("Member added at index "+i);
            i++;
        }else{
            System.out.println("List has 100 Members. Maximum capacity. ");
        }
    }

    public  void AddMember(String FirstUserChoice) throws IOException {
        MyGymManager MemberListObject = null;
        String UserChoice="";
        //Imports data from the file into the array before adding new values to array.
        FileInputStream fis = new FileInputStream("BinaryFile.txt");
        ObjectInputStream ois1 = new ObjectInputStream(fis);
        boolean CreatingList = true;

        while (CreatingList == true){
            try {
                DefaultMember TempObject2 = ((DefaultMember) ois1.readObject());
                if (TempObject2 != null) {


                    if (i < theList.length ) {
                        theList[i] = TempObject2;
                        System.out.println("Member added at index " + i);
                        i++;
                    }
                }
                if(TempObject2 == null){
                    CreatingList = false;
                }
            }catch (EOFException e){
                System.out.println("Completed reading object");
                break;
            }catch (ClassNotFoundException e){
                System.out.println("File not found...");
            }
        }

        //User friendly prompts for input data type
        for (String UserResponse="y";UserResponse.equals("y");) {
            Scanner sc = new Scanner(System.in);
            String CorrectInput = "0";
            //Validate user input
            while (CorrectInput != "1") {
                System.out.print(" Enter '1' to add Adults Member\n" +
                        " Enter '2' to add Student Member\n" +
                        " Enter '3' to add Elderly Member\n " +
                        "Enter here:  ");
                UserChoice = sc.nextLine();
                MemberListObject = new MyGymManager();
                if (UserChoice.equals("1") || UserChoice.equals("2") || UserChoice.equals("3")) {
                    CorrectInput = "1";
                    System.out.println("--------------------------------");
                } else {
                    System.out.println("Invalid input, try again...");
                    System.out.println("--------------------------------");
                }
            }
            //Respective input prompts depending on the member type.
            //Default type.
            if (UserChoice.equals("1")) {
                //Getting user Inputs
                String NewMemberId = null;
                String NewMemberName = null;
                String NewStartMembershipDate = null;
                String NewMembershipType=null;
                DefaultMember DefObj = new DefaultMember(NewMemberId, NewMemberName, NewStartMembershipDate, NewMembershipType);
                System.out.print("Member Number: ");
                NewMemberId = sc.next();
                System.out.print("Member Name: ");
                NewMemberName = sc.next();
                System.out.print("Date [dd/mm/yyyy]: ");
                NewStartMembershipDate = sc.next();

                // Setting to default object
                DefObj.setMembershipNumber(NewMemberId);
                DefObj.setName(NewMemberName);
                DefObj.setStartMembershipDate(NewStartMembershipDate);
                //Type 1 represents Defualt member
                DefObj.setMembershipType("Type1");
                //Object is added to list(theList[x])
                MemberListObject.add(DefObj);



            }else if (UserChoice.equals("2")) {

                String NewMemberId = null;
                String NewMemberName = null;
                String NewStartMembershipDate = null;
                String NewSchoolName = null;
                String NewMembershipType= null;
                StudentMember StuObj = new StudentMember(NewMemberId, NewMemberName, NewStartMembershipDate, NewSchoolName,NewMembershipType);
                //Asking for user inputs
                System.out.print("Member Number: ");
                NewMemberId = sc.next();
                System.out.print("Member Name: ");
                NewMemberName = sc.next();
                System.out.print("Date [dd/mm/yyyy]: ");
                NewStartMembershipDate = sc.next();
                System.out.print("School name: ");
                NewSchoolName = sc.next();
                //setting to Student  object type.
                StuObj.setMembershipNumber(NewMemberId);
                StuObj.setName(NewMemberName);
                StuObj.setStartMembershipDate(NewStartMembershipDate);
                StuObj.setSchoolName(NewSchoolName);
                StuObj.setMembershipType("Type2");
                //Adding object to list(theList[x])
                MemberListObject.add2(StuObj);

            }else if (UserChoice.equals("3")) {

                String NewMemberId = null;
                String NewMemberName = null;
                String NewStartMembershipDate = null;
                int NewAge=0;
                String NewMembershipType= null;
                Over60Member Over60Obj = new Over60Member(NewMemberId, NewMemberName, NewStartMembershipDate, NewMembershipType, NewAge);
                //Asking for user friendly prompts
                String CorrectAge="0";
                while(CorrectAge=="0") {
                    System.out.print("Member Number: ");
                    NewMemberId = sc.next();
                    System.out.print("Member Name: ");
                    NewMemberName = sc.next();
                    System.out.print("Date [dd/mm/yyyy]: ");
                    NewStartMembershipDate = sc.next();
                    try {
                        System.out.print("Member Age: ");
                        NewAge = sc.nextInt();
                        if (NewAge > 59) {
                            CorrectAge = "1";
                            System.out.println("--------------------------------");
                        } else {
                            System.out.println("Invalid Age, has to be 60 or above...");
                            System.out.println("--------------------------------");
                        }
                    }catch (Exception e){
                        System.out.println("Age: Integer required");
                    }
                }



                //Setting to Over 60 objects
                Over60Obj.setMembershipNumber(NewMemberId);
                Over60Obj.setName(NewMemberName);
                Over60Obj.setStartMembershipDate(NewStartMembershipDate);
                Over60Obj.setAge(NewAge);
                Over60Obj.setMembershipType("Type3");
                //Adding object to the list(theList[x])
                MemberListObject.add3(Over60Obj);
            }
            for(String ValidResponse="false";ValidResponse.equals("false");) {
                //User friendly prompts of repeated inputs.
                System.out.print("Do you want to enter anymore members?[y: yes/n: no ] ");
                UserResponse = sc.next();
                UserResponse = UserResponse.toLowerCase();
                if(UserResponse.equals("n") || UserResponse.equals("y")){
                    ValidResponse="true";
                }else{
                    System.out.print("Enter valid Response! 'n'or'y' ");
                    ValidResponse="false";
                }
            }
        }

        Console.main(null);

    }
    public  void DeleteMember() throws IOException {
        i = 0;
        //Imports values from file for deletion.
        FileInputStream fis = new FileInputStream("BinaryFile.txt");
        ObjectInputStream ois1 = new ObjectInputStream(fis);
        boolean CreatingList = true;
        //Overrides  'theList[]' with values from file.( Data will have to be saved to file before it can be deleted.)
        while (CreatingList == true){
            try {
                DefaultMember TempObject2 = ((DefaultMember) ois1.readObject());
                if (TempObject2 != null) {


                    if (i < theList.length ) {
                        theList[i] = TempObject2;
                        System.out.println("Member added at index " + i);
                        i++;
                    }
                }
                if(TempObject2 == null){
                    CreatingList = false;
                }
            }catch (EOFException e){
                System.out.println("Completed reading object");
                break;
            }catch (ClassNotFoundException e){
                System.out.println("File not found...");
            }
        }

            Scanner sc = new Scanner(System.in);
            int Countx = 0;
            System.out.print("What member do you want to remove?\n Enter the membership number: ");
            String DeleteItem = sc.next();
            //Searching for delete item.
            for (Countx = 0; Countx <= i; Countx++) {

                if (theList[Countx].getMembershipNumber().equals(DeleteItem)) {

                    int TempCount;
                    //rearranging list to remove delete item.
                    String Temp2 = theList[Countx].getMembershipType();
                    for (TempCount = Countx; TempCount < i; TempCount++) {
                        theList[TempCount] = theList[TempCount + 1];
                    }
                    theList[TempCount] = null;
                    //Minuses 1 from 'i'count used in theList[]
                    i--;

                    switch (Temp2) {
                        case "Type1":
                            System.out.println("Default member removed.");
                            break;
                        case "Type2":
                            System.out.println("Student member removed.");
                            break;
                        case "Type3":
                            System.out.println("Over 60 member removed.");
                            break;
                    }

                    int Length = theList.length;
                    int value = TempCount - 1;
                    int space = Length - value;
                    System.out.println("This is how much space you have left: " + space);
                    System.out.println("--------------------------------");
                    break;
                }

            }
            Console.main(null);
        }

    public  void SortList() throws IOException {
        //Overrides theList[] with values from the file.
        FileInputStream fis = new FileInputStream("BinaryFile.txt");
        ObjectInputStream ois1 = new ObjectInputStream(fis);
        boolean CreatingList = true;

        while (CreatingList == true){
            try {
                DefaultMember TempObject2 = ((DefaultMember) ois1.readObject());
                if (TempObject2 != null) {


                    if (i < theList.length ) {
                        theList[i] = TempObject2;
                        System.out.println("Member added at index " + i);
                        i++;
                    }
                }
                if(TempObject2 == null){
                    CreatingList = false;
                }
            }catch (EOFException e){
                System.out.println("Completed reading object");
                break;
            }catch (ClassNotFoundException e){
                System.out.println("File not found...");
            }
        }
        // Searching and rearranging list.
        int n=i-2;
        DefaultMember temp;
        String NoMoreSwaps = "false";
        while(NoMoreSwaps == "false"){
            NoMoreSwaps = "true";
            for(int x=0;x<=n;x++){
                if(theList[x].getMemberName().compareTo(theList[x+1].getMemberName())>0){
                    temp = theList[x];
                    theList[x] = theList[x+1];
                    theList[x+1] = temp;
                    NoMoreSwaps = "false";
                }
            }
            n=n-1;

        }
        Console.main(null);
    }


    public  void PrintList() throws IOException {
        //Overrides list with data values from the file.
        FileInputStream fis = new FileInputStream("BinaryFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        DefaultMember TempObject = null;
        while (true) {
            try {
                TempObject = ((DefaultMember) ois.readObject());
                while (TempObject != null) {
                    //Gets the type of object from object
                    String Temp = TempObject.getMembershipType();
                    //Type 1 is default member
                    if (Temp.equals("Type1")) {
                        DefaultMember obj;
                        obj = TempObject;
                        System.out.println("---------------Next--------- ");
                        System.out.println("Number(ID) of the member is: " + obj.getMembershipNumber());
                        System.out.println("Name of member is: " + obj.getMemberName());
                        System.out.println("Date of admittion " + obj.getStartMembershipDate());
                        System.out.println("Membership type: DefaultMember");
                        System.out.println("---------------------------- ");
                        break;
                    //Type 2 is Student member
                    } else if (Temp.equals("Type2")) {
                        DefaultMember obj;
                        StudentMember obj1;
                        obj = TempObject;
                        obj1 = (StudentMember) obj;
                        System.out.println("---------------Next--------- ");
                        System.out.println("Number(ID) of the member is: " + obj1.getMembershipNumber());
                        System.out.println("Name of Member is: " + obj1.getMemberName());
                        System.out.println("Date of admission: " + obj1.getStartMembershipDate());
                        System.out.println("Name of School: " + obj1.getSchoolName());
                        System.out.println("Membership type: StudentMember");
                        System.out.println("---------------------------- ");
                        break;
                    //Type 3 is Over60 member
                    } else if (Temp.equals("Type3")) {
                        DefaultMember obj;
                        Over60Member obj2;
                        obj = TempObject;
                        obj2 = (Over60Member) obj;
                        System.out.println("---------------Next--------- ");
                        System.out.println("Number(ID) of the member is: " + obj2.getMembershipNumber());
                        System.out.println("Name of member is: " + obj2.getMemberName());
                        System.out.println("Date of admittion " + obj2.getStartMembershipDate());
                        System.out.println("Membership type: Over60Member");
                        System.out.println("---------------------------- ");
                        break;
                    }
                }
            } catch (EOFException e) {
                System.out.println("Completed reading object");
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("File not found...");
            }
        }

        System.out.println("Complete.");
        Console.main(null);
    }
    public  void SaveToFile() throws IOException {
        //Saving values from theList[] to a file.
        File file = new File("BinaryFile.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream OSave = new ObjectOutputStream(fos);
        for(int count1 = 0; count1 <=i;count1++){
            OSave.writeObject(theList[count1]);
        }
        System.out.println("File Saved.");
        Console.main(null);
    }
}

