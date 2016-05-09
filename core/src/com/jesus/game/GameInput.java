package com.jesus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.math.Vector2;

public class GameInput{

	public static Vector2 keyforce = new Vector2();
	
	public static void Update(){
		keyforce.x = 0;
		if(Gdx.input.isKeyPressed(Keys.A)||Gdx.input.isKeyPressed(Keys.LEFT)){
			keyforce.x -= 1;
		}
		if(Gdx.input.isKeyPressed(Keys.D)||Gdx.input.isKeyPressed(Keys.RIGHT)){
			keyforce.x += 1;
		}
		
		keyforce.y = 0;
		if(Gdx.input.isKeyPressed(Keys.W)||Gdx.input.isKeyPressed(Keys.UP)){
			keyforce.y += 1;
		}
		if(Gdx.input.isKeyPressed(Keys.S)||Gdx.input.isKeyPressed(Keys.DOWN)){
			keyforce.y -= 1;
		}
		
	}
}
