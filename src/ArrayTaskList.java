import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Arrays;

public class ArrayTaskList extends TaskList implements Cloneable {

    /**
     * @param tasks создаем массив типа Task и не инициализируем его
     * @param size размер массива (в нек.случаях индекс)
     */
    public Task[] tasks;

    /**
     * Конструктор, создает массив размером size
     * @param size размер массива
     */
    public ArrayTaskList(int size) {
        tasks = new Task[size];
    }

    /**
     * Конструктор стандартный, создает массив размером в 10 элементов
     */
    public ArrayTaskList() {
        tasks  =new Task[10];
    }

    /**
     * Метод добавления задачи в массив
     * @param task задача, которую мы добавляем
     * Если количество добавленных задач будет больше размера массива - увеличиваем массив tasks
     * И добавляем в конец задачу
     * Увеличиваем size на единицу
     */
    public void add(Task task) throws NullPointerException
    {
        if (task == null )
        {
            throw new NullPointerException ("Добавление пустого элемента");
        }
        if (size >= tasks.length) {
            Task[] tArr = new Task[(size*3)/2 +1];
            System.arraycopy(tasks, 0, tArr, 0, size);
            tasks = tArr;
        }
        tasks[size] = task;
        size++;
    }

    /**
     * Метод возвращает задачу которая находится на указанном месте в списке
     * @param index место в списке
     * @return возвращает задачу
     */
    public Task getTask(int index) {
        return tasks[index];
    }

    /**
     * Метод удаляет задачу и возвращает true - если задача была в списке
     * Если в списке было более одной задачи - удаляет одну
     * Уменьшает размер массива на 1 после удаления
     * @param task ищем задачу, которую надо удалить
     * @return возвращает true или falls - если задача не найдена в списке
     */
    public boolean remove (Task task) throws NullPointerException
    {
        if (task == null )
        {
            throw new NullPointerException ("Удаление пустого элемента");
        }
        for (int i = 0; i < tasks.length; i++) {
            if (task.equals(tasks[i])) {
                System.arraycopy(tasks, i+1, tasks, i, size-1);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает список задач, которые будут выполнены в данном промежутке времени
     * Создаем новый лист
     * @param from задача должна быть выполнена не раньше заданного времени
     * @param to задача должна быть выполнена не позже заданного времени
     * если время следующего выполнения задачи относительно заданного времени from выполняется не раньше from и не позже to
     * задача добавляется в список
     * @return список с задачами
     */


    /**
     * Создание итератора
     * @return итератор с переопределенными методами
     */
    public Iterator iterator() {
        return new Iterator() {


            private Task[] list = tasks;
            private int count;

            /**
             * Проверка на наличие следующего элемента
             * Если счетчик меньше размера, то возвращает true
             * @return true
             */
            @Override
            public boolean hasNext() {
                return count < size;
            }

            /**
             * Метод перехода итератора на след элемент
             * увеличивыем count на 1
             * @throws NoSuchElementException, если первый элемент пустой
             * @return task
             */
            @Override
            public Task next() {
                if (list[0] == null) {
                    throw new NoSuchElementException();
                }
                Task task;
                task = list[count];
                count++;
                return task;
            }

            /**
             * Метод удаления элемента
             * @throws IllegalStateException, если next() не выполнится хоть раз
             * Удаляем элемент
             * Уменьшаем счетчик и размер на 1
             */
            @Override
            public void remove() {
                if (count == 0) {
                    throw new IllegalStateException();
                }
                else {
                    for (int i = count-1; i < size -1 ; i++) {
                        tasks[i] = tasks[i+1];
                    }
                    count--;
                    size--;
                }
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        if (!Arrays.equals(tasks, that.tasks)) return false;
        return true;

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tasks);
    }

    @Override
    public String toString() {
        String text = "";
        text += "ArrayTaskList: {";
        for (int i = 0; i < size; i++) {
            text += "[" + getTask(i).getTitle() + "]";
        }
        text += "}";
        text += " Size = " + size;
        return text;
    }

    public ArrayTaskList clone() {
        try {

            ArrayTaskList v = (ArrayTaskList) super.clone();
            v.tasks  = Arrays.copyOf(tasks, tasks.length);
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }


}