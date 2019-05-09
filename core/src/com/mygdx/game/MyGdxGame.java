package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

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
	Rectangle straightP, straightP2, straightP3;
	Polygon joinP, join2, join3, join4;
	Polygon fRect,fRect2, sRect1, sRect2;
	Texture triangle, tri2, tri3, tri4;
	Texture anglRect, anglRect2;
	Texture rect;
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
	ArrayList<Texture> towers = new ArrayList<Texture>();


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cursor = new Texture("cursor.png");
		bg = new Background(800, 400,new Texture("mapBlank.png"));
		chicken = new Enemy(1,40,40,0,0,0.1f, new Texture("Chicken.png"), cX, cY);
		test = new Tower(10, 200, 200, 1, 0, null, 0, new Texture("tower.png"), tX, tY);
		triangle = new Texture("triPiece.png");
		tri2 = new Texture("triPiece2.png");
		tri3 = new Texture("triPiece3.png");
		tri4 = new Texture("triPiece4.png");
		anglRect = new Texture("fRect.png");
		anglRect2 = new Texture("sRect.png");
		rect  = new Texture("rectPiece.png");
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

		straightP2 = new Rectangle();
		straightP2.width = 135;
		straightP2.height = 57;
		straightP2.x = 368;
		straightP2.y = Gdx.graphics.getHeight() - 373;

		straightP3 = new Rectangle();
		straightP3.width = 135;
		straightP3.height = 57;
		straightP3.x = 735;
		straightP3.y = Gdx.graphics.getHeight() - 165;

		fRect = new Polygon();
		fRect.npoints = 4;

		fRect.xpoints[0] = 138;
		fRect.xpoints[1] = 177;
		fRect.xpoints[2] = 272;
		fRect.xpoints[3] = 231;

		fRect.ypoints[0] = Gdx.graphics.getHeight() - 166;
		fRect.ypoints[1] = Gdx.graphics.getHeight() - 126;
		fRect.ypoints[2] = Gdx.graphics.getHeight() - 220;
		fRect.ypoints[3] = Gdx.graphics.getHeight() - 260;


		fRect2 = new Polygon();
		fRect2.npoints = 4;

		fRect2.xpoints[0] = 231;
		fRect2.xpoints[1] = 260;
		fRect2.xpoints[2] = 369;
		fRect2.xpoints[3] = 329;

		fRect2.ypoints[0] = Gdx.graphics.getHeight() - 260;
		fRect2.ypoints[1] = Gdx.graphics.getHeight() - 220;
		fRect2.ypoints[2] = Gdx.graphics.getHeight() - 317;
		fRect2.ypoints[3] = Gdx.graphics.getHeight() - 356;

		sRect1 = new Polygon();
		sRect1.npoints = 4;

		sRect1.xpoints[0] = 505;
		sRect1.xpoints[1] = 544;
		sRect1.xpoints[2] = 601;
		sRect1.xpoints[3] = 640;

		sRect1.ypoints[0] = Gdx.graphics.getHeight() - 316;
		sRect1.ypoints[1] = Gdx.graphics.getHeight() - 357;
		sRect1.ypoints[2] = Gdx.graphics.getHeight() - 221;
		sRect1.ypoints[3] = Gdx.graphics.getHeight() - 260;

		sRect2 = new Polygon();
		sRect2.npoints = 4;

		sRect2.xpoints[0] = 601;
		sRect2.xpoints[1] = 640;
		sRect2.xpoints[2] = 696;
		sRect2.xpoints[3] = 735;

		sRect2.ypoints[0] = Gdx.graphics.getHeight() - 221;
		sRect2.ypoints[1] = Gdx.graphics.getHeight() - 260;
		sRect2.ypoints[2] = Gdx.graphics.getHeight() - 126;
		sRect2.ypoints[3] = Gdx.graphics.getHeight() - 165;



		join4 = new Polygon();
		join4.npoints = 3;
		join4.xpoints[0] = 697;
		join4.xpoints[1] = 736;
		join4.xpoints[2] = 735;

		join4.ypoints[0] = Gdx.graphics.getHeight() - 125;
		join4.ypoints[1] = Gdx.graphics.getHeight() - 108;
		join4.ypoints[2] = Gdx.graphics.getHeight() - 165;

		join3 = new Polygon();
		join3.npoints = 3;
		join3.xpoints[0] = 505;
		join3.xpoints[1] = 505;
		join3.xpoints[2] = 544;

		join3.ypoints[0] = Gdx.graphics.getHeight() - 373;
		join3.ypoints[1] = Gdx.graphics.getHeight() - 319;
		join3.ypoints[2] = Gdx.graphics.getHeight() - 358;

		join2 = new Polygon();
		join2.npoints = 3;
		join2.xpoints[0] = 329;
		join2.xpoints[1] = 368;
		join2.xpoints[2] = 369;

		join2.ypoints[0] = Gdx.graphics.getHeight() - 357;
		join2.ypoints[1] = Gdx.graphics.getHeight() - 373;
		join2.ypoints[2] = Gdx.graphics.getHeight() - 318;

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


		game();
		dt = Gdx.graphics.getDeltaTime();
		time += 1;


//		Gdx.app.log("", "X" + cX);
//		Gdx.app.log("", "Y" + cY);

		if(Gdx.input.isTouched()){
			Gdx.app.log("", "X" + Gdx.input.getX());
			Gdx.app.log("", "Y" + Gdx.input.getY());
		}



		batch.draw(anglRect,fRect.xpoints[0],fRect.ypoints[0] - 95 );
		batch.draw(anglRect,fRect2.xpoints[0],fRect2.ypoints[0] - 95 );
		batch.draw(anglRect2,sRect1.xpoints[0],sRect1.ypoints[0] - 43);
		batch.draw(anglRect2,sRect2.xpoints[0],sRect2.ypoints[0] - 43);

		batch.draw(rect, straightP.x, straightP.y);
		batch.draw(rect, straightP2.x, straightP2.y);
		batch.draw(rect, straightP3.x, straightP3.y);
		batch.draw(tri4,join4.xpoints[0], join4.ypoints[0]-40);
		batch.draw(tri3,join3.xpoints[0], join3.ypoints[0]);
		batch.draw(tri2,join2.xpoints[0], join2.ypoints[0]-15);
		batch.draw(triangle,triX,triY);
		batch.draw(cursor, Tradius.x,Tradius.y);
		batch.draw(test.image, tX,tY);
		batch.draw(chicken.sprite, cX,cY);
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
		int curX = Gdx.input.getX();
		int curY = Gdx.graphics.getHeight() - Gdx.input.getY();
		if(Gdx.input.isKeyPressed(Input.Keys.T)){

			batch.draw(ready,curX, curY);

			if(Gdx.input.isTouched()){
				towers.add(new Texture("tower.png"));
			}

		}
		for(int i =0;i<towers.size();i++){
			int turX = curX;
			int turY = curY;

			batch.draw(towers.get(i), turX, turY);
		}







	}

	private void enemyMovement() {

		if(cX > 150 && cX < 370){
			cY--;
		}
		if(cX > 500 && cX < 735){
			cY++;
		}
			cX++;

	}


	@Override
	public void dispose () {
		batch.dispose();
		bg.image.dispose();
	}
}
