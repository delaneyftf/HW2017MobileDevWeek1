package com.example.dramalho.tictactoe;

import org.junit.Test;

import static com.example.dramalho.tictactoe.TicTacToeLogic.TTTElement.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest  {
    @Test
    public void gameState1() throws Exception {

        //Create and initialize gameboard.
        final TicTacToeLogic.TTTElement[] gameState = {X, EMPTY, EMPTY, X, O, EMPTY, EMPTY, EMPTY, EMPTY};
        int bestMove = TicTacToeLogic.getBestMove(gameState);
        assertEquals(bestMove, 6);
    }

    @Test
    public void gameState2() throws Exception {

        //Create and initialize gameboard.
        final TicTacToeLogic.TTTElement[] gameState = {O, O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int bestMove = TicTacToeLogic.getBestMove(gameState);
        assertEquals(bestMove, 2);
    }

    @Test
    public void gameState3() throws Exception {

        //Create and initialize gameboard.
        final TicTacToeLogic.TTTElement[] gameState = {O, O, X, X, O, X, O, X, X};
        int bestMove = TicTacToeLogic.getBestMove(gameState);
        assertEquals(bestMove, -1);
    }
}