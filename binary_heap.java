/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heirarchical_clustering;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class binary_heap {
    
    private int heapSize; // denotes the size of the heap
    private int capacity; // denotes the capactiy of the heap
    private double[] heap;  //represents the binary heap
    
    
/**Constructor*/
public binary_heap(int cap)
{
        heapSize=0;
        heap = new double[cap+1];
        capacity =cap;

        // Arrays.fill(heap,-1);
}
    
/**function to check if the heap is full*/
public boolean isFull()
{
    return (heapSize == heap.length);
}

/**check if the heap is Full*/

public boolean isEmpty()
{
    return heapSize==0;
}
    
/**a method to clear the heap */
public void makeEmpty()
{
    heapSize=0;
}

/**Function to get the parent of a given child node */

private int parent(int i)
{
    return (i-1)/2;
}

/**to get the left child of the node at a given index*/
private int left(int i)
{
    return (2*i+1);
}

/** to get the right child at a given index*/

private int right(int i)
{
    return 2*i+2;
}


/**  to get the minimum value from the binary heap
 */

public double getMin()
{
    return heap[0];
}

/** A method to carry out the insertion of a new node in the binary heap
     * @param k */
public void insertKey(double k)
{
    if(heapSize == capacity)
    {
        System.out.println("Heap Overflow: Cannot insert any more item in the heap ");
        System.exit(0);
    }
    
    // insert the key at the end and  then heapify the tree
    heapSize++;
    int j = heapSize-1;
    heap[j]=k;   // inserting the element
    
    
    // fix the heap property
    while(j!=0 && heap[parent(j)]>heap[j])
    {
      swap(heap[parent(j)],heap[j]);
      j = parent(j);
    }
}

public void swap(double x,double y)
{
    double temp;
    temp=x;
    x=y;
    y=temp;
}

public void decreaseKey(int j, double new_val)
{
    heap[j]=new_val;
    
    while(j!=0 && heap[parent(j)]>heap[j])
    {
        swap(heap[j],heap[parent(j)]);
        j=parent(j);
    }
}

public void deleteKey(int i)
{
    decreaseKey(i,-1000);
    extractMin();
}






/** Method to remove minimum element from min heap
     * @return  **/

public double extractMin()
{
    if(heapSize==0)
        return 1000.0;
    if(heapSize == 1)
    {
        heapSize--;
        return heap[0];
    }
    
    // store the minimum value, and remove it from the heap4
    
    double root = heap[0];
    heap[0] = heap[heapSize-1];
    heapSize--;
    MinHeapify(0);
    
    
    return root;
}


public void MinHeapify(int i)
{
    int l = left(i);
    int r = right(i);
    int smallest = i;
    
    
    if(l<heapSize && heap[l]< heap[i])
        smallest = l;
    
    if(r<heapSize && heap[r]<heap[smallest])
        smallest = r;
     
    if(smallest!=i)
    {
        swap(heap[i],heap[smallest]);
        MinHeapify(smallest);
    }
    
}

}

