import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Класс LinkedTaskList
 * наследуется от абстрактного класса TaskList
 */
public class LinkedTaskList extends TaskList implements Cloneable{

    /**
     * Ссылка на первый элемент списка
     */
    private Link first;

    /**
     * Класс Link создает элемент списка
     * task наши данные в виде задач
     * next - ссылка на следующий элемент списка
     */

    public static class Link {
        private Task task;
        private Link next;

        public Task getTask() {
            return task;
        }
        public Link getNext() {
            return next;
        }
        public void setNext(Link next) {
            this.next = next;
        }
        public Link(Task task) {
            this.task = task;
        }
    }

    /**
     * Метод добавления задачи в список
     * @param task задача, которую мы добавляем
     * newLink создаем новый элемент
     * newLink --> старое значение first
     * first --> newLink
     * И добавляем в начало
     * Увеличиваем size на единицу
     * @throws NullPointerException исключение при вводе пустого значения
     */
    @Override
    public void add(Task task) throws NullPointerException {
        if (task == null ) {
            throw new NullPointerException ("Добавление пустого элемента");
        }
        Link newLink = new Link(task);
        newLink.next = first;
        first = newLink;
        size++;
    }

    /**
     * Метод возвращает задачу которая находится на указанном месте в списке
     * @param index место в списке
     * @return возвращает задачу
     * @throws NullPointerException исключение если индекс больше чем размер списка
     */
    @Override
    public Task getTask(int index) throws NullPointerException {
        if (index>=size()) {
            throw new NullPointerException("Не существующий элемент");
        }
        Link current = first;
        for (int i = 0; i < index; i++) {
            current=current.next;
        }
        return current.task;
    }

    /**
     * Метод удаляет задачу и возвращает true - если задача была в списке
     * Если в списке было более одной задачи - удаляет одну
     * Уменьшает размер списка на 1 после удаления
     * @param task ищем задачу, которую надо удалить
     * @return возвращает true или falls - если задача не найдена в списке
     * @throws NullPointerException при удалении пустого элемента
     */
    @Override
    public boolean remove (Task task)throws NullPointerException {
        if (task == null ) {
            throw new NullPointerException ("Удаление пустого элемента");
        }
        Link current = first;
        Link prev = first;
        while (current.getTask()!=task) {
            if (current.getNext() == null) {
                return false;
            }
            else {
                prev = current;
                current = current.getNext();
            }
        }
        if (current==first) {
            first = first.getNext();
        }
        else prev.setNext(current.getNext());
        size--;
        return true;
    }

    /**
     * Метод возвращает список задач, которые будут выполнены в данном промежутке времени
     * Создаем новый лист
     * @param from задача должна быть выполнена не раньше заданного времени
     * @param to задача должна быть выполнена не позже заданного времени
     * если время следующего выполнения задачи относительно заданного времени from выполняется не раньше from и не позже to
     * задача добавляется в список
     * @return список с задачами
     * @throws IllegalArgumentException исключение, если время или интервал отрицательное
     */


    /**
     * Создание итератора
     * @return итератор с переопределенными методами
     */
    public Iterator iterator() {
        return new Iterator() {

            private Link current = first;
            private Link prev = null;
            private Link prev2 = null;

            /**
             * Проверка на наличие следующего элемента
             * Если текущий элемент не пустой
             * @return true
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Метод перехода итератора на след элемент
             * @throws NoSuchElementException если первый элемент равен null
             * @return task
             */
            @Override
            public Task next() {
                if (first == null) {
                    throw new NoSuchElementException();
                }
                prev2 = prev;
                prev = current;

                current = current.getNext();
                return prev.getTask();
            }

            /**
             * Метод удаления элемента
             * @throws IllegalStateException, если next() не выполнится хоть раз
             * Удаляем элемент
             * Уменьшаем размер на 1
             */
            @Override
            public void remove() {
                if (prev == null) {
                    throw new IllegalStateException();
                } else if (prev.getTask().getTitle().equals(first.getTask().getTitle())) { //first element
                    first=current;
                    first.setNext(current.getNext());
                } else if(current==null){
                    prev.setNext(null);
                } else {
                    prev2.setNext(prev.getNext());
                    prev.setNext(current.getNext());
                }
                size--;
            }
        };

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedTaskList)) return false;

        LinkedTaskList that = (LinkedTaskList) o;
        if (this.size() == that.size()) {
            Iterator list1 = this.iterator();
            Iterator list2 = that.iterator();
            while (list1.hasNext()) {
                Object o1 = list1.next();
                Object o2 = list2.next();

                if (!(o1 == null ? o2==null : o1.equals(o2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        Iterator iterator=this.iterator();
        while(iterator.hasNext()) {
            result = 31 * result + iterator.next().hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        String text = "";
        SimpleDateFormat date = new SimpleDateFormat("[YYYY-MM-dd hh:mm:ss.SSS]");
        for (int i = 0; i < size; i++) {
            text += "\"" + getTask(i).getTitle() + "\"";
            if (getTask(i).isRepeated()) {
                text += " from " + date.format(getTask(i).getStartTime());
                text += " to " + date.format(getTask(i).getEndTime());
                text += " every [" + reInterval(getTask(i).getInterval()) + "]";
            }
            else {
                text += " at " + date.format(getTask(i).getStartTime());
            }
            text +=  (getTask(i).isActive() ? " inactive" : "");
            if (i!=size-1) text+=";";
            else text+=".";
            text += "\n";
        }
        return text;
    }

    public String reInterval(int interval) {
        int days = interval / 1000 / 86400;
        int hours = interval / 1000 / 3600 % 24;
        int minutes = interval / 1000 / 60 % 60;
        int seconds = interval / 1000 % 60;
        String txt="";
        if (days>=1) {
            txt+= days;
            if (days>1) txt+= " days";
            else txt+= " day";
        }
        if (hours>=1) {
            if (txt.equals("")) txt+= hours;
            else  txt+= " " + hours;
            if (hours>1) txt+= " hours";
            else txt+= " hour";
        }
        if (minutes>=1) {
            if (txt.equals("")) txt+= minutes;
            else  txt+= " " + minutes;
            if (minutes>1) txt+= " minutes";
            else txt+= " minute";
        }
        if (seconds>=1) {
            if (txt.equals("")) txt+= seconds;
            else  txt+= " " + seconds;
            if (seconds>1) txt+= " seconds";
            else txt+= " second";
        }
        return txt;
    }

    @Override
    public LinkedTaskList clone() {
        LinkedTaskList clone = null;
        try {
            clone = (LinkedTaskList) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return clone;
    }
}
