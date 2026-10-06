package com.threedxcandy;

import com.badlogic.gdx.Game;

public class CandyGame extends Game {

    @Override
    public void create() {
        setScreen(new CandyScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
