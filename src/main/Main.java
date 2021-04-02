package main;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;*/
import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {

	// Globales
	int xBolita = -1000;
	int yBolita = -1000;

	private Avatar player1;
	private Avatar player2;

	private TCPConnectionP1 conexionJ1;
	private TCPConnectionP2 conexionJ2;
	
	private ArrayList<Bala> balasJ1;
	private ArrayList<Bala> balasJ2;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// 1
	public void settings() {
		size(500, 500);
	}

	// 1
	public void setup() {
		conexionJ1 = new TCPConnectionP1();
		// Metodo de suscripcion
		conexionJ1.setMain(this);
		conexionJ1.start();

		conexionJ2 = new TCPConnectionP2();
		// Metodo de suscripcion
		conexionJ2.setMain(this);
		conexionJ2.start();

		player1 = new Avatar(this, 100, 100, color(255, 0, 0));
		player2 = new Avatar(this, 400, 400, color(0, 0, 255));
		
		balasJ1 = new ArrayList<>();
		balasJ2 = new ArrayList<>();
	}

	// Infinito
	public void draw() {
		background(0, 0, 0);
		fill(255, 0, 0);
		ellipse(xBolita, yBolita, 50, 50);

		player1.pintar();
		player2.pintar();
		
		
		for(int i = 0 ; i < balasJ1.size() ; i++) {
			Bala b1 = balasJ1.get(i);
			b1.pintar();
			if(b1.getX()<0) {
				balasJ1.remove(i);
				break;
			}
		}
		
		for(int u = 0 ; u < balasJ2.size() ; u++) {
			Bala b2 = balasJ2.get(u);
			b2.pintar();
			if(b2.getX()<0) {
				balasJ2.remove(u);
				break;
			}
		}
		
		
	}

	// El metodo de notificacion: Aqui se recibe la informacion del evento
	public void notificar(Coordenada c, Object obj) {

		// obj sera un objeto de TCPConnectionP1?
		if (obj instanceof TCPConnectionP1) {
			System.out.println("JUGADOR 1:" + c.getAccion());
			switch (c.getAccion()) {

			case "DOWNSTART":
				player1.activateDownMove();
				break;
			case "DOWNSTOP":
				player1.desactivateDownMove();
				break;
				
			case "UPSTART":
				player1.activateUpMove();
				break;
			case "UPSTOP":
				player1.desactivateUpMove();
				break;
				
			case "RIGHTSTART":
				player1.activateRightMove();
				break;
			case "RIGHTSTOP":
				player1.desactivateRightMove();
				break;
				
			case "LEFTSTART":
				player1.activateLeftMove();;
				break;
			case "LEFTSTOP":
				player1.desactivateLeftMove();;
				break;
				
			case "FIRESTART":
				Bala bala1 = new Bala(this, player1.getX(), player1.getY(), true);
				balasJ1.add(bala1);
				break;
			}

		}

		else if (obj instanceof TCPConnectionP2) {
			System.out.println("JUGADOR 2:" + c.getAccion());
			switch (c.getAccion()) {

			case "DOWNSTART":
				player2.activateDownMove();
				break;
			case "DOWNSTOP":
				player2.desactivateDownMove();
				break;
				
			case "UPSTART":
				player2.activateUpMove();
				break;
			case "UPSTOP":
				player2.desactivateUpMove();
				break;
				
			case "RIGHTSTART":
				player2.activateRightMove();
				break;
			case "RIGHTSTOP":
				player2.desactivateRightMove();
				break;
				
			case "LEFTSTART":
				player2.activateLeftMove();;
				break;
			case "LEFTSTOP":
				player2.desactivateLeftMove();;
				break;

			}
		}

	}

}
