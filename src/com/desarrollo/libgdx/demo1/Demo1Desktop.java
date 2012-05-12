package com.desarrollo.libgdx.demo1;
import com.badlogic.gdx.backends.jogl.JoglApplication;
//import com.badlogic.gdx.tools.imagepacker.TexturePacker;
//import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;
public class Demo1Desktop  {
	public static void main(String[] args)
	{
		/*
		 * Todas las imagenes dentro del directorio
		 * imagenes que asu ves esta dentro del directorio data, forman una sola imagen
		 * de 1024x1024, con la herramienta TexturePacker, para que sea facilmente utilziado 
		 * por OpenGl
		 * */
		//Settings conf =new Settings();
		//conf.padding=2;
		//conf.maxHeight=1024;
		//conf.maxHeight=1024;
		//conf.incremental=true;
		//TexturePacker.process(conf,"images","data");
		/*
		 * Fin del paquete de texturas
		 * */
		new JoglApplication(new Demo1Game(),"Demo1",320,400,false);
	}
}