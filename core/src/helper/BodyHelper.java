package helper;

import com.badlogic.gdx.physics.box2d.*;
public class BodyHelper {

    public static Body createBody(float x, float y, float width, float height, boolean isStatic, World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;

        bodyDef.position.set((x * 2) / Constants.PPM, (y * 2) / Constants.PPM);

        bodyDef.fixedRotation = true; // important! prevents rotation
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();

        shape.setAsBox((width/2/ Constants.PPM), (height/2/ Constants.PPM));

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }
}
