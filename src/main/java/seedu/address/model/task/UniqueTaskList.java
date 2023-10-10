package seedu.address.model.task;

import java.util.Iterator;

public class UniqueTaskList implements Iterable<Task> {
    @Override
    public Iterator<Task> iterator() {
        return null;
    }

    @Override
    public boolean equals(Object other) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
