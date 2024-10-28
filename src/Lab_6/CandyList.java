package Lab_6;

import java.util.*;
import java.util.function.UnaryOperator;

public class CandyList implements List<Candy> {
    private Node head;
    private Node tail;
    private int size;

    // Вузол списку
    private static class Node {
        Candy candy;
        Node prev;
        Node next;

        Node(Candy candy) {
            this.candy = candy;
        }
    }

    // Конструктори
    public CandyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public CandyList(Candy candy) {
        this();
        add(candy);
    }
    public CandyList(List<Candy> candies) {
        this();
        addAll(candies);
    }

    // Метод додавання елементу в кінець
    @Override
    public boolean add(Candy candy) {
        Node newNode = new Node(candy);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    // Метод додавання елементу на позицію i
    @Override
    public void add(int index, Candy element) {
        // Якщо розмір списку менший за i
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node newNode = new Node(element);
        // Додавання в початок списку
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        }
        // Додавання в кінець списку
        else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        // Додавання в середину списку
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    // Метод додавання елементу на початок
    @Override
    public void addFirst(Candy element) {
        add(0, element);
    }

    // Метод додавання всіх елементів колекції
    @Override
    public boolean addAll(Collection<? extends Candy> c) {
        boolean modified = false;

        for (Candy candy : c) {
            if (add(candy)) {
                modified = true;
            }
        }

        return modified;
    }

    // Метод додавання всіх елементів списку на позицію i
    @Override
    public boolean addAll(int index, Collection<? extends Candy> c) {
        // Перевірка розміру
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (c.isEmpty()) {
            return false;
        }
        // Додаткові змінні
        Node prevNode = (index == 0) ? null : getNode(index - 1);
        Node nextNode = (prevNode == null) ? head : prevNode.next;
        Node firstNewNode = null;
        Node lastNewNode = null;
        // Зв'язування елементів
        for (Candy candy : c) {
            Node newNode = new Node(candy);
            if (firstNewNode == null) {
                firstNewNode = newNode;
            } else {
                lastNewNode.next = newNode;
                newNode.prev = lastNewNode;
            }
            lastNewNode = newNode;
        }
        // Вставка елементів
        if (prevNode == null) {
            head = firstNewNode;
        } else {
            prevNode.next = firstNewNode;
            firstNewNode.prev = prevNode;
        }
        if (nextNode == null) {
            tail = lastNewNode;
        } else {
            lastNewNode.next = nextNode;
            nextNode.prev = lastNewNode;
        }
        size += c.size();
        return true;
    }

    // Очистка списку
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Перевірка, чи містить список елемент
    @Override
    public boolean contains(Object obj) {
        Node current = head;

        while (current != null) {
            if (current.candy.equals(obj)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Перевірка, чи містить список елементи колекції
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    // Геттер елементу на позиції i
    @Override
    public Candy get(int index) {
        // Перевірка розміру
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.candy;
    }

    // Геттер першого елементу
    @Override
    public Candy getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.candy;
    }

    // Геттер останнього елементу
    @Override
    public Candy getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.candy;
    }

    // Метод для порівняння
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof CandyList)) return false;

        CandyList that = (CandyList) obj;
        if (this.size != that.size) return false;

        Node currentThis = this.head;
        Node currentThat = that.head;
        while (currentThis != null) {
            if (!currentThis.candy.equals(currentThat.candy)) return false;
            currentThis = currentThis.next;
            currentThat = currentThat.next;
        }

        return true;
    }

    // Метод визначення індексу елементу (перше входження)
    @Override
    public int indexOf(Object obj) {
        int index = 0;

        for (Node x = head; x != null; x = x.next) {
            if (x.candy.equals(obj)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    // Перевірка на пустоту
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод отримання ітератора
    @Override
    public Iterator<Candy> iterator() {
        return new Iterator<Candy>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Candy next() {
                Candy candy = current.candy;
                current = current.next;
                return candy;
            }
        };
    }

    // Метод визначення індексу елементу (останнє входження)
    @Override
    public int lastIndexOf(Object obj) {
        int index = size - 1;

        for (Node x = tail; x != null; x = x.prev) {
            if (x.candy.equals(obj)) {
                return index;
            }
            index--;
        }

        return -1;
    }

    // Метод отримання ітератора списку
    @Override
    public ListIterator<Candy> listIterator() {
        return listIterator(0);
    }

    // Метод отримання ітератора списку з індексу i
    @Override
    public ListIterator<Candy> listIterator(int index) {
        // Перевірка розміру
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return new ListIterator<Candy>() {
            private Node current = get_node(index);
            private int currentIndex = index;

            private Node get_node(int index) {
                Node node = head;

                for (int i = 0; i < index; i++) {
                    node = node.next;
                }

                return node;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public Candy next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                Candy candy = current.candy;
                current = current.next;
                currentIndex++;

                return candy;
            }
            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public boolean hasPrevious() {
                return current != null && current.prev != null;
            }
            @Override
            public Candy previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }

                current = current.prev;
                currentIndex--;

                return current.candy;
            }
            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void set(Candy candy) {
                if (current == null) {
                    throw new IllegalStateException();
                }
                current.candy = candy;
            }
            @Override
            public void add(Candy candy) {
                CandyList.this.add(currentIndex++, candy);
                current = current.prev;
            }

            @Override
            public void remove() {
                if (current == null) {
                    throw new IllegalStateException();
                }

                Node toRemove = current.prev;
                CandyList.this.remove(currentIndex);

                current = toRemove;
            }
        };
    }

    // Метод видалення елементу
    @Override
    public boolean remove(Object obj) {
        for (Node x = head; x != null; x = x.next) {
            if (x.candy.equals(obj)) {
                // Перевірка на голову
                if (x.prev != null) {
                    x.prev.next = x.next;
                }
                else {
                    head = x.next;
                }
                // Перевірка на хвіст
                if (x.next != null) {
                    x.next.prev = x.prev;
                }
                else {
                    tail = x.prev;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // Метод видалення елементу за індексом
    @Override
    public Candy remove(int index) {
        // Перевірка розміру
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Видалення
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Candy removed_candy = current.candy;
        // Перевірка позиції видаленого елемента на початок списку
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        else {
            head = current.next;
        }
        // Перевірка позиції видаленого елемента на кінець списку
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        else {
            tail = current.prev;
        }

        size--;
        return removed_candy;
    }

    // Видалення першого елементу
    @Override
    public Candy removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return remove(0);
    }

    // Видалення останнього елементу
    @Override
    public Candy removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return remove(size - 1);
    }

    // Метод видалення всіх елементів колекції
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }

        return modified;
    }

    // Метод заміни кожного елемента результатом функції
    @Override
    public void replaceAll(UnaryOperator<Candy> operator) {
        Node current = head;
        while (current != null) {
            current.candy = operator.apply(current.candy);
            current = current.next;
        }
    }

    // Видалення відсутніх у колекції елементів
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<Candy> it = iterator();

        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }

        return modified;
    }

    // Геттер ноди
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Сеттер елементу за індексом
    public Candy set(int index, Candy element) {
        // Перевірка розміру
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Проходження списку
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Перезв'язування
        Candy old_candy = current.candy;
        current.candy = element;

        return old_candy;
    }

    // Розмірність списку
    @Override
    public int size() {
        return size;
    }

    // Метод сортування
    @Override
    public void sort(Comparator<? super Candy> c) {
        List<Candy> tempList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            tempList.add(current.candy);
            current = current.next;
        }

        tempList.sort(c);

        clear();
        for (Candy candy : tempList) {
            add(candy);
        }
    }

    // Метод отримання частини списку
    @Override
    public List<Candy> subList(int from_index, int to_index) {
        if (from_index < 0 || to_index > size || from_index > to_index) {
            throw new IndexOutOfBoundsException();
        }

        CandyList sublist = new CandyList();
        Node current = head;
        for (int i = 0; i < from_index; i++) current = current.next;

        for (int i = from_index; i < to_index; i++) {
            sublist.addLast(current.candy);
            current = current.next;
        }

        return sublist;
    }

    // Перетворення на масив
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;

        for (Candy candy : this) {
            array[index++] = candy;
        }

        return array;
    }

    // Параметризоване перетворення на масив
    @Override
    public <T> T[] toArray(T[] a) {
        // Перевірка розміру
        if (a.length < size) {
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        // Копіювання
        for (Node x = head; x != null; x = x.next) {
            result[i++] = x.candy;
        }
        // Заповнення зайвого місця
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
