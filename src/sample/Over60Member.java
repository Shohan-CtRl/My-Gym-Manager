package sample;

import java.util.Date;

public class Over60Member extends DefaultMember implements java.io.Serializable{

    private int Age;
    //Constructor
    public Over60Member(String MembershipNumber, String MemberId, String StartMembershipDate,String MembershipType, int Age) {
        super(MembershipNumber, MemberId, StartMembershipDate, MembershipType);
        this.Age= Age;
    }
    //Get & set method for age.
    public int getAge(){
        return Age;
    }
    public void setAge(int NewAge){
        this.Age = NewAge;
    }
}
