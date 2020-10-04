# Task 1 - Arrays
char [] charArray1 = {'s', 't', 'r', 'i', 'n', 'g'};

char [] charArray2 = {'s', 'i', 'n', 'g'};

detectTInArray (charArray1);

detectTInArray (charArray2);

Build a program that can receive an Array of letters. The program must check if the input contains a 't'. If the program finds a 't', the program must type true to the screen otherwise false. The program should also handle if the input changes to other char arrays.

When this is built and works correctly, you can start developing the program through the sub-points below. Remember to print charArray1 and charArray2 and which sub-point to the screen after each sub-point up to e). This should be a separate function.

The program will now also change all 'r' it finds to 't'.
After printing true, the program should find the 't' field and change it to uppercase. The code for this should be in a separate method called from inside detectTInArray (). For example: toUppercase (char [] x);
Now you will create a method that removes duplicates in your array. This method should be called at the end of detectTInArray ().
Create a function that compares charArray1 and charArray2 and sees if they are equal. If so, the program should print "Array 1 and Array 2 are identical". This function should be called at the beginning of the program but after the calls to detectTInArray () are made.
The program should now have an input field. The field should receive all forms of input but the input should be checked and then inserted into a char array of length 3. If this array is filled, the program should ask for new input. In this input, a number must be entered for which place in your array is to be replaced with the new value. The program will then insert the new value at the requested location and print out your array. When this is done, the program must request new input if input is empty, the program must be interrupted.
Create a String array with a location. After the program has inserted a new value in e), a new method must be called that puts all values ​​from e) in one place in your new String array. This should happen every time a new input comes in, but from the time input no. 2 onwards, your String array locations should increase and the value should be entered in the new location. Then print out your array.
From the method in f), a new method must be called each time a new value is inserted into your String array. The method must be functional and use recursion. The method should print all the values ​​in your String array to the screen. The text should be printed as a String.
(Extra task)
Now you should build a selection at the beginning of the program. Either you can start the program so earlier with an input field or an input field is given where only one int may be specified. Then the program should run as before but instead of user input it should be random input from the alphabet X times where X is the int value in input. When this works, feel free to try to push the boundaries of your program and think about where and why the program will have problems when you increase your int?
Skicka feedback
Historik
Sparad
Grupp
