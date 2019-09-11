:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

🌿 [Algorithms](index-algorithms.md)

# Sorting And Searching

1. [Binary Search](#1-binary-search)
2. [Search an element in a sorted and rotated array](#2-search-an-element-in-a-sorted-and-rotated-array)
3. [Bubble Sort](#3-bubble-sort)
4. [Insertion Sort](#4-insertion-sort)
5. [Merge Sort](#5-merge-sort)
6. [Index min priority queue](#6-index-min-priority-queue)
7. [Heap Sort (Binary Heap)](#7-heap-sort)
8. [Quick Sort](#8-quick-sort)
9. [Find Kth Smallest/Largest Element In Unsorted Array](#9-find-kth-smallest-element-in-unsorted-array)
10. [Given a sorted array and a number x, find the pair in array whose sum is closest to x](#10)

## [1 Binary Search]
**Binary Search**: Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

![](../../images/algorithms/binary-search.png)

The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n)

:pencil:[BinarySearch.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/BinarySearch.java)

## [2 Search an element in a sorted and rotated array]
An element in a sorted array can be found in O(log n) time via **binary search**. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

![](../../images/algorithms/sorted-pivoted-array.png)

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3

**Solution**:

1) Find middle point mid = (l + h)/2

2) **If** key is present at middle point, return mid.

3) **Else If** arr[l..mid] is sorted

    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
       
    b) Else recur for arr[mid+1..h]
    
4) **Else** (arr[mid+1..h] must be sorted)

    a) If key to be searched lies in range from arr[mid+1]
       to arr[h], recur for arr[mid+1..h].
       
    b) Else recur for arr[l..mid] 

:pencil:[SortedRotatedSearch.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/SortedRotatedSearch.java)

## [3 Bubble Sort]
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

Example:

**First Pass**:

    ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
    ( 1 5 4 2 8 ) –> ( 1 4 5 2 8 ), Swap since 5 > 4
    ( 1 4 5 2 8 ) –> ( 1 4 2 5 8 ), Swap since 5 > 2
    ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

**Second Pass**:

    ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
    ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

**Third Pass**:

    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

:pencil:[BubbleSort.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/BubbleSort.java)

**Worst and Average Case Time Complexity**: O(n*n). Worst case occurs when array is reverse sorted.

**Best Case Time Complexity**: O(n). Best case occurs when array is already sorted.

**Auxiliary Space**: O(1)

**Sorting In Place**: Yes

**Stable**: Yes

## [4 Insertion Sort]
Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.

**Solution**:

    // Sort an arr[] of size n
    Loop from i = 1 to n-1.
        Pick element arr[i] and insert it into sorted sequence arr[0…i-1]

![](../../images/algorithms/insertion-sort.png)

:pencil:[InsertionSort.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/InsertionSort.java)

**Time Complexity**: O(n*2)

**Auxiliary Space**: O(1)

**Boundary Cases**: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.

**Sorting In Place**: Yes

**Stable**: Yes

**Uses**: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

## [5 Merge Sort]
Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. 
The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.

    MergeSort(arr[], l,  r)
    If r > l
         1. Find the middle point to divide the array into two halves:  
                 middle m = (l+r)/2
         2. Call mergeSort for first half:   
                 Call mergeSort(arr, l, m)
         3. Call mergeSort for second half:
                 Call mergeSort(arr, m+1, r)
         4. Merge the two halves sorted in step 2 and 3:
                 Call merge(arr, l, m, r)
The complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete array is merged.
             
![](../../images/algorithms/merge-sort-tutorial.png)

:pencil:[MergeSort.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/MergeSort.java)

**Time Complexity**: Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
T(n) = 2T(n/2) + Θ(n)
The above recurrence can be solved either using Recurrence Tree method or Master method.
Time complexity of Merge Sort is Θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and take linear time to merge two halves.

**Auxiliary Space**: O(n)

**Algorithmic Paradigm**: Divide and Conquer

**Sorting In Place**: No in a typical implementation

**Stable**: Yes

## [6 Index min priority queue]
**Complete Binary Tree**: A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible

**Binary Heap**: The binary heap is a data structure that can efficiently support the basic priority-queue operations. In a binary heap, the items are stored in an array such that each key is guaranteed to be larger than (or equal to) the keys at two other specific positions

A binary heap is a set of nodes with keys arranged in a complete heap-ordered binary tree, represented in level order in an array (not using the first entry).

![](../../images/algorithms/heap.png)

![](../../images/algorithms/heap-representations.png)

In a heap, the parent of the node in position k is in position k/2; and, conversely, the two children of the node in position k are in positions 2k and 2k + 1. 

**Algorithms on heaps**. We represent a heap of size n in private array pq[] of length n + 1, with pq[0] unused and the heap in pq[1] through pq[n].

* Bottom-up reheapify (swim). If the heap order is violated because a node's key becomes larger than that node's parents key, then we can make progress toward fixing the violation by exchanging the node with its parent. After the exchange, the node is larger than both its children (one is the old parent, and the other is smaller than the old parent because it was a child of that node) but the node may still be larger than its parent. We can fix that violation in the same way, and so forth, moving up the heap until we reach a node with a larger key, or the root. Bottom-up heapify (swim)
 
 ![](../../images/algorithms/swim.png)  
 
    private void swim(int k) {
       while (k > 1 && less(k/2, k)) {
          exch(k, k/2);
          k = k/2;
       }
    }

* Top-down heapify (sink). If the heap order is violated because a node's key becomes smaller than one or both of that node's children's keys, then we can make progress toward fixing the violation by exchanging the node with the larger of its two children. This switch may cause a violation at the child; we fix that violation in the same way, and so forth, moving down the heap until we reach a node with both children smaller, or the bottom

![](../../images/algorithms/sink.png) 

    private void sink(int k) {
       while (2*k <= N) {
          int j = 2*k;
          if (j < N && less(j, j+1)) j++;
          if (!less(k, j)) break;
          exch(k, j);
          k = j;
       }
    }
    
**Heap-based priority queue**. 
* Insert. We add the new item at the end of the array, increment the size of the heap, and then swim up through the heap with that item to restore the heap condition.
* Remove the maximum. We take the largest item off the top, put the item from the end of the heap at the top, decrement the size of the heap, and then sink down through the heap with that item to restore the heap condition.

![](../../images/algorithms/heap-ops.png) 

In an n-item priority queue, the heap algorithms require no more than 1 + lg n compares for **insert** and no more than 2 lg n compares for **remove** the maximum.

**Index priority queue**. In many applications, it makes sense to allow clients to refer to items that are already on the priority queue. One easy way to do so is to associate a unique integer index with each item.

![](../../images/algorithms/indexpq-api.png) 

:pencil:[IndexMinPQ.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/IndexMinPQ.java)

## [7 Heap Sort]
**Heapsort**.We can use any priority queue to develop a sorting method. We insert all the keys to be sorted into a minimum-oriented priority queue, then repeatedly use remove the minimum to remove them all in order. When using a heap for the priority queue, we obtain heapsort.

 Heapsort breaks into two phases: heap construction, where we reorganize the original array into a heap, and the sortdown, where we pull the items out of the heap in decreasing order to build the sorted result.
 
* Heap construction.  A clever method that is much more efficient is to proceed from right to left, using sink() to make subheaps as we go. Every position in the array is the root of a small subheap; sink() works or such subheaps, as well. If the two children of a node are heaps, then calling sink() on that node makes the subtree rooted there a heap.
* Sortdown. Most of the work during heapsort is done during the second phase, where we remove the largest remaining items from the heap and put it into the array position vacated as the heap shrinks.

![](../../images/algorithms/heapsort-trace.png) 

:pencil:[HeapSort.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/HeapSort.java)

Heapsort uses fewer than 2 n lg n compare and exchanges to sort n items.

## [8 Quick Sort]
QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. 

There are many different versions of quickSort that pick pivot in different ways.
* Always pick first element as pivot.
* Always pick last element as pivot (implemented below)
* Pick a random element as pivot.
* Pick median as pivot.

The key process in quickSort is partition().
1. We arbitrarily choose a[lo] to be the partitioning item—the one that will go into its final position. 
2. Next, we scan from the left end of the array until we find an entry that is greater than (**or equal to**) the partitioning item, and we scan from the right end of the array until we find an entry less than (**or equal to**) the partitioning item.
3. The two items that **stopped** the scans are out of place in the final partitioned array, so we exchange them.
4. When the scan indices cross, all that we need to do to complete the partitioning process is to exchange the partitioning item a[lo] with the rightmost entry of the left subarray and return its index.

**Implementation details**. 
* Handling items with keys **equal to** the partitioning item's key. It is best to **stop** the left scan for items with keys greater than **or equal to** the partitioning item's key and the right scan for items less than **or equal to** the partitioning item's key. Even though this policy might seem to create unnecessary exchanges involving items with keys equal to the partitioning item's key, it is crucial to avoiding **quadratic running time** in certain typical applications.
* Preserving randomness. The random shuffle puts the array in random order. Since it treats all items in the subarrays uniformly, QuickSort.java has the property that its two subarrays are also in random order. This fact is crucial to the algorithm's predictability. An alternate way to preserve randomness is to choose a random item for partitioning within partition().

![](../../images/algorithms/partitioning-overview.png) 

:pencil:[HeapSort.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/QuickSort.java)

**Proposition**. 
* Quicksort uses ~2 N ln N compares (and one-sixth that many exchanges) on the average to sort an array of length N with distinct keys.
* Quicksort uses ~N2/2 compares in the worst case, but random shuffling protects against this case.

## [9 Find Kth Smallest Element In Unsorted Array]
Given an array and a number k where k is smaller than the size of the array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.

**Solution**: 

1. select(arr, l, h, k)
2. Same as the quick sort partition process to randomly pick a pivot element, scan the array and return the pivot index i.
3. if k == (i-l+1), return arr[i]
4. else if k < (i-l+1), select(arr, l, i - 1, k)
5. else if k > (i-l+1), select(arr, i + 1, h, k - (i - l + 1))

:pencil:[FindKthSmallest.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/FindKthSmallest.java)

**Time Complexity**: 
The worst case time complexity of the above solution is still O(n2). In worst case, the randomized function may always pick a corner element. 
The expected time complexity of above randomized QuickSelect is 􏰁?(n). (Proved by master method --> [MIT video lecture](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-6-order-statistics-median/)

## [10]

## Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.

    Examples:
    
    Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
    Output: 22 and 30
    
    Input: arr[] = {1, 3, 4, 7, 10}, x = 15
    Output: 4 and 10
    
A simple solution is to consider every pair and keep track of closest pair (absolute difference between pair sum and x is minimum). Time complexity of this solution is O(n2)

An efficient solution can find the pair in **O(n)** time. Following is detailed algorithm.

    1) Initialize a variable diff as infinite (Diff is used to store the 
       difference between pair and x).  We need to find the minimum diff.
    2) Initialize two index variables l and r in the given sorted array.
           (a) Initialize first to the leftmost index:  l = 0
           (b) Initialize second  the rightmost index:  r = n-1
    3) Loop while l < r.
           (a) If  abs(arr[l] + arr[r] - x) < diff  then 
               update diff and result 
           (b) Else if(arr[l] + arr[r] < x) then l++
           (c) Else r--  
           
:pencil:[MinDiffPair.java](../../../../java/com/kellylin1115/interview/algorithms/sortingsearching/MinDiffPair.java)

 