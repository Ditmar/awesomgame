package com.desarrollo.pathfiding;

public class Nodos {
	public int F,H,G;
	public int costo;
	public Nodos padre;
	public int walk;
	public int x;
	public int y;
	public String type="";
	public Nodos(int g)
	{
		G=g;
	}
	public void processHManhattan(int x1,int x2,int y1,int y2)
	{
		H=(Math.abs(x2-x1)+Math.abs(y2-y1))*10;
		try{
			F=H+G;
		}catch(NumberFormatException e){
			System.out.print("G no tiene un valor asignado "+e);
		}
	}
}