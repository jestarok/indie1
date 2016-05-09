package com.jesus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject {

	private float x = 0, y = 0, speed = 3f;
	private Texture texture;
	private SpriteBatch batchhandle;
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public GameObject(String texture_path,SpriteBatch batch,float posX, float posY) {
		this.texture = new Texture(texture_path); 
		batchhandle = batch;
		x = posX;
		y = posY;
	}
	
	public void changePosistion(){
		
		x += GameInput.keyforce.x * speed * Time.time;
		y += GameInput.keyforce.y * speed * Time.time;
	}
	
	public void Draw(){
		batchhandle.draw(texture, x, y);
	}

}
