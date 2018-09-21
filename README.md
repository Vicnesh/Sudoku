# Sudoku Game
Sudoku game using backtracking algorithm
------------------------------------------------------------------------------------------------------------------------------------------

For each cell in the grid, there are constraints to be followed:

1) Value can only be in the range of 1-9
2) Value of each cell cannot exist in any cell of the row
3) Value of each cell cannot exist in any cell of the column
4) Value of each cell cannot exist in any 3x3 grid in which the cell resides in

------------------------------------------------------------------------------------------------------------------------------------------

ToDo:
1) Generate a valid puzzle that abides the constraints above


------------------------------------------------------------------------------------------------------------------------------------------

Algorithm:

Solution 1:
For each cell in the 9x9 grid, the possible range of value is 1-9.
A possible solution is to generate a random number {1...9} and check if it meets the constraints.
If it does not meet the constraints, then assign number into cell.
Issue occurs when the assigned number meets the constraints. If the current generate number already exists, then generate a different number and retry. If all possible numbers {1...9} have been exhausted then, move a step back and try again.


Solution 2:
Another possible solution is to generate a number, and if the generate number already exists, store the number into the current cell and backtrack to the cell where the number exists. Remove it and try a possible solution.
Problem occurs when the generate number exists in more than 1 constraint (row/column/3x3 grid).

