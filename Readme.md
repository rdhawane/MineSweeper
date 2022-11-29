# Minesweeper

Minesweeper is a single-player computer game where an N x N square matrix has certain number of mines, i.e, bombs, hidden across the board. The remaining cells are either blank or have a number behind them. The numbers represent the number of bombs hidden in the surrounding eight cells. If the cell is blank, all adjacent blank cells (up to and including the surrounding numeric cells) would be exposed.

The player wins when all non-bomb cells are exposed. The game also allows the player to flag certain cells as potential bombs. Flagging does not affect the game other than just to block the cells from accidentally getting clicked.


## Build
1. clone repository to your local computer
2. run mvn clean install in project directory


## How to manually import in IntelliJ
1. Download zip
2. unzip project
3. IntelliJ > File > New > Project from existing sources > Maven > Next > Finish

## How to play (console view)

```
java -jar .\Minesweeper-1.0.jar

Enter count of rows (>3): <countOfRows>
Enter count of columns (>3): <countOfColumns>
Please type game difficulty level in Capital Letters from below option
  EASY
  MEDIUM
  HARD
  
  EASY
  <Newly created game board will be visible>
  
  Command: 
    User can select at a time one action from below list
- help
- open <row> <col>
- mark <row> <col>
- exit
```

Example:
```
java -jar .\Minesweeper-1.0.jar

Enter count of rows (>3): 12
Enter count of columns (>3): 12
Please type game difficulty level in Capital Letters from below option
  EASY
  MEDIUM
  HARD
  
  EASY
   | 0  1  2  3  4  5  6  7  8  9 10 11 
---|------------------------------------
 0 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 1 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 2 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 3 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 4 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 5 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 6 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 7 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 8 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 9 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
10 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
11 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 

Command: help

The following commands are available:
 - open <row> <col>     Use to open an unvisited cell
 - o <row> <col>        Use to open an unvisited cell
 - mark <row> <col>     Use to mark an unvisited cell as a mine
 - m <row> <col>        Use to mark an unvisited cell as a mine
 - exit

  | 0  1  2  3  4  5  6  7  8  9 10 11 
---|------------------------------------
 0 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 1 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 2 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 3 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 4 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 5 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 6 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 7 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 8 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
 9 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
10 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  · 
11 | ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·  ·

Command: open 5 5

   | 0  1  2  3  4  5  6  7  8  9 10 11 
---|------------------------------------
 0 | ·  ·  ·  1     1  ·  ·  ·  ·  ·  · 
 1 | ·  ·  ·  1     1  ·  ·  ·  ·  ·  · 
 2 | ·  ·  3  1     1  1  1  1  ·  ·  · 
 3 | 1  1  1                 1  ·  ·  · 
 4 |                         1  ·  ·  · 
 5 |                         1  ·  ·  · 
 6 |                         1  ·  ·  · 
 7 |    1  2  2  1     1  1  1  ·  ·  · 
 8 |    1  ·  ·  1     1  ·  ·  ·  ·  · 
 9 |    1  2  2  1     1  1  1  ·  ·  · 
10 |                         1  ·  ·  · 
11 |                         1  ·  ·  · 

Command: mark 1 6

   | 0  1  2  3  4  5  6  7  8  9 10 11 
---|------------------------------------
 0 | ·  ·  ·  1     1  ·  ·  ·  ·  ·  · 
 1 | ·  ·  ·  1     1  @  ·  ·  ·  ·  · 
 2 | ·  ·  3  1     1  1  1  1  ·  ·  · 
 3 | 1  1  1                 1  ·  ·  · 
 4 |                         1  ·  ·  · 
 5 |                         1  ·  ·  · 
 6 |                         1  ·  ·  · 
 7 |    1  2  2  1     1  1  1  ·  ·  · 
 8 |    1  ·  ·  1     1  ·  ·  ·  ·  · 
 9 |    1  2  2  1     1  1  1  ·  ·  · 
10 |                         1  ·  ·  · 
11 |                         1  ·  ·  · 

Command: exit

...
```

