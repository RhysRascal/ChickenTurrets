package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import java.awt.Polygon;
import java.awt.geom.Arc2D;

import sun.awt.geom.Curve;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Texture cursor;
	Enemy chicken;
	Tower test;
	Texture ready;
	Texture notReady;
	Circle Tradius;
	Rectangle straightP;
	Polygon joinP;
	Polygon fRect;
	Arc2D downP, upP;
	Texture triangle;

	float triX=137, triY=436;
	float tX=0, tY=80;
	float cX = 3 ;
	float cY = 440;
	int goalX, goalY;
	int[] pathX = new int[16];
	int[] pathY = new int[16];
	float dt;
	int time;
	int point=0;
	boolean loc = false;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cursor = new Texture("cursor.png");
		bg = new Background(800, 400,new Texture("Mapv3.png"));
		chicken = new Enemy(1,40,40,0,0,0.1f, new Texture("Chicken.png"), cX, cY);
		test = new Tower(10, 200, 200, 1, 0, null, 0, new Texture("tower.png"), tX, tY);
		triangle = new Texture("triPiece.png");
		Tradius = new Circle();
		Tradius.x = 295;
		Tradius.y = 75;
		Tradius.setRadius(60);
		time = 0;
		dt = Gdx.graphics.getDeltaTime();
		straightP = new Rectangle();
		straightP.width = 135;
		straightP.height = 57;
		straightP.x = 2;
		straightP.y = Gdx.graphics.getHeight() - 164;

		fRect = new Polygon();
		fRect.npoints = 4;

//		fRect.xpoints[0]
//		fRect.xpoints[1];
//		fRect.xpoints[2];
//		fRect.xpoints[3];
//
//		fRect.ypoints[0];
//		fRect.ypoints[1];
//		fRect.ypoints[2];
//		fRect.ypoints[3];




		joinP = new Polygon();
		joinP.npoints = 3;
		joinP.xpoints[0] = 137;
		joinP.xpoints[1] = 135;
		joinP.xpoints[2] = 176;

		joinP.ypoints[0] = Gdx.graphics.getHeight() - 108;
		joinP.ypoints[1] = Gdx.graphics.getHeight() - 166;
		joinP.ypoints[2] = Gdx.graphics.getHeight() - 125;


		ready = new Texture("towerready.png");
		notReady = new Texture("towernotready.png");



	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//		int tX = Gdx.input.getX() - 100;
//		int tY = -Gdx.input.getY() + 200;


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

		batch.draw(triangle,triX,triY);
		batch.draw(cursor, Tradius.x,Tradius.y);
		batch.draw(test.image, tX,tY);

//		if(loc){
//			batch.draw(test.image, tX, tY);
//		}



		batch.end();



	}


	public void game(){

		towerDamage();

		enemyMovement();

		towerPlacement();




	}

	private void towerDamage() {

		if(joinP.contains(cX,cY) || straightP.contains(cX,cY)){
//			Gdx.app.log("","Within");
		}

	}

	private void towerPlacement() {
//		int curX = Gdx.input.getX() - 100;
//		int curY = -Gdx.input.getY() + 200;
//		if(Gdx.input.isKeyPressed(Input.Keys.T)){
//
//			batch.draw(ready,curX, curY);
//
//			if(Gdx.input.isTouched()){
//				loc = true;
//			}
//
//		}





	}

	private void enemyMovement() {


	}


	@Override
	public void dispose () {
		batch.dispose();
		bg.image.dispose();
	}
}
