:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

🌿 [Algorithms](index-algorithms.md)

# String / Array

1. [Reverse an array without affecting special characters](#1)

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

