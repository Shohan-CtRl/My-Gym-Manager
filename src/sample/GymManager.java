package sample;

import java.io.IOException;

public interface GymManager {

    public  void add(DefaultMember d);
    public  void add2(StudentMember a);
    public  void add3(Over60Member b);
    public  void DeleteMember() throws IOException;
    public  void SortList() throws IOException;
    public  void PrintList() throws IOException;
    public  void SaveToFile() throws IOException;
}
