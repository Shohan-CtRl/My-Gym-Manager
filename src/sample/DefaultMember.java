package sample;   

import java.io.IOException;

public class DefaultMember implements java.io.Serializable{
    private static int count;
    private  String MembershipNumber;
    private  String MemberId;
    private String StartMembershipDate;
    private String MembershipType;
    //Constructor
    public  DefaultMember(String MembershipNumber,String MemberId,String StartMembershipDate,String MembershipType){
        super();
        this.MembershipNumber=MembershipNumber;
        this.MemberId=MemberId;
        this.StartMembershipDate=StartMembershipDate;
        this.MembershipType=MembershipType;
        count++;
    }
    //Get & set methods for memberNUmber,MemberName,membertype and date
    public String getMembershipNumber(){
        return MembershipNumber;
    }
    public void setMembershipNumber(String NewMemberId) throws IOException {
        this.MembershipNumber = NewMemberId;
    }

    //Member name
    public String getMemberName(){
        return MemberId;
    }
    public void setName(String NewMemberName){

        this.MemberId = NewMemberName;
    }
    //Membership date
    public String getStartMembershipDate(){
        return StartMembershipDate;
    }

    public void setStartMembershipDate(String NewStartMembershipDate){
        this.StartMembershipDate = NewStartMembershipDate;
    }
    //Member type
    public String getMembershipType(){
        return MembershipType;
    }

    public void setMembershipType(String NewMembershipType){
        this.MembershipType = NewMembershipType;
    }

}
