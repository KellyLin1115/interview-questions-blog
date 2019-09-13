:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

🌿 [Algorithms](index-algorithms.md)

# String / Array

1. [Reverse an array without affecting special characters](#1)
2. [All Possible Palindromic Partitions](#2-all-possible-palindromic-partitions)
3. [Count triplets with sum smaller than a given value](#3)
4. [Convert array into Zig-Zag fashion](#4)

## [1]
## [Reverse an array without affecting special characters]
Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

Examples:

    Input:   str = "a,b$c"
    Output:  str = "c,b$a"
    Note that $ and , are not moved anywhere.  
    Only subsequence "abc" is reversed
    
    Input:   str = "Ab,c,de!$"
    Output:  str = "ed,c,bA!$"
    
**Solution**:

    1) Let input string be 'char[] str' and length of string be 'n'
    2) l = 0, r = n-1
    3) While l is smaller than r, do following
        a) If str[l] is not an alphabetic character, do l++
        b) Else If str[r] is not an alphabetic character, do r--
        c) Else swap str[l] and str[r]
    
:pencil:[ReverseWithoutSpecial.java](../../../../java/com/kellylin1115/interview/algorithms/stringarray/ReverseWithoutSpecial.java)

## [2 All Possible Palindromic Partitions]
Given a string, find all possible palindromic partitions of given string.

Example:

![](../../images/algorithms/all-palindrom-partition.png)

We have to list the all possible partitions so we will think in the direction of recursion. When we are on index i, we incrementally check all substrings starting from i for being palindromic. If found, we recursively solve the problem for the remaining string and add this in our solution.

**Solution**:

1. We will maintain a 2-dimensional vector for storing all possible partitions and a temporary vector for storing the current partition, new starting index of string to check partitions as we have already checked partitions before this index.
2. Now keep on iterating further on string and check if it is palindrome or not.
3. If it is a palindrome than add this string in current partitions vector. Recurse on this new string if it is not the end of the string. After coming back again change the current partition vector to the old one as it might have changed in the recursive step.
4. If we reach the end of string while iterating than we have our partitions in our temporary vector so we will add it in results.

:pencil:[PrintAllPalindrome.java](../../../../java/com/kellylin1115/interview/algorithms/stringarray/PrintAllPalindrome.java)

## [3]
## [Count triplets with sum smaller than a given value]
Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

**Simple Solution** : run three loops to consider all triplets one by one. Time complexity is O(n3).

**Solution**: Time complexity is O(n2)

1) Sort the input array in increasing order.

2) Initialize result as 0.

3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all triplets with arr[i] as first element.
     
     a) Initialize other two elements as corner elements of sub array arr[i+1..n-1], i.e., j = i+1 and k = n-1
     
     b) Move j and k toward each other until they meet: 
        while(j < k)
            if (arr[i] + arr[j] + arr[k] >= sum), then do k--
            else do res += (k - j) followed by j++ 
                     
:pencil:[CountTriplets.java](../../../../java/com/kellylin1115/interview/algorithms/stringarray/CountTriplets.java)
  
## [4]
## [Convert array into Zig-Zag fashion]
Given an array of **DISTINCT** elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form **a < b > c < d > e < f**.

Example:

    Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
    Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
    
    Input: arr[] = {1, 4, 3, 2}
    Output: arr[] = {1, 4, 2, 3} 

**Solution**:

We can convert in **O(n)** time using a modified one pass of bubble sort.

* Maintain a flag for representing which order(i.e. < or >) currently we need.
* If the current two elements are not in that order then swap those elements otherwise not.

Let us see the main logic using three consecutive elements A, B, C:

Suppose we are processing B and C currently and the current relation is ‘<', but we have B > C. Since current relation is ‘<' previous relation must be '>‘ i.e., A must be greater than B. So, the relation is A > B and B > C. We can **deduce A > C**. So if we **swap** B and C then the relation is A > C and C < B. Finally we get the desired order **A C B**

:pencil:[ConvertZigZag.java](../../../../java/com/kellylin1115/interview/algorithms/stringarray/ConvertZigZag.java)


 