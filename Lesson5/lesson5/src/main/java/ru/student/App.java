package ru.student;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        phomeBookStarter();
    }
    private static void phomeBookStarter() {
        PhoneBook pb = new PhoneBook();
        pb.getAll();
        pb.addNewContact("Dimqa", 123, 456, 789);
        pb.getAll();
        pb.addNewPhone("Diqa", 12456);
        pb.getAll();
        pb.getOneUser("Dimqa");
    }
}
