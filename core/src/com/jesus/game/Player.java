package com.jesus.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {

	public Player(Texture texture, float x, float y) {
		this.setTexture(texture);
		this.setPosition(x, y);
	}

	
	public void Update(){
		
	}
	@Override
	public void draw(Batch batch){
		batch.draw(this.getTexture(), this.getX(), this.getY());
	}
	
}
