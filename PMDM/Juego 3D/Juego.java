/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Pedro
 */
import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.tiled.*;

/**
 * Proyecto con Slick
 * 
 * @author epa
 */
public class Juego extends BasicGame {

    private TiledMap mapa;
    private float despX, despY;
    private float jugadorX, jugadorY;
    private SpriteSheet cuadros,nojugador2;
    private Animation jugador;
    private Animation jugadorArriba;
    private Animation jugadorDerecha;
    private Animation jugadorAbajo;
    private Animation jugadorIzquierda;
    
    private boolean[][] obstaculo; 
    private boolean[][] agujero; 
    private boolean[][] tesoro1b; 
    private boolean[][] tesoro2b;
    private boolean[][] tesoro3b;
    private boolean[][] tesoro4b;
    private int totalTilesWidth;
    private int totalTilesHeight;
    
    private int jugadorWidth, jugadorHeight;
    private int tileWidth, tileHeight;
    private int mapaWidth, mapaHeight;
    
    private Animation nojugadorArriba;
    private Animation nojugadorDerecha;
    private Animation nojugadorAbajo;
    private Animation nojugadorIzquierda;

    private Animation nojugador;
    private float nojugadorX;
    private float nojugadorY;
    private float destinoX;
    private float destinoY;
    //private static final int numeroNPCs = 4;
    
    private Image tesoro1, tesoro2, tesoro3, tesoro4;
    private boolean cogerTesoro1, cogerTesoro2, cogerTesoro3, cogerTesoro4;
    private float tesoro1X, tesoro1Y;
    private float tesoro2X, tesoro2Y;
    private float tesoro3X, tesoro3Y;
    private float tesoro4X, tesoro4Y;
    
    private boolean jugadorVivo, jugadorGana;
    
    // Escritura de cadenas
    private UnicodeFont fuente;
    
    // Música y sonidos.
    private Music musica;
    private Sound sonidoCapturado;
    private Sound sonidoCogePokeboll;
    private Sound sonidoCaerAgujero;
    private Sound sonidoAplausos;
    
    int score = 0;
    float nivel = (float) 0.05;
    int cont=1;
    
    public Juego(String name) {
        super(name);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
        try {
            AppGameContainer container = new AppGameContainer(new Juego("PMDM - Proyecto Slick"));
            container.setDisplayMode(640, 478, false);
            container.setTargetFrameRate(60);
            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        mapa = new TiledMap("data/mapa.tmx", "data");
        cuadros = new SpriteSheet("data/mosquetero.png",24,32);
        nojugador2 = new SpriteSheet("data/mosquetero2.png",24,32);
        tesoro1 = new Image("data/pokeball1.png");
        tesoro2 = new Image("data/pokeball2.png");
        tesoro3 = new Image("data/pokeball3.png");
        tesoro4 = new Image("data/pokeball4.png");
        jugadorArriba = new Animation(cuadros, 0, 0, 2, 0, true, 150, false);
        jugadorDerecha= new Animation(cuadros, 0, 1, 2, 1, true, 150, false);
        jugadorAbajo  = new Animation(cuadros, 0, 2, 2, 2, true, 150, false);
        jugadorIzquierda = new Animation(cuadros, 0, 3, 2, 3, true, 150, false);
        jugador = jugadorAbajo;
        fuente = new UnicodeFont("data/tuffy.ttf", 28, false, false);
        
        // Añade las letras ASCII estánndar
        fuente.addAsciiGlyphs();
        // y ahora añadimos los caracteres españoles
        fuente.addGlyphs("Ã¡Ã©Ã­Ã³ÃºÃÃ‰ÃÃ“ÃšÃ±Ã‘Â¡Â¿");
        // en Slick es obligatorio añadir un efecto para poder dibujar
        // texto. Añadimos un efecto vacío.
        fuente.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        // cargamos los símbolos del tipo de letra
        fuente.loadGlyphs();
        // A partir de ahora, llamando a fuente.drawString(x, y, texto) podremos
        // escribir en el contenedor
        
        jugadorVivo = true; //Indicamos que está vivo inicialmente.
        jugadorGana = false; //Indicamos que no ha ganado desde el comienzo.
        cogerTesoro1 = false;
        cogerTesoro2 = false;
        cogerTesoro3 = false;
        cogerTesoro4 = false;
        
        //Defino las posiciones iniciales de los distintos elementos
        
        despX = 0;
	despY = 0;
        jugadorX = 260;
	jugadorY = 20;
        
        tesoro1X = 580;
        tesoro1Y = 30;
        
        tesoro2X = 135;
        tesoro2Y = 135;
        
        tesoro3X = 135;
        tesoro3Y = 260;
        
        tesoro4X = 610;
        tesoro4Y = 452;
        
        mapaWidth = mapa.getWidth()*mapa.getTileWidth();
        mapaHeight = mapa.getHeight()*mapa.getTileHeight();

        totalTilesWidth = mapa.getWidth();
        totalTilesHeight = mapa.getHeight();
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                obstaculo[x][y] = (mapa.getTileId(x, y, 4) != 0); //Indicamos la capa
            }
        }
        agujero = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                agujero[x][y] = (mapa.getTileId(x, y, 2) != 0); //Indicamos la capa
            }
        }
        tesoro1b = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro1b[x][y] = (mapa.getTileId(x, y, 5) != 0); //Indicamos la capa
            }
        }
        
        tesoro2b = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro2b[x][y] = (mapa.getTileId(x, y, 6) != 0); //Indicamos la capa
            }
        }
        
        tesoro3b = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro3b[x][y] = (mapa.getTileId(x, y, 7) != 0); //Indicamos la capa
            }
        }
        
        tesoro4b = new boolean[totalTilesWidth][totalTilesHeight];
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro4b[x][y] = (mapa.getTileId(x, y, 8) != 0); //Indicamos la capa
            }
        }
        jugadorWidth = jugador.getWidth();
        jugadorHeight = jugador.getHeight();
        tileWidth = mapa.getTileWidth();
        tileHeight = mapa.getTileHeight();
        
        nojugadorArriba = new Animation(nojugador2, 0, 0, 2, 0, true, 150, true);
        nojugadorDerecha= new Animation(nojugador2, 0, 1, 2, 1, true, 150, true);
        nojugadorAbajo  = new Animation(nojugador2, 0, 2, 2, 2, true, 150, true);
        nojugadorIzquierda
                      = new Animation(nojugador2, 0, 3, 2, 3, true, 150, true);
        
        for (int i=0;i<2;i++) {
            nojugador = nojugadorAbajo;
            nojugadorX = (float) (Math.random()*mapaWidth);
            nojugadorY = (float) (Math.random()*mapaHeight);
        }
        
        musica = new Music("data/bi-menu.xm");
        musica.loop();
        sonidoCapturado = new Sound("data/game-over.wav");  // Cuando el jugador es capturado por el fantasma
        sonidoCogePokeboll = new Sound("data/coin-object.wav"); // Cuando el jugador recoge cada uno de los objetos.
        sonidoCaerAgujero = new Sound("data/object-which-falls-fake.wav"); // Cuando el jugador cae por alguno de los agujeros.
        sonidoAplausos = new Sound("data/success-1.wav"); // Cuando el jugador ha ganado la partida.
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
      Input entrada = gc.getInput();
      
      float jugadorAnteriorX = jugadorX;
      float jugadorAnteriorY = jugadorY;
      if (entrada.isKeyDown(Input.KEY_DOWN)) {	// Tecla abajo
          jugadorY += delta*0.1f;
          jugador = jugadorAbajo;
          jugador.update(delta);
      }
      if (entrada.isKeyDown(Input.KEY_UP)) {	// Tecla arriba
          jugadorY -= delta*0.1f;
          jugador = jugadorArriba;
          jugador.update(delta);
      }
      if (entrada.isKeyDown(Input.KEY_RIGHT)) {	// Tecla derecha
          jugadorX += delta*0.1f;
          jugador = jugadorDerecha;
          jugador.update(delta);
      }
      if (entrada.isKeyDown(Input.KEY_LEFT)) {	// Tecla izquierda
          jugadorX -= delta*0.1f;
          jugador = jugadorIzquierda;
          jugador.update(delta);
      }
      
      //Obstáculos
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (obstaculo[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (obstaculo[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])) {
        jugadorX = jugadorAnteriorX;
        jugadorY = jugadorAnteriorY;
      }      
      //Agujeros
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (agujero[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (agujero[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])) {
        
        jugadorVivo = false;
        if (sonidoCaerAgujero.playing() == false){
            sonidoCaerAgujero.play();
        }
      }
      
      //Tesoros
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (tesoro1b[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (tesoro1b[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)]) && cogerTesoro1 == false) {
        tesoro1X = 390;
        tesoro1Y = 5;
        if (sonidoCogePokeboll.playing() == false){
            sonidoCogePokeboll.play();
        }
        cogerTesoro1 = true;
        score++;
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro1b[x][y] = (mapa.getTileId(x, y, 4) != 0); //Indicamos la capa
            }
        }      }
      
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (tesoro2b[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (tesoro2b[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)]) && cogerTesoro2 == false) {
        
        tesoro2X = 450;
        tesoro2Y = 5;
        if (sonidoCogePokeboll.playing() == false){
            sonidoCogePokeboll.play();
        }
        cogerTesoro2 = true;
        score++;
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro2b[x][y] = (mapa.getTileId(x, y, 4) != 0); //Indicamos la capa
            }
        }      }
      
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (tesoro3b[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (tesoro3b[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)]) && cogerTesoro3 == false) {
        
        tesoro3X = 516;
        tesoro3Y = 5;
        if (sonidoCogePokeboll.playing() == false){
            sonidoCogePokeboll.play();
        }        
        cogerTesoro3 = true;
        score++;
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro3b[x][y] = (mapa.getTileId(x, y, 4) != 0); //Indicamos la capa
            }
        }      }
      
      if ((jugadorX < 0 || jugadorY < 0 || jugadorX > (mapaWidth - jugadorWidth) || jugadorY > (mapaHeight - jugadorHeight))
        || (tesoro4b[(int) (jugadorX / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)])
        || (tesoro4b[(int) ((jugadorX+jugadorWidth) / tileWidth)][((int) (jugadorY + jugadorHeight) / tileHeight)]) && cogerTesoro4 == false) {
        
        tesoro4X = 580;
        tesoro4Y = 5;
        if (sonidoCogePokeboll.playing() == false){
            sonidoCogePokeboll.play();
        }        
        cogerTesoro4 = true;
        score++;
        for (int x = 0; x < totalTilesWidth; x++) {
            for (int y = 0; y < totalTilesHeight; y++) {
                tesoro4b[x][y] = (mapa.getTileId(x, y, 4) != 0); //Indicamos la capa
            }
        }      }
      
      despX = -(jugadorX - gc.getWidth() / 2);
      despY = -(jugadorY - gc.getHeight() / 2);
      
      if (despX < (gc.getWidth() - mapaWidth)) {
        despX = gc.getWidth() - mapaWidth;
      }
      if (despX > 0) {
        despX = 0;
      }
      if (despY < (gc.getHeight() - mapaHeight)) {
        despY = gc.getHeight() - mapaHeight;
      }
      if (despY > 0) {
        despY = 0;
      }
      
      if((cogerTesoro1 || cogerTesoro2 || cogerTesoro3 || cogerTesoro4)==true){
        nivel = (float) 0.06;
        cont=2;
      }
      
      if((cogerTesoro1 && cogerTesoro2 || cogerTesoro3 && cogerTesoro4)==true || (cogerTesoro1 && cogerTesoro3 || cogerTesoro2 && cogerTesoro4)==true
              || (cogerTesoro1 && cogerTesoro4 || cogerTesoro2 && cogerTesoro3)==true){
        nivel = (float) 0.08;
        cont=3;
      }
      
      if((cogerTesoro1 && cogerTesoro2 && cogerTesoro3)==true || (cogerTesoro4 && cogerTesoro2 && cogerTesoro3)==true
              || (cogerTesoro1 && cogerTesoro4 && cogerTesoro3)==true || (cogerTesoro1 && cogerTesoro2 && cogerTesoro4)==true){
        nivel = (float) 0.09;
        cont=4;
      }
      

          if (destinoY>nojugadorY) {
            nojugadorY += delta*nivel;
            nojugador = nojugadorAbajo;
          } 
          
          destinoX = jugadorX;
          destinoY = jugadorY;
            
          if (destinoY<nojugadorY) {
            nojugadorY -= delta*nivel;
            nojugador = nojugadorArriba;
          }
          if (destinoX>nojugadorX) {
            nojugadorX += delta*nivel;
            nojugador = nojugadorDerecha;
          }
          if (destinoX<nojugadorX) {
            nojugadorX -= delta*nivel;
            nojugador = nojugadorIzquierda;
          }

      
      if (jugadorVivo == false || jugadorGana==true) {
            musica.stop();            
            return;
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        Input entrada = container.getInput();
        g.translate(despX, despY);
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 4);
        mapa.render(0, 0, 5);
        mapa.render(0, 0, 6);
        mapa.render(0, 0, 7);
        mapa.render(0, 0, 8);

        if (jugadorVivo == true) {
            jugador.draw(jugadorX, jugadorY);
        }
        
        nojugador.draw(nojugadorX,nojugadorY);
        
        
        tesoro1.draw(tesoro1X, tesoro1Y);
        tesoro2.draw(tesoro2X, tesoro2Y);
        tesoro3.draw(tesoro3X, tesoro3Y);
        tesoro4.draw(tesoro4X, tesoro4Y);

        if (entrada.isKeyDown(Input.KEY_ESCAPE)) {	// Tecla ESC
            container.exit();
        }
        
        if(((int)nojugadorX)-5 <= jugadorX && (int)nojugadorX+5 >= jugadorX){
            if (((int)nojugadorY)-5 <= jugadorY && (int)nojugadorY+5 >= jugadorY){
                jugadorVivo=false;
                if (sonidoCapturado.playing() == false){
                    sonidoCapturado.play();    
                }
            }
        }
        String mensajeScore = "Score: " + score;
        // dibujamos el texto centrado en el contenedor
        fuente.drawString(100, 0, mensajeScore, Color.white);
            
        String mensajeNivel = "Nivel " + cont;
        fuente.drawString(40, 445, mensajeNivel);
        
        if (jugadorVivo == false) {
            score = 0;
            String mensajePerder = "GAME OVER. Pulsa Esc para salir";
            // dibujamos el texto centrado en el contenedor
            fuente.drawString((container.getWidth() - fuente.getWidth(mensajePerder)) / 2, (container.getHeight() - 
                    fuente.getHeight(mensajePerder)) / 2, mensajePerder, Color.black);
        } 
        
        if ((cogerTesoro1 && cogerTesoro2 && cogerTesoro3 && cogerTesoro4)==true && (jugadorVivo == true)){
            //Si consigue los cuatro objetos ponemos efecto de sonido una sola vez
            jugadorGana = true;
            if (sonidoAplausos.playing() == false){
                sonidoAplausos.play();  // Se reproduce este sonido cuando el jugador ha ganado la partida.
            }
            String mensajeGanar = "Enhorabuena, has ganado! Pulsa Esc para salir";
            
            // dibujamos el texto centrado en el contenedor
            fuente.drawString((container.getWidth() - fuente.getWidth(mensajeGanar)) / 2, (container.getHeight() - 
                    fuente.getHeight(mensajeGanar)) / 2, mensajeGanar, Color.black);  
            
            nojugadorX = 260;
            nojugadorY = 20;
            
        }
        mapa.render(0,0,3);
    }

}