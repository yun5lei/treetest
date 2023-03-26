package com.lyl;

public class Entry<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Entry() {
    }

    public Entry(E value) {
        this.value = value;
    }

    public Entry left;
    public Entry right;
    public void show()
    {
        if(value!=null)
        {
            System.out.println("Enter的值为"+value);
        }
        Entry entry=right;
        while (entry!=null)
        {
            System.out.println("Enter的值为"+entry.value);
            entry=entry.right;
        }
    }
}
