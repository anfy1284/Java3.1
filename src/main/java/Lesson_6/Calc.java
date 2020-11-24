package Lesson_6;

import java.util.Arrays;

public class Calc {

    public <T> T[] subArr(T[] a, T key) {
        int i;
        int j = a.length;
        for (i = 0; i < a.length; i++){
            if(a[i] == key) j = i;
        }

        if (j == a.length)
            throw new RuntimeException("There is no " + key.toString() + " in array!");

        return Arrays.copyOfRange(a, j + 1, a.length);
    }

    public <T> boolean search(T[] a, T[] key){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(a[i] == key[j]) return true;
            }
        }
        return false;
    }

}
