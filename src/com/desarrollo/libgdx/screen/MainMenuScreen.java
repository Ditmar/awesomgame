package com.desarrollo.libgdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.desarrollo.libgdx.demo1.Assets;
import com.desarrollo.libgdx.demo1.Demo1Game;

public class MainMenuScreen implements Screen{

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	BoundingBox startbutton;
	Demo1Game maingame;
	Vector3 touch;
	public MainMenuScreen(Demo1Game g){
		/*
		 * Definimos la camara, 
		 * simulando metricas entre 10 y 15
		 * segùn la resolucion de 32 pixeles
		 * */
		maingame=g;
		guiCam=new OrthographicCamera(10,15);
		guiCam.position.set(10f/2,15f/2, 0);
		batcher=new SpriteBatch();
		startbutton=new BoundingBox(new Vector3(2,3,0),new Vector3(8,6,0));
		touch=new Vector3();
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batcher.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Dibujamos 
	 * */
	float x=0;
	float c=0.01f;
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		if(Gdx.input.justTouched())
		{
			guiCam.unproject(touch.set(Gdx.input.getX(),Gdx.input.getY(),0));
			if(startbutton.contains(touch))
			{
				maingame.setScreen(maingame.mainscene);
				return;
			}
		}
		
		GL10 gl=Gdx.graphics.getGL10();
		gl.glClearColor(0,0,0,1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		/*
		 * Actualiza los parametros de la camara
		 * y los enlaza al objeto de renderizado batcher
		 * */
		guiCam.update();
		this.batcher.setProjectionMatrix(this.guiCam.combined);
		/*
		 * Desactiva las trasnparencias
		 * */
		batcher.disableBlending();
		batcher.begin();
		batcher.draw(Assets.background, 0, 0, 10, 15);
		batcher.end();
		batcher.enableBlending();
		batcher.begin();
		batcher.draw(Assets.title,1,6, 8, 8);
		batcher.draw(Assets.start, x, 3, 6, 3);
		x+=c;
		batcher.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}
