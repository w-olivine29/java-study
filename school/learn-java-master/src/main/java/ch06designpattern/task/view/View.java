package ch06designpattern.task.view;

import java.util.Collection;

public interface View<T> {

    void show(T item);

    void show(Collection<T> items);

    void showMessage(String message);
}
