package com.jesus.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class TextManager {

	private	static BitmapFont bfont =  new BitmapFont();
	private static SpriteBatch batchHandle;
	public static void setBatchHandle(SpriteBatch batch){
		
		bfont.setColor(Color.GREEN);
		batchHandle = batch;
	}
	public static void draw(java.lang.CharSequence msg, OrthographicCamera camera){
		Vector3 position = new Vector3(10,20,0);
		camera.unproject(position);
		bfont.draw(batchHandle, msg,position.x, position.y);
	}
	
}
