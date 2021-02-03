package services;

import java.util.List;

public interface CRUDInterfaces<T> {
    void add(T t);
    void addAll(List<T> list);
    List<T> findAll();
}
