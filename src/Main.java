import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        Task task1 = new Task("Task1", new Date(50), new Date(70), 20);
        Task task2 = new Task("Task2", 1400);
        Task task3 = new Task("Task3", new Date(200000), new Date(700000), 20000);
        Task task8 = new Task("Task3", 850000000, 900000000, 2000000);
        Task task4 = new Task("Task4", new Date(200000000L), new Date(100000000), 2000);
        Task task5 = new Task("Task5", new Date(500000), new Date(900000), 2000);
        Task task6 = new Task("Task6", new Date(100000), new Date(400000), 200);
        Task task7 = new Task("Task7", 2000, 9000, 1200);
//        System.out.println("Task  repeat non active");
//        System.out.println(task1.nextTimeAfter(1300)); //not active
//        System.out.println("Task non repeat non active");
//        System.out.println(task2.nextTimeAfter(5000)); //not active
//
        task1.setActive(true);
        task2.setActive(true);
        task3.setActive(true);
        task8.setActive(true);
//        System.out.println("Task repeat active:");
//        System.out.println(task1.nextTimeAfter(1300));
//        System.out.println(task1.nextTimeAfter(1600));
//        System.out.println(task1.nextTimeAfter(1700));
//        System.out.println(task1.nextTimeAfter(2600));
//        System.out.println(task1.nextTimeAfter(5700));
//        System.out.println(task1.nextTimeAfter(5900));
//
//        System.out.println("Task non repeat active:");
//        System.out.println(task2.nextTimeAfter(1300));
//        System.out.println(task2.nextTimeAfter(5900));
//        System.out.println(task2.nextTimeAfter(6000));

        ArrayTaskList list = new ArrayTaskList(1);
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);


        Iterator it1 = list.iterator();


//        while (it1.hasNext())
//        {
//            System.out.println(it1.next());
//        }

//        it1.next();
//
//        it1.remove();
//        it1.next();
//        it1.next();
//
//        it1.remove();
//        it1.next();
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.getTask(i).getTitle());
//        }


//        for (int i = 0; i < 100; i++) {
//            list.add(task1);
//        }
//        System.out.println(list.size());
//        for (int i = 0; i < 20; i++) {
//            list.remove(task1);
//        }
//
//        System.out.println(list.size());
//
//
//        System.out.println(list.size());
//
//        for (int i=0; i<5; i++)
//        {
//            list.add(task1);
//        }
//        System.out.println(list.size());
//
//        list.remove(task1);
//
//        System.out.println(list.size());
//
//
//        task1.setTitle("TASK ONE");
//        task1.setActive(true);
//        task1.setTime(1800);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.getTask(i).getTime() + " " +  list.getTask(i).getRepeatInterval() );
//        }
//        ArrayTaskList list2 = list.incoming(7700, 10000);
//
//        System.out.println();
//        System.out.println();
//
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.getTask(i).getTitle());
//        }

//        TaskList[] list = new TaskList[2];
//
//        list[0]=new ArrayTaskList(10);
//        list[1]=new LinkedTaskList(15);
//
//        list[0].add(task1);
//        list[0].add(task2);
//        list[0].add(task3);
//        list[1].add(task2);
//        list[1].add(task2);
//        list[1].add(task3);
//        list[1].add(task3);
//        list[1].add(task3);
//        System.out.println(list[0]);
//        System.out.println(list[1]);
//
//        for (int i = 0; i < list[0].size(); i++) {
//            System.out.println(list[0].getTask(i).getTitle());
//        }
//        System.out.println();
//        System.out.println();
//        for (int i = 0; i < list[1].size(); i++) {
//            System.out.println(list[1].getTask(i).getTitle());
//        }
//
//
//
//
//    }
//        System.out.println(task2.getStartTime() + " " + task2.getEndTime() + " " + task2.getRepeatInterval());
//        task2.setTime(1500, 2500, 10);

//            System.out.println(task2.getStartTime() + " " + task2.getEndTime() + " " + task2.getRepeatInterval());
//
//            System.out.println(task2.nextTimeAfter(1500));
//
//            TaskList aList = new ArrayTaskList(5);
//            System.out.println(aList.size());
//
//            TaskList lList = new LinkedTaskList();
//            System.out.println(lList.size());
//            lList.add(task1);
//            lList.add(task2);
//            lList.add(task3);
//            System.out.println(lList.size());
//            for (int i = 0; i < lList.size(); i++) {
//                    System.out.println(lList.getTask(i).getTitle());
//            }
//            lList.remove((task2));
//            System.out.println(lList.size());
//            for (int i = 0; i < lList.size(); i++) {
//                    System.out.println(lList.getTask(i).getTitle());
//            }
//
//            TaskList aList = new ArrayTaskList();
//            System.out.println(aList.size());
//            System.out.println(lList.size);
//            System.out.println(aList.size);

//
//            aList.add(task1);
//            aList.add(task2);
//            aList.add(task3);
//            lList.add(task1);
//            lList.add(task2);
//            lList.add(task3);
//            lList.add(task3);
//            lList.add(task2);
//            System.out.println(aList.size());
//            System.out.println(lList.size());
//
//            TaskList list = aList.incoming(2000, 7000);
//
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.getTask(i).getTitle());
//            }
//
//            TaskList list2 = lList.incoming(2000, 7000);
//
//            for (int i = 0; i < list2.size(); i++) {
//                System.out.println(list2.getTask(i).getTitle());
//            }
        LinkedTaskList llist = new LinkedTaskList();

        llist.add(task1);
        llist.add(task2);
        llist.add(task3);
        llist.add(task4);
        llist.add(task5);
        llist.add(task6);
        llist.add(task7);
        llist.add(task8);

        llist.remove(task7);
        Iterator it2 = llist.iterator();

        it2.next();
        it2.next();

        it2.remove();

        Iterable<Task> tasks = Tasks.incoming(llist, new Date(20000000), new Date(2000000000));
        SortedMap<Date, Set<Task>> map = Tasks.calendar(tasks, new Date(10000000), new Date(2000000000));

        System.out.println(tasks);
        System.out.println(map);
//        System.out.println("ARRAAAAY_________________");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.getTask(i));
//        }
//
//        System.out.println(list);
//        System.out.println(llist);
//
//        System.out.println("List_____________________________");
//        for (int i = 0; i < llist.size(); i++) {
//            System.out.println(llist.getTask(i));
//        }








    }

 }



