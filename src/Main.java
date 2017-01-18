import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {


        Task task1 = new Task("Task1", new Date(), new Date(1984731506204L), 86400);
        Task task2 = new Task("Task2", 1484743545);
        Task task3 = new Task("Task3", new Date(1484731506204L), new Date(1984731506204L), 20000);

        Task task4 = new Task("Task4", new Date(1474731506204L), new Date(1984731506204L), 2000);
        Task task5 = new Task("Task5", new Date(1488731506204L), new Date(1984731506204L), 2000);
        Task task6 = new Task("Task6", new Date(1489731506204L), new Date(1984731506204L), 200);
        Task task7 = new Task("Task7", 14847315, 1234315062, 148473);
        Task task8 = new Task("Task8", 1484743545, 1984731506, 86402);

        task1.setActive(true);
        task2.setActive(true);
        task3.setActive(true);
        task8.setActive(true);
        task7.setActive(true);



        ArrayTaskList list = new ArrayTaskList(1);
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        list.add(task6);
        list.add(task7);
        list.add(task8);

        Date d = new Date();
        System.out.println(d.getTime());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getTask(i).toString());
        }

        File f = new File("hello.txt");
        TaskIO.writeText(list, f);








    }

 }



