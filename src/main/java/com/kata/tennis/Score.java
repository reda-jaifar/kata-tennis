package com.kata.tennis;

public enum Score {
    LOVE(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3),
    ADVANTAGE(4),
    WINS(5);

    private final int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Score increment() {
        return this.ordinal() < Score.values().length - 1 ? Score.values()[this.ordinal() + 1] : this;
    }

    public Score decrement() {
        if(this.ordinal() == 4) {
            return Score.values()[this.ordinal() - 1];
        }
        return this;
    }
}
