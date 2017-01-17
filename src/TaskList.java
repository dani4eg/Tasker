import java.io.Serializable;

public abstract class TaskList implements Iterable<Task>, Serializable {

    public  int size = 0;

    public  int size() {
        return this.size;
    }

    public abstract void add(Task task);

    public abstract Task getTask(int index);

    public abstract boolean remove (Task task);
}

