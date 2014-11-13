/**
 * ReverseGroups	Calls to kReverse with String array s and int K will reverse "groups" of size k from the string array s, from left to right.
 * @author          Paul Salmon
 */
 
 Calls to kReverse(String[], int) will return a String array reversed by groups. 
 Groups are limited in size by the integer parameter 'k', and they are reversed one element at a time.
 If a String is not evenly divisible by k, the trailing elements are left unchanged, and are appended.
 
 The test function will take the directory of a text file which is formatted as follows: 
 	Comma separated list to be reversed by groups
	Final character terminated by a semicolon, and then 'k' - the group size limitation.

ex: 1,2,3,4,5;2
A string: 12345 with k = 2. 
output:
2,1,4,3,5

ex2:
1,2,3,4,5;3
3,2,1,4,5