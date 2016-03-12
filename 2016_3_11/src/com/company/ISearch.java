package com.company;

interface ISearch<E> {

      int search(E[] elems, int key);
      int searchIterative(Integer[] elems, int key, int low, int high);
      int searchRecursive (E[]elems,int key, int low, int high);


}
