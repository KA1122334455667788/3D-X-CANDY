package com.threedxcandy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ResultScreen extends InputAdapter implements Screen {

    private final CandyGame game;
    private final CandyResult result;

    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final ShapeRenderer shapes;
    private final BitmapFont font;
    private final GlyphLayout layout;

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
        layout = new GlyphLayout();

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
                0.04f,
                0.10f,
                1f
        );

        Gdx.gl.glClear(
                GL20.GL_COLOR_BUFFER_BIT
        );

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        shapes.setProjectionMatrix(camera.combined);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        shapes.begin(ShapeRenderer.ShapeType.Filled);

        shapes.setColor(
                0.12f,
                0.13f,
                0.22f,
                1f
        );

        shapes.rect(
                width * 0.08f,
                height * 0.20f,
                width * 0.84f,
                height * 0.60f
        );

        shapes.setColor(
                result.isWon()
                        ? 0.20f
                        : 0.80f,
                result.isWon()
                        ? 0.85f
                        : 0.15f,
                result.isWon()
                        ? 0.45f
                        : 0.20f,
                1f
        );

        shapes.circle(
                width / 2f,
                height * 0.68f,
                32f
        );

        shapes.end();

        batch.begin();

        if (result.isWon()) {

            font.getData().setScale(2.2f);

            drawCentered(
                    "YOU WIN!",
                    width / 2f,
                    height * 0.62f
            );

        } else {

            font.getData().setScale(2.0f);

            drawCentered(
                    "GAME OVER",
                    width / 2f,
                    height * 0.62f
            );
        }

        font.getData().setScale(1.2f);

        drawCentered(
                "LEVEL: " + result.getLevel(),
                width / 2f,
                height * 0.50f
        );

        drawCentered(
                "SCORE: " + result.getScore(),
                width / 2f,
                height * 0.44f
        );

        drawCentered(
                "MOVES: " + result.getMovesLeft(),
                width / 2f,
                height * 0.38f
        );

        font.getData().setScale(1.5f);

        drawCentered(
                result.isWon()
                        ? "TAP TO CONTINUE"
                        : "TAP TO TRY AGAIN",
                width / 2f,
                height * 0.28f
        );

        batch.end();
    }

    private void drawCentered(
            String text,
            float centerX,
            float y
    ) {
        layout.setText(font, text);

        font.draw(
                batch,
                text,
                centerX - layout.width / 2f,
                y
        );
    }

    @Override
    public boolean touchDown(
            int screenX,
            int screenY,
            int pointer,
            int button
    ) {

        result.reset();

        game.setScreen(
                new CandyScreen(game)
        );

        return true;
    }

    @Override
    public void resize(
            int width,
            int height
    ) {
        camera.setToOrtho(
                false,
                width,
                height
        );
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void show() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapes.dispose();
        font.dispose();
        layout.reset();
    }
}
