package com.desarrollo.libgdx.demo1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {
	public static TextureAtlas atlas;
	public static AtlasRegion background;
	public static AtlasRegion ball;
	public static AtlasRegion bar;
	public static AtlasRegion horizontal;
	public static AtlasRegion start;
	public static AtlasRegion title;
	public static AtlasRegion vertical;
	public static void load()
	{
		atlas=new TextureAtlas(Gdx.files.internal("data/pack"));
		background=atlas.findRegion("background");
		ball=atlas.findRegion("ball");
		bar=atlas.findRegion("bar");
		horizontal=atlas.findRegion("horizontal");
		start=atlas.findRegion("star");
		title=atlas.findRegion("title");
		vertical=atlas.findRegion("verticalL");
		
	}
	public static void dispose()
	{
		atlas.dispose();
	}
}
