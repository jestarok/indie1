package com.jesus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.MapProperties;

public class GdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameObject gameob;
	Player player;
	TiledMap tiledmap;
	OrthographicCamera cam;
	TiledMapRenderer maprender;
	float width;
	float height;
	int lvlpxlwidth;
	int lvlpxlheight;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		cam =  new OrthographicCamera();
		cam.setToOrtho(false,width,height);
		cam.update();
		tiledmap = new  TmxMapLoader().load("Levels\\debugroom.tmx");
		maprender = new OrthogonalTiledMapRenderer(tiledmap);
		TextManager.setBatchHandle(batch);
		Texture playertexture = new Texture("crpynin1.png");
		player = new  Player(playertexture, 200, 500);
		img = new Texture("badlogic.jpg");
		gameob = new GameObject("crpynin1.png", batch, 100, 100);
		
		MapProperties mapprop = tiledmap.getProperties();
		int lvlwidth = mapprop.get("width",Integer.class);
		int lvlheight = mapprop.get("height",Integer.class);
		int tilewidth = mapprop.get("tilewidth",Integer.class);
		int tileheight = mapprop.get("tileheight",Integer.class);
		lvlpxlwidth = lvlwidth * tilewidth;
		lvlpxlheight = lvlheight * tileheight;
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA,GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		GameInput.Update();
		gameob.changePosistion();
		//cam.position.set(gameob.getX(),gameob.getY(),0);
		
		cam.position.x = Math.min(Math.max(gameob.getX(), width/2), lvlpxlwidth - (width/2));
		cam.position.y = Math.min(Math.max(gameob.getY(), height/2), lvlpxlheight - (height/2));
		cam.update(); 
		Time.update();
		player.Update();
		maprender.setView(cam);
		maprender.render();
		
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		player.draw(batch);
		gameob.Draw();
		TextManager.draw("FPS: "+ Gdx.graphics.getFramesPerSecond()+" Time: "+ Time.time,cam);
		batch.end();
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){Gdx.app.exit();}
	}
}
