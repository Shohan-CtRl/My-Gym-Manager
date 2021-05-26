package sample;


public class StudentMember extends DefaultMember implements java.io.Serializable{
    private String SchoolName;
    //Constructor
    public StudentMember(String MembershipNumber, String MemberId, String StartMembershipDate,String MembershipType, String SchoolName) {
        super(MembershipNumber, MemberId, StartMembershipDate, MembershipType);
        this.SchoolName= SchoolName;
    }
    //Set & Get for school name.
    public String getSchoolName(){
        return SchoolName;
    }
    public void setSchoolName(String NewSchoolName){
        this.SchoolName = NewSchoolName;
    }


}
