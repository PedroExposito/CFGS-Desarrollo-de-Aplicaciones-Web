/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialslick;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.tiled.*;

/**
 * Proyecto vac�o con Slick
 * 
 * @author epa
 */
public class TutorialSlick extends BasicGame {
    private TiledMap mapa;
    private float desplX,desplY;
    private float posX,posY;
    private Image personaje;
    private SpriteSheet cuadros;
    private Animation jugador;
    private Animation jugadorArriba;
    private Animation jugadorAbajo;
    private Animation jugadorDerecha;
    private Animation jugadorIzquierda;
    private int mapaWidth, mapaHeight;
    
    
    public TutorialSlick(String name) {
        super(name);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
        try {
            AppGameContainer container = new AppGameContainer(new TutorialSlick("PMDM - Proyecto Slick de EPA"));
            container.setDisplayMode(800, 600, false);
            //container.;
            
            container.setTargetFrameRate(30);
            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        
        this.desplX=0;
        this.desplY=0;
        mapa = new TiledMap("data/mapa.tmx","data");
        //personaje=new Image("/data/mosquetero1.png");

        cuadros = new SpriteSheet("data/mosquetero.png",24,32);
        jugadorArriba = new Animation(cuadros,0,0,2,0,true,150,false);
        jugadorDerecha = new Animation(cuadros,0,1,2,1,true,150,false);
        jugadorAbajo = new Animation(cuadros,0,2,2,2,true,150,false);
        jugadorIzquierda = new Animation(cuadros,0,3,2,3,true,150,false);
        
        jugador=jugadorAbajo;
        
        this.posX=400;
        this.posY=300;
        
        mapaWidth = mapa.getWidth()*mapa.getTileWidth(); 
        mapaHeight = mapa.getHeight()*mapa.getTileHeight();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input entrada = gc.getInput();
        
        if(entrada.isKeyDown(Input.KEY_DOWN)){ //hacia abajo
            this.posY+=delta*0.1f;
            jugador=jugadorAbajo;
            jugador.update(delta);
            this.desplY=-(posY-gc.getHeight()/2);
            
        }
        if(entrada.isKeyDown(Input.KEY_UP)){
            this.posY-=delta*0.1f;
            jugador=jugadorArriba;
            jugador.update(delta);
            this.desplY=-(posY-gc.getHeight()/2);
        }
        if(entrada.isKeyDown(Input.KEY_RIGHT)){
            this.posX+=delta*0.1f;
            jugador=jugadorDerecha;
            jugador.update(delta);
            this.desplX=-(posX-gc.getWidth()/2);
        }
        if(entrada.isKeyDown(Input.KEY_LEFT)){
            this.posX-=delta*0.1f;
            jugador=jugadorIzquierda;
            jugador.update(delta);
            this.desplX=-(posX-gc.getWidth()/2);
        }
        
        if (desplX < (gc.getWidth() - mapaWidth)) { 
            desplX = gc.getWidth() - mapaWidth;
        }
        
        if (desplX > 0) {
            desplX = 0; 
        }
        
        if (desplY < (gc.getHeight() - mapaHeight)) { 
            desplY = gc.getHeight() - mapaHeight;
        }
        
        if (desplY > 0) {
            desplY = 0; }
        }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.translate(desplX, desplY);
        mapa.render(0, 0);
        jugador.draw(posX,posY);
        
        //g.translate(-200,-300);
    }

}