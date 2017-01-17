import java.io.*;


/**
 * Created by dani4 on 16.01.2017.
 */
public class TaskIO {

    public static void write(TaskList tasks, OutputStream out) {
        try {
            ObjectOutputStream out2 = new ObjectOutputStream(out);
            out2.writeInt(tasks.size());
            for (Task task : tasks) {
                out2.writeObject(task);
            }
//            out2.close();
        } catch (IOException e) {
            System.out.println("Writing ERROR");
        }
    }

    public static void read(TaskList tasks, InputStream in) {
        try {
            ObjectInputStream in2 = new ObjectInputStream(in);
            for (int i=0; i<in2.readInt(); i++) {
                Task task = null;
                try {
                    task = (Task) in2.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Reading ERROR");
        }
    }

    public static void writeBinary(TaskList tasks, File file) {
        try {
            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(file));
            out2.writeInt(tasks.size());
            for (Task task : tasks) {
                out2.writeObject(task);
            }
        } catch (IOException e) {
            System.out.println("Writing ERROR");
        }
    }

    public static void readBinary(TaskList tasks, File file) {
        try {
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(file));
            for (int i=0; i<in2.readInt(); i++) {
                Task task = null;
                try {
                    task = (Task) in2.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Reading ERROR");
        }
    }

    public static void write(TaskList tasks, Writer out) {

    }

    public static void read(TaskList tasks, Reader in) {

    }

    public static void  writeText(TaskList tasks, File file) {

    }

    public static void readText(TaskList tasks, File file) {

    }


}
