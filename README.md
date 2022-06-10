# NIM-Bot
This code is a two pile game of NIM that can be played by the user against the computer. 

The number of coins in each pile can be specified using the main method in the "Test.java" file. These are inputted as two integers (n1 and n2) as parameters when creating the new TwoPileGame object 'g'. These can be any natural numbers.

The user cannot win.

## How To Play
There are two players, the user and the computer. 

Each player will take turns taking an arbitrary number of coins from a either pile.

A player may take between 1 coin and the full number of coins in the pile.

The person who takes the last coin is the winner.

## The Logic
The computer uses the general theory of two pile NIM to win every game against the user.

This theory involves winning and losing positions:
- Winning Position: There exists a move leading to a losing position.
- Losing Position: Every possible move leads to a winning position.

Who has the winning strategy depends on who goes first and the number of coins in each pile:
- If the number of coins in each pile are equal (for example, 2-2) player 1 is in a losing position and player 2 has the winning strategy.
- If the number of coins in each pile are unequal (for example 1-2) player 2 is in a losing position and player 1 has he winning strategy.

This is because the goal of the game is to leave the other player in the losing positin of 0-0 coins, meaning you took the last one.

After the player decides the number of coins, the computer will determine whether the player or itself will go first. If the first position is a losing position the player will go first, if the first position is a winning position the computer will go first.
