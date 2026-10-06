package com.threedxcandy;

public final class CandyResult {

    public enum Type {
        PLAYING,
        WON,
        LOST
    }

    private Type type;
    private int level;
    private int score;
    private int movesLeft;

    public CandyResult() {
        type = Type.PLAYING;
        level = 1;
        score = 0;
        movesLeft = 25;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public boolean isPlaying() {
        return type == Type.PLAYING;
    }

    public boolean isWon() {
        return type == Type.WON;
    }

    public boolean isLost() {
        return type == Type.LOST;
    }

    public void update(
            int level,
            int score,
            int movesLeft
    ) {
        this.level = level;
        this.score = score;
        this.movesLeft = movesLeft;
    }

    public void win() {
        type = Type.WON;
    }

    public void lose() {
        type = Type.LOST;
    }

    public void reset() {
        type = Type.PLAYING;
        level = 1;
        score = 0;
        movesLeft = 25;
    }
}
