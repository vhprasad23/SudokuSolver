SudokuSolver
============

Sudoku Solver - Insight Data Engineering

This project implements a Sudoku puzzle solver in Java. It takes as input a CSV file consisting of an unsolved Sudoku with 0's representing blanks, and outputs a CSV file with the solved Sudoku. For instance, the input CSV file can look like the following:

0,3,5,2,9,0,8,6,4  
0,8,2,4,1,0,7,0,3  
7,6,4,3,8,0,0,9,0  
2,1,8,7,3,9,0,4,0  
0,0,0,8,0,4,2,3,0  
0,4,3,0,5,2,9,7,0  
4,0,6,5,7,1,0,0,9  
3,5,9,0,2,8,4,1,7  
8,0,0,9,0,0,5,2,6  

which represents:  
![alt text](https://github.com/vhprasad23/SudokuSolver/blob/master/SudokuSolver/Images/unsolved_sudoku.png )



The output should be:

1,3,5,2,9,7,8,6,4  
9,8,2,4,1,6,7,5,3  
7,6,4,3,8,5,1,9,2  
2,1,8,7,3,9,6,4,5  
5,9,7,8,6,4,2,3,1  
6,4,3,1,5,2,9,7,8  
4,2,6,5,7,1,3,8,9  
3,5,9,6,2,8,4,1,7  
8,7,1,9,4,3,5,2,6  

which represents:  

![alt text][logo]

[logo]: https://github.com/vhprasad23/SudokuSolver/blob/master/SudokuSolver/Images/solved_sudoku.png  


SudokuSolver implements 2 core funcionalities - display and solver. To use this project, place the input CSV files in the InputCSV directory and provide the filename in the DisplaySudoku class. The output CSV file is generated in the OutputCSV directory with the following naming convention : Solved\<Inputfilename\>.csv . A solved sudoku display also pops up showing the filled in values in green and provided values in white.



