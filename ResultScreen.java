package com.threedxcandy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.InputAdapter;

public class ResultScreen extends InputAdapter implements Screen {

    private final CandyGame game;
    private final CandyResult result;

    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final ShapeRenderer shapes;
    private final BitmapFont font;

    public ResultScreen(
            CandyGame game,
            CandyResult result
    ) {
        this.game = game;
        this.result = result;

        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        shapes = new ShapeRenderer();
        font = new BitmapFont();

        camera.setToOrtho(
                false,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(
                0.035f,
               
