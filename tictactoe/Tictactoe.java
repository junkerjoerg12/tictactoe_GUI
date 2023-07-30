package tictactoe;

import java.util.HashSet;
import java.util.Scanner;

import gui.Spielfeld;

public class Tictactoe {
	
	static int x;
	static int y;
	
	static char[][] spielfeld= new char[4][4];
	static int zufallsecke;
	static int zufallseckezwei;
	
	// booleans um den Verlauf des Spiels nachverforgen zu können
	static boolean eckegeg= false;			// Spieler wählte die ecke gegenüber der des Computers 
	static boolean eckeand= false;			// Spieler wählte eine Ecke nich gegenüber der des Computers/ eine beliebige ecke, wenn er anfängt
	static boolean mitterandang= false;		//Spieler wählte die Mitte der äußeren Zeilen/Spalten/ einen beliebigen mitterand wenn er anfängt
	static boolean mitte= false; 				//Spieler wählte Mitte
	static boolean mitterandnichtang= false; 	//Spieler hat Mitte Rand, aber nicht an mich angrnzend gewählt
	static boolean czug= false;						//gibt an, ob der Zug des Computers beendet ist
	static boolean gewonnen=false;			//true sobald entweder Spieler oder Computer gewonnen haben
	static Spielfeld feld= new Spielfeld();
	static HashSet<String> speicher= new HashSet<String>();
	
	
	
	
	
	static Scanner tastatur=new Scanner(System.in);





			public static void main(String[] args) {
				
				


				int a;
				
				
				a=0;//(int)(Math.random()*2);					//Wenn gleich null Computer als erstes am Zug, wenn 1 Spieler als erstes am Zug
				
				fuellen();
				
				
				if(a==0) {
					
					
					System.out.println("Der Computer beginnt");
					System.out.println("Runde 1");//Runde 1

					
					cersterzug();
					
					ausgabe();
					
					pzug();
					
					ausgabe();
					
					System.out.println("Runde 2");//Runde 2
					czweiterzug();
					
					ausgabe();
					
					pzug();
					
					ausgabe();
					
					System.out.println("Runde 3");//Runde 3
					if(gewonnen==false) {
						cdritterzug();
						
						ausgabe();
					}
					if(gewonnen==false) {
						pzug();
						
						ausgabe();
					}
					
					if(gewonnen==false) {
					System.out.println("Runde 4");//(Runde 4
						
						cvierterzug();
						
						ausgabe();
					}
					if(gewonnen==false) {
						pzug();
						
						ausgabe();
					}
					if(gewonnen==false) {
					System.out.println("Runde 5");//Runde 5
					
						cvierterzug();
						
						ausgabe();
					}
				}else if (a==1) {
					
					System.out.println("Der Spieler beginnt");
					System.out.println("Runde 1");//Runde1

					
					ausgabe();


					
					if (gewonnen==false) {
						

						
						pzug();
						
						ausgabe();
						
					}
					if  (gewonnen==false) {
						
						cantworteins();
						
						ausgabe();
					}
					if (gewonnen==false){
						
						System.out.println("Runde 2");//Runde 2
						
						pzug();
						
						ausgabe();
						
					}
					if (gewonnen==false) {
						
						cantwortzwei();
						
						ausgabe();
					}
					if (gewonnen==false){
						
						System.out.println("Runde 3");//Runde 3
						
						pzug();
						
						ausgabe();
						
					}
					if (gewonnen==false) {
						
						cantwortdrei();
						
						ausgabe();
					}
					if (gewonnen==false){
						
						System.out.println("Runde 4");//Runde 4
						
						pzug();
						
						ausgabe();
						
					}
					if (gewonnen==false) {
						
						cantwortvier();
						
						ausgabe();
					}
					if (gewonnen==false){
						
						System.out.println("Runde 4");//Runde 5
						
						pzug();
						
						ausgabe();
						
					}	
				}
			}
			
			public static void cantworteins() {
				if (spielfeld[1][1]==112||spielfeld[1][3]==112||spielfeld[3][3]==112||spielfeld[3][1]==112) {				//Wenn spieler in eine ecke gesetzt hat: mitte wählen
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);
					eckeand=true;
				}else if(spielfeld[2][2]==112) {									//Gegner wählt mitte: ecke  wählen
					zufallsecke=(int)(Math.random()*4);
					System.out.println("Ecke: "+zufallsecke);
					mitte=true;
					if( zufallsecke==0){
						spielfeld[1][1]=99;
						computerAusgabeGui(1,1);
					}else if( zufallsecke==1){
						spielfeld[1][3]=99;
						computerAusgabeGui(1, 3);
					}else if( zufallsecke==2){
						spielfeld[3][1]=99;
						computerAusgabeGui(3, 1);
					}else if( zufallsecke==3){
						spielfeld[3][3]=99;
						computerAusgabeGui(3, 3);
					}
				}else if(spielfeld[1][2]==112) {											//gegner wählt mitte Rand: Mitte Rand gegenüber wählen
					spielfeld[3][2]=99;
					mitterandang=true;
					computerAusgabeGui(3, 2);
				}else if(spielfeld[3][2]==112) {											
					spielfeld[1][2]=99;
					mitterandang=true;
					computerAusgabeGui(1, 2);
				}else if(spielfeld[2][1]==112) {											
					spielfeld[2][3]=99;
					computerAusgabeGui(2,3);
					mitterandang=true;
				}else if(spielfeld[2][3]==112) {											
					spielfeld[2][1]=99;
					computerAusgabeGui(2,1);
					mitterandang=true;
				}
			}
			
			
			public static void cantwortzwei() {
				verteidigung();
				System.out.println("Hier noch mal drübergucken");		//MItte fehlt
				
				
				if (czug==false) {
					if (eckeand==true) {																	//Gegner hatt ecek gewählt und jetzt die ecke gegenüber: mitte rand wählen
						if((spielfeld[1][1]+spielfeld[2][2]+spielfeld[3][3]==323)||(spielfeld[3][1]+spielfeld[2][2]+spielfeld[1][3]==323)) {
							if(zufallsecke==0) {
								spielfeld[2][1]=99;
								computerAusgabeGui(2, 1);
							}else if(zufallsecke==0) {
								spielfeld[2][3]=99;
								computerAusgabeGui(2, 3);
							}else if(zufallsecke==0) {
								spielfeld[1][2]=99;
								computerAusgabeGui(1, 2);
							}else if(zufallsecke==0) {
								spielfeld[3][2]=99;
								computerAusgabeGui(3, 2);
							}
						}
					}else if(mitterandang==true) {						//Spieler hat mitterand und dannach mitte oder eine nicht verbundenen ecke gewählt 
						if(spielfeld[1][2]+spielfeld[1][3]==99&&spielfeld[2][1]+spielfeld[3][1]==99&&spielfeld[1][1]==48) {																					//Ecke wählen, deren horizontale und vertikale 99 ergeben
							spielfeld[1][1]=99;
							computerAusgabeGui(1, 1);
						}else if(spielfeld[1][2]+spielfeld[1][1]!=99&&spielfeld[2][3]+spielfeld[3][3]!=99&&spielfeld[1][1]==48) {																					
							spielfeld[1][3]=99;
							computerAusgabeGui(1, 3);
						}else if(spielfeld[1][1]+spielfeld[2][1]!=99&&spielfeld[3][3]+spielfeld[3][2]!=99&&spielfeld[1][1]==48) {																					
							spielfeld[3][1]=99;
							computerAusgabeGui(3, 1);
						}else if(spielfeld[3][1]+spielfeld[3][2]!=99&&spielfeld[1][3]+spielfeld[2][3]!=99&&spielfeld[1][1]==48) {																					
							spielfeld[3][3]=99;
							computerAusgabeGui(3, 3);
						}
						
						
					}
				}
			}
			
			
			
			public static void cantwortdrei() {
				
				gewinnen();
				
				verteidigung();
				
				if (czug==false) {
					if(mitterandang==true) {												//gegner hat mitterand gewählt+ an sein feld anliegendes feld oder mItte gewählt+ hat an sien feld anliegendes Feld oder Mitte gewählt: 
						if(spielfeld[1][2]+spielfeld[1][3]==99&&spielfeld[2][1]+spielfeld[3][1]==99) {																					//Ecke wählen, deren horizontale und vertikale 99 ergeben
							spielfeld[1][1]=99;
							computerAusgabeGui(1, 1);
						}else if(spielfeld[1][2]+spielfeld[1][1]==99&&spielfeld[2][3]+spielfeld[3][3]==99) {																					
							spielfeld[1][3]=99;
							computerAusgabeGui(1, 3);
						}else if(spielfeld[1][1]+spielfeld[2][1]==99&&spielfeld[3][3]+spielfeld[3][2]==99) {																					
							spielfeld[3][1]=99;
							computerAusgabeGui(3, 1);
						}else if(spielfeld[3][1]+spielfeld[3][2]==99&&spielfeld[1][3]+spielfeld[2][3]==99) {																					
							spielfeld[3][3]=99;
							computerAusgabeGui(3, 3);
						} 
					}else if(mitte==true) {
						
					}
				}
			}
			
			public static void cantwortvier() {
				gewinnen();
				
				verteidigung();
				
			}
			
			public static void fuellen(){				// feld wird mit nullen gefült
				for(int i=0; i<4; i++){
					for(int j=0; j<4; j++){
						spielfeld[i][j]=48;
					}
				}
				for( int i=0; i<4; i++ ){
					spielfeld[0][i]=(char)(48+i);
				}
				for( int i=0; i<4; i++ ){
					spielfeld[i][0]=(char)(48+i);
				}
				
				
			}

			public static void pzug(){					// spieler platziert sein zeichen beliebi
				int x=0;
				int y=0;
				boolean p=false;
				czug=false;

				feld.userIn();
				while(p==false){
					for(int i=0; i<3; i++){
						for (int j=0; j<3; j++){
							if(feld.getKnoepfe()[j][i].getText().equals("0")){
								if(!speicher.contains(""+j+i)){
									x=i+1; 
									y=j+1;
									p=true;
									speicher.add(""+j+i);
								}
								
							}
						}
					}
				}
				
				
				
				

				if (spielfeld[x][y]==48 ){
					p=true;
					spielfeld[x][y]=112;
				}else{
					System.out.println("ungültige eingabe, bitte wiederholen");
				}
					
				
				ueberpruefen();
			}
			
			
			public static void cersterzug(){				//computer platziert c in einer Ecke
				
				zufallsecke=(int)(Math.random()*4);
				if( zufallsecke==0){
					spielfeld[1][1]=99;
					computerAusgabeGui(1, 1);
				}else if( zufallsecke==1){
					spielfeld[1][3]=99;
					computerAusgabeGui(1, 3);
				}else if( zufallsecke==2){
					spielfeld[3][1]=99;
					computerAusgabeGui(3, 1);
				}else if( zufallsecke==3){
					spielfeld[3][3]=99;
					computerAusgabeGui(3, 3);
				}
			}
				
			public static void czweiterzug(){	
				
				zufallseckezwei=(int)Math.random()*2;
			
			
				if(zufallsecke==0&&spielfeld[3][3]==112) {				//Spieler hat ecke gegenüber der vom Computer gewählten ecke gewählt: andere ecke wählen
					eckegeg= true;
					if(zufallseckezwei==0) {
						spielfeld[3][1]=99;
						computerAusgabeGui(3, 1);
					}else {
						spielfeld[1][3]=99;
						computerAusgabeGui(1, 3);
					}
				}else if(zufallsecke==1&&spielfeld[3][1]==112) {
					eckegeg= true;
					if(zufallseckezwei==0) {
						spielfeld[1][1]=99;
						computerAusgabeGui(1, 1);
					}else {
						spielfeld[3][3]=99;
						computerAusgabeGui(3, 3);
					}
				}else if(zufallsecke==2&&spielfeld[1][3]==112) {
					eckegeg= true;
					if(zufallseckezwei==0) {
						spielfeld[1][1]=99;
						computerAusgabeGui(1, 1);
					}else {
						spielfeld[3][3]=99;
						computerAusgabeGui(3, 3);
					}
				}else if(zufallsecke==3&&spielfeld[1][1]==112) {
					eckegeg= true;
					if(zufallseckezwei==0) {
						spielfeld[3][1]=99;
						computerAusgabeGui(3, 1);
					}else {
						spielfeld[1][3]=99;
						computerAusgabeGui(1, 3);
					}
				}else if(zufallsecke==0&&(spielfeld[3][1]==112||spielfeld[1][3]==112)) {					//SPieler hat andere Ecke gewählt: ich wähle die ecke gegeüber meiner ersten ecke
					eckeand= true;
					spielfeld[3][3]=99;
					computerAusgabeGui(3, 3);
				}else if(zufallsecke==1&&(spielfeld[3][3]==112||spielfeld[1][1]==112)) {
					eckeand= true;
					spielfeld[3][1]=99;
					computerAusgabeGui(3, 1);
				}else if(zufallsecke==2&&(spielfeld[1][1]==112||spielfeld[3][3]==112)) {
					eckeand= true;
					spielfeld[1][3]=99;
					computerAusgabeGui(1, 3);
				}else if(zufallsecke==3&&(spielfeld[3][1]==112||spielfeld[1][3]==112)) {
					eckeand= true;
					spielfeld[1][1]=99;
					computerAusgabeGui(1, 1);
				}else if(zufallsecke==0&&(spielfeld[1][2]==112||spielfeld[2][1]==112)) {								//Spieler hat ein an mein Feld angrenzendes Feld gewähl: Mitte wählen
					mitterandang= true;
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);
				}else if(zufallsecke==1&&(spielfeld[1][2]==112||spielfeld[2][3]==112)) {								
					mitterandang= true;
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);					
				}else if(zufallsecke==2&&(spielfeld[2][1]==112||spielfeld[3][2]==112)) {								
					mitterandang= true;
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);
				}else if(zufallsecke==3&&(spielfeld[2][3]==112||spielfeld[3][2]==112)) {								
					mitterandang= true;
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);
				}
				
				else if(spielfeld[2][2]==112) {																																					// Spielr hat Mitte gewählt: Feld gegenüber der ersten Markierung wählen
					mitte= true;
					if(zufallsecke==0) {
						spielfeld[3][3]=99;
						computerAusgabeGui(3,3);
					}else if(zufallsecke==0) {
						spielfeld[3][3]=99;
						computerAusgabeGui(3,3);
					}else if(zufallsecke==1) {
						spielfeld[3][1]=99;
						computerAusgabeGui(3,1);
					}else if(zufallsecke==2) {
						spielfeld[1][3]=99;
						computerAusgabeGui(1,3);
					}else if(zufallsecke==3) {
						spielfeld[1][1]=99;
						computerAusgabeGui(1,1);
					}
				}else {			// Spieler hat nicht an mich angrenzende mitte vom Rand gewählt(einzigen noch nicht geprüfte Möglichkeit): mitte wählen
					spielfeld[2][2]=99;
					computerAusgabeGui(2,2);
					mitterandnichtang= true;
					
				}
				
				/*System.out.println(eckegeg+ " eckegeg");
				System.out.println(eckeand+" eckeand");
				System.out.println(mitterandang+" mitterandang");
				System.out.println(mitte+" mitte");
				System.out.println("Mitte Rand aber nicht angrenzend: "+ mitterandnichtang);
				*/
			}
			
			public static void cdritterzug() {
				gewinnen();
				
				verteidigung();
				
				
				
				if(czug==false) {
					if(eckegeg==true||eckeand==true) {								// wenn der Spieler vorher irgendeine Ecke gespielt hat und  nicht dumm war: letzte ecke wähle
						if( spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}else if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}
					}else if(mitterandang==true) {														//Gegner hat Mitte Rand, angrenzend an meiner ersten Ecke gewählt:Computer wählt Ecke, welche keinen Kontakt zu gegnerischem Feld hat
						if(zufallsecke==0) {
							if(spielfeld[1][2]==48&&spielfeld[2][3]==48) {		
								spielfeld[1][3]=99;
								computerAusgabeGui(1,3);
							}else if(spielfeld[2][1]==48&&spielfeld[3][2]==48) {
								spielfeld[3][1]=99;
								computerAusgabeGui(3,1);
							}
						}else if(zufallsecke==1) {
							if(spielfeld[1][2]==48&&spielfeld[2][1]==48) {		
								spielfeld[1][1]=99;
								computerAusgabeGui(1,1);
							}else if(spielfeld[2][3]==48&&spielfeld[3][2]==48) {
								spielfeld[3][3]=99;
								computerAusgabeGui(3,3);
							}
						}else if(zufallsecke==2) {
							if(spielfeld[1][2]==48&&spielfeld[2][1]==48) {		
								spielfeld[1][1]=99;
								computerAusgabeGui(1,1);
							}else if(spielfeld[2][3]==48&&spielfeld[3][2]==48) {
								spielfeld[3][3]=99;
								computerAusgabeGui(3,3);
							}
						}else if(zufallsecke==3) {
							if(spielfeld[1][2]==48&&spielfeld[2][3]==48) {		
								spielfeld[1][3]=99;
								computerAusgabeGui(1,3);
							}else if(spielfeld[2][1]==48&&spielfeld[3][2]==48) {
								spielfeld[3][1]=99;
								computerAusgabeGui(3,1);
							}
						}
					}else if(mitterandnichtang==true) {														//Gegener hat Mitte Rand, aber nichtr an meiner erster ecke angrenzend gewählt: 
						if(zufallsecke==0) {
							if(spielfeld[1][2]==112||spielfeld[2][3]==112) {		
								spielfeld[1][3]=99;
								computerAusgabeGui(1,3);
							}else if(spielfeld[2][1]==112||spielfeld[3][2]==112) {
								spielfeld[3][1]=99;
								computerAusgabeGui(3,1);
							}
						}else if(zufallsecke==1) {
							if(spielfeld[1][2]==112||spielfeld[2][1]==112) {		
								spielfeld[1][1]=99;
								computerAusgabeGui(1,1);
							}else if(spielfeld[2][3]==112||spielfeld[3][2]==112) {
								spielfeld[3][3]=99;
								computerAusgabeGui(3,3);
							}
						}else if(zufallsecke==2) {
							if(spielfeld[1][2]==112||spielfeld[2][1]==112) {		
								spielfeld[1][1]=99;
								computerAusgabeGui(1,1);
							}else if(spielfeld[2][3]==112||spielfeld[3][2]==112) {
								spielfeld[3][3]=99;
								computerAusgabeGui(3,3);
							}
						}else if(zufallsecke==3) {
							if(spielfeld[1][2]==112||spielfeld[2][3]==112) {		
								spielfeld[1][3]=99;
								computerAusgabeGui(1,3);
							}else if(spielfeld[2][1]==112||spielfeld[3][2]==112) {
								spielfeld[3][1]=99;
								computerAusgabeGui(3,1);
							}
						}
					}else if(mitte==true&&(x==1&&y==1)||(x==3&&y==1)||(x==3&&y==1)||(x==3&&y==3)) {					//Spieler hat zuerst die MItte und dannach eine Ecke gewählt: letzte Ecke wählen
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[1][3]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[3][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[3][3]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}
					}else if(mitte==true) {																		//Spieler hat zuerrst mitte und dann die mitte vom rand gewählt: blockeren; Ausgang: unentschieden
						if(spielfeld[2][1]==112) {
							spielfeld[2][3]=99;
							computerAusgabeGui(2,3);
						}else if(spielfeld[3][2]==112) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);
						}else if(spielfeld[2][3]==112) {
							spielfeld[2][1]=99;
							computerAusgabeGui(2,1);
						}else if(spielfeld[1][2]==112) {
							spielfeld[3][2]=99;
							computerAusgabeGui(3,2);
						}
					}
				}
			}
			
			public static void cvierterzug() {
				
				
				gewinnen();
				
				verteidigung();
				
			}
			
			public static void ueberpruefen() {																									//Überprüft auf gewinner
				if(spielfeld[1][1]+spielfeld[2][1]+spielfeld[3][1]==297) {												//Überprüfung der horizontalen
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][1]+spielfeld[2][1]+spielfeld[3][1]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][2]+spielfeld[2][2]+spielfeld[3][2]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][2]+spielfeld[2][2]+spielfeld[3][2]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][3]+spielfeld[2][3]+spielfeld[3][3]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][3]+spielfeld[2][3]+spielfeld[3][3]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
					
				}else	if(spielfeld[1][1]+spielfeld[1][2]+spielfeld[1][3]==297) {									//Überprüfung der Vertikaten
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][1]+spielfeld[1][2]+spielfeld[1][3]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[2][1]+spielfeld[2][2]+spielfeld[2][3]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[2][1]+spielfeld[2][2]+spielfeld[2][3]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[3][1]+spielfeld[3][2]+spielfeld[3][3]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[3][1]+spielfeld[3][2]+spielfeld[3][3]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
					
				}else if(spielfeld[1][1]+spielfeld[2][2]+spielfeld[3][3]==336) {									//Überprüfung der Diagonalen(glaube ich ) 
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else	if(spielfeld[1][1]+spielfeld[2][2]+spielfeld[3][3]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][3]+spielfeld[2][2]+spielfeld[3][1]==336) {
					System.out.println("Der Spieler hat gewonnen");
					gewonnen=true;
				}else if(spielfeld[1][3]+spielfeld[2][2]+spielfeld[3][1]==297) {
					System.out.println("Der Computer hat gewonnen");
					gewonnen=true;
				}else {
					System.out.println("Noch kein Gewinner");
				}
			}
			
			public static void verteidigung() {			//falls der Spieler schon zwei Kästeche in reihe hat wird das dritte vom Computer gewählt								
				if(czug==false) {
					if(spielfeld[1][1]+spielfeld[2][1]+spielfeld[3][1]==272) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[2][1]==48) {
							spielfeld[2][1]=99;
							computerAusgabeGui(2,1);
						}else if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);							
						}
						czug=true;
					}else if(spielfeld[1][2]+spielfeld[2][2]+spielfeld[3][2]==272) {
						if(spielfeld[1][2]==48) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}else if(spielfeld[3][2]==48) {
							spielfeld[3][2]=99;
							computerAusgabeGui(3,2);
						}
						czug=true;
					}else if(spielfeld[1][3]+spielfeld[2][3]+spielfeld[3][3]==272) {
						if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}else if(spielfeld[2][3]==48) {
							spielfeld[2][3]=99;
							computerAusgabeGui(2,3);
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}
						czug=true;
					}else if(spielfeld[1][1]+spielfeld[1][2]+spielfeld[1][3]==272) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[1][2]==48) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);
						}else if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}
						czug=true;
					}else if(spielfeld[2][1]+spielfeld[2][2]+spielfeld[2][3]==272) {
						if(spielfeld[2][1]==48) {
							spielfeld[2][1]=99;
							computerAusgabeGui(2,1);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}else if(spielfeld[2][3]==48) {
							spielfeld[2][3]=99;
							computerAusgabeGui(2,3);
						}
						czug=true;
					}else if(spielfeld[3][1]+spielfeld[3][2]+spielfeld[3][3]==272) {
						if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}else if(spielfeld[3][2]==48) {
							spielfeld[3][2]=99;
							computerAusgabeGui(3,2);
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}
						czug=true;
					}else if(spielfeld[1][1]+spielfeld[2][2]+spielfeld[3][3]==272) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}
						czug=true;
					}else if(spielfeld[1][3]+spielfeld[2][2]+spielfeld[3][1]==272 ) {
						if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}else if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}
						czug=true; 
					}
				}
			}
			public static void gewinnen() {							//überprüft, ob irgendwo für den Computer die Möglichkeit besteht zu ind diesem Zug zu gewinnen gewinnen und nutzt diese( kann nur passiere, wenn der Spieler unaufmerksam ist)
				if(czug==false) {
					if(spielfeld[1][1]+spielfeld[2][1]+spielfeld[3][1]==246) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[2][1]==48) {
							spielfeld[2][1]=99;
							computerAusgabeGui(2,1);
						}else if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}
						czug=true;
					}else if(spielfeld[1][2]+spielfeld[2][2]+spielfeld[3][2]==246) {
						if(spielfeld[1][2]==48) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);							
						}else if(spielfeld[2][2]==48) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);
						}else if(spielfeld[3][1]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}
						czug=true;
					}else if(spielfeld[1][3]+spielfeld[2][3]+spielfeld[3][3]==246) {
						if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}else if(spielfeld[2][3]==48) {
							spielfeld[2][3]=99;
							computerAusgabeGui(2,3);
						}else if(spielfeld[3][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}
						czug=true;
					}else if(spielfeld[1][1]+spielfeld[1][2]+spielfeld[1][3]==246) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[1][2]==48) {
							spielfeld[1][2]=99;
							computerAusgabeGui(1,2);							
						}else if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}
						czug=true;
					}else if(spielfeld[2][1]+spielfeld[2][2]+spielfeld[2][3]==246) {
						if(spielfeld[2][1]==48) {
							spielfeld[2][1]=99;
							computerAusgabeGui(2,1);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);
						}else if(spielfeld[2][3]==48) {
							spielfeld[2][3]=99;
							computerAusgabeGui(2,3);						
						}
						czug=true;
					}else if(spielfeld[3][1]+spielfeld[3][2]+spielfeld[3][3]==246) {
						if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}else if(spielfeld[3][2]==48) {
							spielfeld[3][2]=99;
							computerAusgabeGui(3,2);
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}
						czug=true;
					}else if(spielfeld[1][1]+spielfeld[2][2]+spielfeld[3][3]==246) {
						if(spielfeld[1][1]==48) {
							spielfeld[1][1]=99;
							computerAusgabeGui(1,1);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);							
						}else if(spielfeld[3][3]==48) {
							spielfeld[3][3]=99;
							computerAusgabeGui(3,3);
						}
						czug=true;
					}else if(spielfeld[1][3]+spielfeld[2][2]+spielfeld[3][1]==246) {
						if(spielfeld[1][3]==48) {
							spielfeld[1][3]=99;
							computerAusgabeGui(1,3);
						}else if(spielfeld[2][2]==48) {
							spielfeld[2][2]=99;
							computerAusgabeGui(2,2);							
						}else if(spielfeld[3][1]==48) {
							spielfeld[3][1]=99;
							computerAusgabeGui(3,1);
						}
						czug=true; 
					}
				}
			}

			public static void ausgabe(){					//gibt das Spielfeld aus
				
				for(int i=0; i<4; i++){
					System.out.println("\n");
					for(int j=0; j<4; j++){
						System.out.print(spielfeld[j][i]+"   ");
					}
				}
				System.out.println("\n");
				ueberpruefen();
				System.out.println("\n");
			}

			public static void computerAusgabeGui(int y,int x){
				String position;
				position=""+x+y;
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if (feld.getKnoepfe()[i][j].getText().equals(position)){
							feld.setTextKnoepfe(i, j, "X");
						}
					}
				}

			}
		}	
	
