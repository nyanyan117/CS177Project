import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.Timer;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class NewCanvas extends Applet implements ActionListener, KeyListener{
	private float height = 0.7f; 
    private float sign = 1.0f; // going up or down
    private float xloc = 0.0f;
    private float zloc = 0.0f;
    
	private Timer t;	
	private Transform3D transform;
	private TransformGroup tg;
	private Button go = new Button("Go");
	private int pcounter = 0;
	private Sphere sphere2;
	private Sphere sphere3;
  public NewCanvas() {

	  setLayout(new BorderLayout());
	  setBackground(Color.darkGray);
	  GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
      Canvas3D c = new Canvas3D(config);
	    add("Center", c);
      c.addKeyListener(this);
      Panel p = new Panel();
      go.addActionListener(this);
      go.addKeyListener(this);
      p.add(go); 
      add("North",p);
 
	t = new Timer(100,this);

    // Create a structure to contain objects
    BranchGroup group = new BranchGroup();
	  
    // Create the universe
    SimpleUniverse universe = new SimpleUniverse(c);

    // Set up colors
    Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f red = new Color3f(0.7f, .15f, .15f);
    Color3f orange = new Color3f(1.0f, 0.5f, 0f);
    
    // Set up the texture map
    TextureLoader loader = new TextureLoader("C:\\Users\\lenovo\\Pictures\\2009-04\\caloris1.jpe", "LUMINANCE", new Container());
    Texture texture = loader.getTexture();
    texture.setBoundaryModeS(Texture.WRAP);
    texture.setBoundaryModeT(Texture.WRAP);
    texture.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
	
    // Set up the texture attributes 
    //could be REPLACE, BLEND or DECAL instead of MODULATE
    TextureAttributes texAttr = new TextureAttributes();
    texAttr.setTextureMode(TextureAttributes.MODULATE);
    Appearance ap = new Appearance();
    ap.setTexture(texture);
    ap.setTextureAttributes(texAttr);
 	
    //set up the material
    ap.setMaterial(new Material(black, black, white, black, 1.0f));
	                  
    // Create a ball to demonstrate textures
    int primflags = Primitive.GENERATE_NORMALS +                     
                    Primitive.GENERATE_TEXTURE_COORDS; 
    
    tg = new TransformGroup();
    tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	

    transform = new Transform3D();
    //MERCURY
    Sphere sphere = new Sphere(0.1f, primflags, ap);
    Vector3f vector = new Vector3f(xloc, height, .0f);
    transform.setTranslation(vector);
    //transform.invert(transform);
    tg.setTransform(transform);
    tg.addChild(sphere);
    
    
    //SUN
 // Set up the texture map
    TextureLoader loader2 = new TextureLoader("C:\\Users\\lenovo\\Pictures\\2009-04\\SunTexture.png", "LUMINANCE", new Container());
    Texture texture2 = loader2.getTexture();
    texture.setBoundaryModeS(Texture.WRAP);
    texture.setBoundaryModeT(Texture.WRAP);
    texture.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
	
    // Set up the texture attributes 
    //could be REPLACE, BLEND or DECAL instead of MODULATE
    TextureAttributes texAttr2 = new TextureAttributes();
    texAttr2.setTextureMode(TextureAttributes.BLEND);
    Appearance ap2 = new Appearance();
    ap2.setTexture(texture2);
    ap2.setTextureAttributes(texAttr2);
 	
    //set up the material
    ap2.setMaterial(new Material(red, orange, red, orange, 1.0f));
	                  
    // Create a ball to demonstrate textures
    int primflags2 = Primitive.GENERATE_NORMALS +                     
                    Primitive.GENERATE_TEXTURE_COORDS; 
    
    //set second shape
    sphere2 = new Sphere(0.2f, primflags2, ap2);    
    Vector3f vector2 = new Vector3f(0f, -0.5f, .0f);
    transform.setTranslation(vector2);
    

    group.addChild(tg);
    group.addChild(sphere2);

/****/
    
    //Set up the texture map
    TextureLoader loader3 = new TextureLoader("C:\\Users\\lenovo\\Pictures\\2009-04\\SunTexture.png", "LUMINANCE", new Container());
    Texture texture3 = loader3.getTexture();
    texture.setBoundaryModeS(Texture.WRAP);
    texture.setBoundaryModeT(Texture.WRAP);
    texture.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
	
    // Set up the texture attributes 
    //could be REPLACE, BLEND or DECAL instead of MODULATE
    TextureAttributes texAttr3 = new TextureAttributes();
    texAttr3.setTextureMode(TextureAttributes.BLEND);
    Appearance ap3 = new Appearance();
    ap3.setTexture(texture3);
    ap3.setTextureAttributes(texAttr3);
 	
    //set up the material
    ap3.setMaterial(new Material(red, orange, red, orange, 1.0f));
	                  
    // Create a ball to demonstrate textures
    int primflags3 = Primitive.GENERATE_NORMALS +                     
                    Primitive.GENERATE_TEXTURE_COORDS; 
    
    //set second shape
    sphere3 = new Sphere(0.2f, primflags3, ap3);    
    Vector3f vector3 = new Vector3f(0f, -0.5f, .5f);
    transform.setTranslation(vector3);
    
    
    //group.addChild(tg);
    group.addChild(sphere3);
   
/**/
    
    // Create lights
    Color3f light1Color = new Color3f(1f, 1f, 1f);
    BoundingSphere bounds =
	    new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

    Vector3f light1Direction  = new Vector3f(4.0f, -7.0f, -12.0f);
    DirectionalLight light1
      = new DirectionalLight(light1Color, light1Direction);
    light1.setInfluencingBounds(bounds);
    group.addChild(light1);
    
    AmbientLight ambientLight = new AmbientLight(new Color3f(.5f,.5f,.5f));
    ambientLight.setInfluencingBounds(bounds);
    group.addChild(ambientLight); 
    
    // look towards the ball
    universe.getViewingPlatform().setNominalViewingTransform();

    // add the group of objects to the Universe
    universe.addBranchGraph(group);
  }
  
  public static void main(String[] args) {
    NewCanvas c = new NewCanvas();
    c.addKeyListener(c);
    	MainFrame mf = new MainFrame(c, 800, 690);
  }

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

	if (!t.isRunning()) {
        t.start();
    }
	else
	{
		if( xloc < 0.7 && xloc >= 0 && height <= 0.7 && height > 0)
		{
			xloc += 0.1f;
			if(0.49f > (xloc*xloc)){
			height = (float) Math.sqrt((0.49f - (xloc*xloc)));
			}
			else
			{
				height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
			}
		}
		else if( xloc <= 0.8 && xloc >= 0 && height >= -0.7 && height <= 0.3)
		{
			xloc -= 0.1f;
			if(0.49f > (xloc*xloc))
			{
			height = -1 *(float) Math.sqrt((0.49f - (xloc*xloc)));
			}
			else
			{
				height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
			}
		}
		else if( xloc > -0.6 && xloc <= 0 && height >= -0.7 && height < 0)
		{
			xloc -= 0.1f;
			if(0.49f > (xloc*xloc))
			{
				height = -(float) Math.sqrt((0.49f - (xloc*xloc)));
			}
		}
		else
		{
			xloc += 0.1f;
			if(0.49f > (xloc*xloc))
			{
			height = (float) Math.sqrt((0.49f - (xloc*xloc)));
			}
			else
			{
				height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
			}
		}
		
		if( xloc > 0.6 && xloc < 0 && height <= 0.7 && height > 0)
			{
				xloc += 0.1f;
				if(0.49f > (xloc*xloc)){
				height = (float) Math.sqrt((0.49f - (xloc*xloc)));
				}
				else
				{
					height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
				}
			}
			else if( xloc <= 0.8 && xloc >= 0 && height >= -0.7 && height <= 0.3)
			{
				xloc -= 0.1f;
				if(0.49f > (xloc*xloc))
				{
				height = -1 *(float) Math.sqrt((0.49f - (xloc*xloc)));
				}
				else
				{
					height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
				}
			}
			else if( xloc > -0.6 && xloc <= 0 && height >= -0.7 && height < 0)
			{
				xloc -= 0.1f;
				if(0.49f > (xloc*xloc))
				{
					height = -(float) Math.sqrt((0.49f - (xloc*xloc)));
				}
			}
			else
			{
				xloc += 0.1f;
				if(0.49f > (xloc*xloc))
				{
				height = (float) Math.sqrt((0.49f - (xloc*xloc)));
				}
				else
				{
					height = (float) Math.sqrt((xloc*xloc) - 0.49f);	
				}
			}
		transform.setTranslation(new Vector3f(xloc, height, zloc ));
		
		tg.setTransform(transform);
	    
	}
}

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getKeyChar()=='p' || arg0.getKeyChar()=='P')
	{
		pcounter++;
		if(pcounter % 2 != 0)
		{
			t.stop();
		}
		else
		{
			t.start();
		}
	}
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
