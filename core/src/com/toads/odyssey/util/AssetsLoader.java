package com.toads.odyssey.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class AssetsLoader implements Disposable {
    public AssetManager manager;
    public final PlayerAssets playerAssets;
    public final CoinAssets coinAssets;
    public final TextureAtlas numberAtlas;;
    public static final AssetsLoader instance = new AssetsLoader();
    public AssetsLoader() {
        this.manager = new AssetManager();
        manager.load("spriteSheet.atlas", TextureAtlas.class);
        manager.load("coin.atlas", TextureAtlas.class);
        manager.load("numbers.atlas", TextureAtlas.class);
        manager.finishLoading();
        TextureAtlas atlas = manager.get("spriteSheet.atlas", TextureAtlas.class);
        TextureAtlas coinAtlas = manager.get("coin.atlas", TextureAtlas.class);
        playerAssets = new PlayerAssets(atlas);
        coinAssets = new CoinAssets(coinAtlas);
        numberAtlas = manager.get("numbers.atlas", TextureAtlas.class);


    }
    public static class PlayerAssets {
        public final Animation<TextureAtlas.AtlasRegion> idleAnimation;
        public final Animation<TextureAtlas.AtlasRegion> moveAnimation;
        public final Animation<TextureAtlas.AtlasRegion> jumpAnimation;
        public PlayerAssets(final TextureAtlas atlas) {
            Array<TextureAtlas.AtlasRegion> idleFrames = new Array<>();
            for (int i = 1; i <= 4; i++) {
                idleFrames.add(atlas.findRegion("frog_idle", i));
            }
            idleAnimation = new Animation<>(0.1f, idleFrames, Animation.PlayMode.LOOP);

            Array<TextureAtlas.AtlasRegion> moveFrames = new Array<>();
            for (int i = 1; i <= 6; i++) {
                moveFrames.add(atlas.findRegion("frog_walk", i));
            }
            moveAnimation = new Animation<>(0.1f, moveFrames, Animation.PlayMode.LOOP);

            Array<TextureAtlas.AtlasRegion> jumpFrames = new Array<>();
            for (int i = 1; i <= 2; i++) {
                jumpFrames.add(atlas.findRegion("frog_jump", i));
            }
            jumpAnimation = new Animation<>(0.1f, jumpFrames, Animation.PlayMode.LOOP);
        }
    }

    public static class CoinAssets {
        public static Animation<TextureAtlas.AtlasRegion> coinAnimation = null;
        public CoinAssets(final TextureAtlas atlas) {
            Array<TextureAtlas.AtlasRegion> coinFrames = new Array<>();
            for (int i = 1; i <= 4; i++) {
                coinFrames.add(atlas.findRegion("coin_yellow", i));
            }
            coinAnimation = new Animation<>(0.15f, coinFrames, Animation.PlayMode.LOOP);
        }

        public static TextureRegion getCoinTexture() {
            return coinAnimation.getKeyFrame(0);
        }

    }

    public CoinAssets getCoinAssets() {
        TextureAtlas atlas = manager.get("spriteSheet.atlas", TextureAtlas.class);
        return new CoinAssets(atlas);
    }

    public Array<TextureRegion> getNumberTextures(int number) {
        Array<TextureRegion> digits = new Array<>();
        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {
            String regionName = "numbers-" + digit;
            digits.add(numberAtlas.findRegion(regionName));
        }
        return digits;
    }

    @Override
    public void dispose() {
        manager.dispose();
    }

}