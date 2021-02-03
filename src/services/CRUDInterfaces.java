package services;

import java.util.List;

public interface CRUDInterfaces<T> {
    void add(T t);

    List<T> findAll();
}
