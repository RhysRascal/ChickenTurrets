package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Texture cursor;
	Enemy chicken;
	int cX = 0 ;
	int cY = 300;
	int goalX, goalY;
	int[] pathX = new int[16];
	int[] pathY = new int[16];
	float dt;
	int time;
	int count=0;



	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cursor = new Texture("cursor.png");
		bg = new Background(800, 400,new Texture("Mapv1.png"));
		chicken = new Enemy(1,40,40,0,0,0.1f, new Texture("Chicken.png"), cX, cY);
		time = 0;
		dt = Gdx.graphics.getDeltaTime();






	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game();
		dt = Gdx.graphics.getDeltaTime();
		time += 1;

		Gdx.app.log("", "" + cX);

		chicken.x = cX;
		chicken.y = cY;

		batch.begin();
		batch.draw(bg.image, 0, 0);
		batch.draw(chicken.sprite, cX,cY);

		batch.end();
	}


	public void game(){


	cX += 1;

	if(cX > 150 && cX < 200){
		cY -= 1;
	}
	if(cX > 200 && cX < 300){
		cY -= 2;
	}
	if(cX> 375 && cX < 500 ){
		cY = cY;
	}
	if(cX > 500  && cX < 575){
		cY += 3;
	}
	if(cX > 575){
		cY = cY;
	}



	}


	@Override
	public void dispose () {
		batch.dispose();
		bg.image.dispose();
	}
}
