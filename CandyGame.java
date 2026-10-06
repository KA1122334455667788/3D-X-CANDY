package com.threedxcandy;

import com.badlogic.gdx.Game;

public class CandyGame extends Game {

    @Override
public void create() {
    setScreen(new HomeScreen(this));
}

    @Override
    public void dispose() {
        super.dispose();
    }
}
