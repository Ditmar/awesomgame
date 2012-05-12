package com.desarrollo.libgdx.demo1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.desarrollo.libgdx.screen.MainGame;
import com.desarrollo.libgdx.screen.MainMenuScreen;
import com.desarrollo.pathfiding.PathFinding;

public class Demo1Game extends Game {

	public Screen mainmenu;
	public Screen mainscene;
	@Override
	public void create() {
		Assets.load();
		mainmenu=new MainMenuScreen(this);
		this.setScreen(mainmenu);
		mainscene=new MainGame();
		/*Vector vec=new Vector();
		vec.add("ghola");
		vec.add(this);
		System.out.print(" "+vec.size());*/
		/*
		 * Testing
		 * */
		PathFinding r=new PathFinding();
		r.matriz[2][1].walk=1;
		r.setRoute(r.matriz[2][1], r.matriz[2][5]);
		
				
	}

}
