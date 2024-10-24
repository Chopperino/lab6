package lab6;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Клас, що представляє типізовану колекцію однозв'язного списку,
 * яка реалізує інтерфейс Set та працює з об'єктами класу Armor.
 *
 * @param <T> Тип об'єкта, що повинен бути наслідуваним від класу Armor
 */
public class LinkedArmorSet<T extends Armor> implements Set<T> {

  /**
   * Внутрішній клас, що представляє вузол однозв'язного списку.
   */
  private static class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
    }
  }

  private Node<T> head;  // Початок списку
  private int size;   // Кількість елементів у списку

  /**
   * Порожній конструктор, що створює порожній набір.
   */
  public LinkedArmorSet() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Конструктор, що приймає один об'єкт типу Armor і додає його до набору.
   *
   * @param armor об'єкт, який додається до набору
   */
  public LinkedArmorSet(T armor) {
    this();
    add(armor);
  }

  /**
   * Конструктор, що приймає стандартну колекцію об'єктів Armor
   * і додає їх до набору.
   *
   * @param collection колекція об'єктів Armor
   */
  public LinkedArmorSet(Collection<? extends T> collection) {
    this();
    addAll(collection);
  }

  @Override
  public boolean add(T armor) {
    if (armor == null) {
      throw new NullPointerException("Об'єкт не може бути null.");
    }
    if (contains(armor)) {
      return false;
    }
    Node<T> newNode = new Node<>(armor);
    newNode.next = head;
    head = newNode;
    size++;
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    boolean modified = false;
    for (T armor : c) {
      if (add(armor)) {
        modified = true;
      }
    }
    return modified;
  }

  @Override
  public void clear() {
    head = null;
    size = 0;
  }

  @Override
  public boolean contains(Object o) {
    if (o == null || !(o instanceof Armor)) {
      return false;
    }
    Node current = head;
    while (current != null) {
      if (current.data.equals(o)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object obj : c) {
      if (!contains(obj)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

  @Override
  public boolean remove(Object o) {
    if (o == null || !(o instanceof Armor)) {
      return false;
    }
    Node<T> current = head;
    Node<T> previous = null;

    while (current != null) {
      if (current.data.equals(o)) {
        if (previous == null) {
          head = current.next;  // Видаляємо перший елемент
        } else {
          previous.next = current.next;  // Пропускаємо поточний елемент
        }
        size--;
        return true;
      }
      previous = current;
      current = current.next;
    }
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    for (Object obj : c) {
      if (remove(obj)) {
        modified = true;
      }
    }
    return modified;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    Node current = head;
    Node previous = null;

    while (current != null) {
      if (!c.contains(current.data)) {
        if (previous == null) {
          head = current.next;  // Видаляємо перший елемент
        } else {
          previous.next = current.next;  // Пропускаємо поточний елемент
        }
        size--;
        modified = true;
      } else {
        previous = current;
      }
      current = current.next;
    }
    return modified;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    Node current = head;
    int index = 0;
    while (current != null) {
      array[index++] = current.data;
      current = current.next;
    }
    return array;
  }

  @Override
  public <U> U[] toArray(U[] a) {
    if (a.length < size) {
      a = (U[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
    }
    Node current = head;
    int index = 0;
    Object[] result = a;
    while (current != null) {
      result[index++] = current.data;
      current = current.next;
    }
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }
}

