package com.example.dramalho.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static com.example.dramalho.tictactoe.TicTacToeLogic.TTTElement.EMPTY;
import static com.example.dramalho.tictactoe.TicTacToeLogic.TTTElement.O;
import static com.example.dramalho.tictactoe.TicTacToeLogic.TTTElement.X;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create and initialize gameboard.
        final TicTacToeLogic.TTTElement[] gameState = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};

        //Make list of buttons
        final ArrayList<Button> mButtons = new ArrayList<Button>();

        //Create newgame button and set to invisible
        final Button mNewGameButton = (Button) findViewById(R.id.new_game_button);
        mNewGameButton.setVisibility(View.INVISIBLE);


        //Newgame busston must reset game state then turn invisible on click
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //reset
                for(int i = 0; i < 9; i++)
                {
                    gameState[i] = EMPTY;
                    mButtons.get(i).setText("");
                }

                mNewGameButton.setVisibility(View.INVISIBLE);

            }
        });

        mButtons.add(0, (Button) findViewById(R.id.tl));
        mButtons.add(1, (Button) findViewById(R.id.tm));
        mButtons.add(2, (Button) findViewById(R.id.tr));

        mButtons.add(3, (Button) findViewById(R.id.ml));
        mButtons.add(4, (Button) findViewById(R.id.mm));
        mButtons.add(5, (Button) findViewById(R.id.mr));

        mButtons.add(6, (Button) findViewById(R.id.bl));
        mButtons.add(7, (Button) findViewById(R.id.bm));
        mButtons.add(8, (Button) findViewById(R.id.br));


        //Generate listeners for all buttons
        for (int i = 0; i < 9; i++) {
            //make a final version of i to use inside class
            final int final_i = i;
            mButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //If valid move. i.e has not been clicked yet/does not hold a move and the game is not over then allow updates
                    if((gameState[final_i] != X) && (gameState[final_i] != O) && (!TicTacToeLogic.isGameOver(gameState)))
                    {
                        //If this button is clicked update its text with X
                        mButtons.get(final_i).setText("X");

                        //If this button is clicked update its gamestate index with X
                        gameState[final_i] = X;

                        //User has played let AI respond

                        //Determine best move
                        int bestMove = TicTacToeLogic.getBestMove(gameState);

                        //if valid moves exist
                        if(bestMove != -1 )
                        {
                            //update button with computers best move
                            mButtons.get(bestMove).setText("0"); // but what happens if bestMove == -1?

                            //update the game board with the computers best move
                            gameState[bestMove] = O;
                        }

                        // if game is over display newgame button
                        if(TicTacToeLogic.isGameOver(gameState))
                        {
                            mNewGameButton.setVisibility(View.VISIBLE);
                        }
                    }
                }
            });
        }


    }
}
