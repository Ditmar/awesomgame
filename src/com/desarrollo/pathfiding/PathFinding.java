package com.desarrollo.pathfiding;

import java.util.Vector;

public class PathFinding {
	public Nodos matriz[][];
	Vector<Nodos> listaAbierta;
	Vector<Nodos> listaCerrada;
	Vector<Nodos> route;
	Nodos ultimonodo;
	int encontrado=0;
	public PathFinding()
	{
		initialize();
	}
	
	public void initialize()
	{
		matriz=new Nodos[Mapa.matriz.length][Mapa.matriz[0].length];
		for(int i=0;i<Mapa.matriz.length;i++)
		{
			for(int j=0;j<Mapa.matriz[i].length;j++)
			{
				Nodos node;
				if(Mapa.matriz[i][j]==1)
				{
					node=new Nodos(0);
				}else
				{
					node=new Nodos(0);
				}
				node.walk=Mapa.matriz[i][j];
				node.x=i;
				node.y=j;
				matriz[i][j]=node;
			}
		}
	}
	public void setRoute(Nodos inicial,Nodos fin)
	{
		listaAbierta=new Vector<Nodos>();
		listaCerrada=new Vector<Nodos>();
		listaAbierta.add(inicial);
		ultimonodo=inicial;
		while(encontrado==0)
		{
			ultimonodo=searchMenor();
			listaCerrada.add(ultimonodo);
			listaAbierta.remove(ultimonodo);
			calcNodes(ultimonodo,fin);
		}
		
		route=new Vector<Nodos>();
		Nodos ss=listaAbierta.get(listaAbierta.size()-1);
		while(!ss.padre.equals(inicial))
		{
			route.add(ss.padre);
			ss=matriz[ss.padre.x][ss.padre.y];
		}
		System.out.println(route.size());
		for(int i=0;i<route.size();i++)
		{
			System.out.println(" "+route.get(i).F+"  x="+route.get(i).x+" y="+route.get(i).y);
		}
		
	}
	 void calcNodes(Nodos inicial,Nodos fin)
	{
		if(inicial.x-1>=0&&inicial.y-1>=0&&matriz[inicial.x-1][inicial.y-1].walk==0&&matriz[inicial.x-1][inicial.y].walk==0){
			if(this.searchCloseList(matriz[inicial.x-1][inicial.y-1])==0)
			{
				this.searchOpenList(matriz[inicial.x-1][inicial.y-1],fin,14);
			}
			
		}
		if(inicial.y-1>=0&&matriz[inicial.x][inicial.y-1].walk==0)
		{
			if(this.searchCloseList(matriz[inicial.x][inicial.y-1])==0)
			{
				this.searchOpenList(matriz[inicial.x][inicial.y-1],fin,10);
			}
			
		}
			
		if(inicial.x+1<Mapa.matriz.length&&inicial.y-1>=0&&matriz[inicial.x][inicial.y-1].walk==0&&matriz[inicial.x][inicial.y-1].walk==0){
			if(this.searchCloseList(matriz[inicial.x+1][inicial.y-1])==0)
			{
				this.searchOpenList(matriz[inicial.x+1][inicial.y-1],fin,14);
			}
			
		}
		if(inicial.x-1>=0&&matriz[inicial.x-1][inicial.y].walk==0)
		{
			if(this.searchCloseList(matriz[inicial.x-1][inicial.y])==0)
			{
				this.searchOpenList(matriz[inicial.x-1][inicial.y],fin,10);
			}
			
		}
		if(inicial.x+1<Mapa.matriz.length&&matriz[inicial.x+1][inicial.y].walk==0){
			if(this.searchCloseList(matriz[inicial.x+1][inicial.y])==0)
			{
				this.searchOpenList(matriz[inicial.x+1][inicial.y],fin,10);
			}
			
		}
		if(inicial.x-1>=0&&inicial.y+1<Mapa.matriz.length&&matriz[inicial.x-1][inicial.y+1].walk==0&&matriz[inicial.x][inicial.y+1].walk==0){
			if(this.searchCloseList(matriz[inicial.x-1][inicial.y+1])==0)
			{
				this.searchOpenList(matriz[inicial.x-1][inicial.y+1],fin,14);
			}
			
		}
		if(inicial.y+1<Mapa.matriz[0].length&&matriz[inicial.x][inicial.y+1].walk==0)
		{
			if(this.searchCloseList(matriz[inicial.x][inicial.y+1])==0)
			{
				this.searchOpenList(matriz[inicial.x][inicial.y+1],fin,10);
			}
		}
		if(inicial.y+1<Mapa.matriz[0].length&&inicial.x+1<Mapa.matriz.length&&matriz[inicial.x+1][inicial.y+1].walk==0&&matriz[inicial.x][inicial.y+1].walk==0&&matriz[inicial.x+1][inicial.y].walk==0)
		{
			if(this.searchCloseList(matriz[inicial.x+1][inicial.y+1])==0)
			{
				this.searchOpenList(matriz[inicial.x+1][inicial.y+1],fin,14);
			}
		}
	}
	 int searchCloseList(Nodos elemeto)
	 {
		 for(int i=0;i<listaCerrada.size();i++){
			 if(listaCerrada.elementAt(i).equals(elemeto))
			 {
				 return 1;
			 }
		 }
		 return 0;
	 }
	 void searchOpenList(Nodos elemento,Nodos fin,int costo)
	{
			
				if(contais(elemento)==0)
				{
					elemento.type="a";
					elemento.G+=costo+ultimonodo.G;
					elemento.processHManhattan(elemento.x,fin.x,elemento.y, fin.y);
					elemento.padre=ultimonodo;
					
					listaAbierta.add(elemento);
					if(elemento.equals(fin))
					{
						encontrado=1;
						return;
					}
					return;
				}else
				{
					if(elemento.G+costo<ultimonodo.G)
					{
						elemento.padre=ultimonodo;
						elemento.G+=costo;
						elemento.processHManhattan(elemento.x,fin.x,elemento.y, fin.y);
					}
				}
			
		
	}
	 int contais(Nodos elemento)
	 {
		 for(int i=0;i<listaAbierta.size();i++)
		 {
			 if(listaAbierta.elementAt(i).equals(elemento))
			 {
				 return 1;
			 }
		 }
		 return 0;
	 }
	 Nodos searchMenor()
	 {
		 int menor=listaAbierta.elementAt(0).F;
		 Nodos m=listaAbierta.elementAt(0);
		 for(int i=1;i<listaAbierta.size();i++)
		 {
			 if(listaAbierta.elementAt(i).F<menor)
			 {
				m =listaAbierta.elementAt(i);
				menor=listaAbierta.elementAt(i).F;
			 }
		 }
		 return m;
	 }
}
