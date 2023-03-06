package PLTWActivity497;

public class Student
{
    private String name = "";
    private int id;
    private int grade;

    Student(String inputName, int i, int g)
    {
        name = inputName;
        id = i;
        grade = g;
    }

    public String toString()
    {
        return ("\nStudent:" + "\nName: " + name + "\nID: " + id + "\nGrade: " + grade);
    }

    public boolean equals(Student other)
    {
        if (id == other.getID())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getID()
    {
        return id;
    }

}
