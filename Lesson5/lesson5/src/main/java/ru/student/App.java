package ru.student;

public class App {
    public static void main(String[] args) {

//        phomeBookStarter();
//        System.out.println();
//        RepeatName.run();
//        System.out.println();
        HeapSort.run();
    }

    private static void phomeBookStarter() {
        PhoneBook pb = new PhoneBook();
        pb.getAll();
        pb.addNewContact("Dimqa", 123, 456, 789);

        pb.addNewPhone("Diqa", 12456);
        pb.getAll();
        System.out.println(pb.getOneUser("Dimqa"));

        pb.removePhone("Dimqa", 0);
        pb.getAll();
        pb.removeUser("Diqa");

        pb.getAll();
    }
}
