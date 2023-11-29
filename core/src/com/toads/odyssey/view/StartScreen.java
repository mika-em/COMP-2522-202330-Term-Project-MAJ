package com.toads.odyssey.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.toads.odyssey.ToadsOdyssey;

public class StartScreen implements Screen {
    private ToadsOdyssey game;
    private Viewport viewport;
    private OrthographicCamera camera;

    public StartScreen(ToadsOdyssey game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(ToadsOdyssey.SCREEN_WIDTH / ToadsOdyssey.PPM, ToadsOdyssey.SCREEN_HEIGHT / ToadsOdyssey.PPM, camera);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
    public void dispose() {

    }
}
