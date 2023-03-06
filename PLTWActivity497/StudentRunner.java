package PLTWActivity497;

public class StudentRunner
{
    public static void main(String[] args)
    {
        Student a = new Student("Andrew", 12345, 12); 
        Student b = new Student("Bryan", 54321, 11);
        Student c = new Student("Carl", 12345, 10);
    
        // Below two statements are equivalent
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println();

        System.out.println(a.equals(b)); 
        System.out.println(a.equals(c));
    }    
}
