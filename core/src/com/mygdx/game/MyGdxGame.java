package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sun.awt.geom.Curve;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Texture cursor;
	Enemy chicken;
	Tower test;
	Texture ready;
	Texture notReady;
	float tX=0, tY=0;
	float cX = 0 ;
	float cY = 280;
	int goalX, goalY;
	int[] pathX = new int[16];
	int[] pathY = new int[16];
	float dt;
	int time;
	int point=0;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cursor = new Texture("cursor.png");
		bg = new Background(800, 400,new Texture("Mapv1.png"));
		chicken = new Enemy(1,40,40,0,0,0.1f, new Texture("Chicken.png"), cX, cY);
		test = new Tower(10, 200, 200, 1, 0, null, 0, new Texture("tower.png"), tX, tY);

		time = 0;
		dt = Gdx.graphics.getDeltaTime();

		ready = new Texture("towerready.png");
		notReady = new Texture("towernotready.png");



	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



//		chicken.x = cX;
//		chicken.y = cY;

		batch.begin();
		batch.draw(bg.image, 0, 0);
		batch.draw(chicken.sprite, cX,cY);

		game();
		dt = Gdx.graphics.getDeltaTime();
		time += 1;

//		Gdx.app.log("", "X" + cX);
//		Gdx.app.log("", "Y" + cY);

		if(Gdx.input.isTouched()){
			Gdx.app.log("", "X" + Gdx.input.getX());
			Gdx.app.log("", "Y" + Gdx.input.getY());
		}



		batch.end();



	}


	public void game(){

		enemyMovement();

		towerPlacement();




	}

	private void towerPlacement() {
		int curX = Gdx.input.getX() - 100;
		int curY = -Gdx.input.getY() + 200;
		if(Gdx.input.isKeyPressed(Input.Keys.T)){

			batch.draw(ready,curX, curY);
		}

		if(Gdx.input.isTouched()){
			batch.draw(test.image, curX, curY);
		}



	}

	private void enemyMovement() {


	}


	@Override
	public void dispose () {
		batch.dispose();
		bg.image.dispose();
	}
}
