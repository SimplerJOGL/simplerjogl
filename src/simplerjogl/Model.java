
package simplerjogl;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;

import com.sun.opengl.util.*;

public abstract class Model
{
	protected GL gl;
	protected GLU glu;
	protected GLUT glut;
	protected Material red, orange, yellow, green, cyan, blue, purple, magenta, white, black;

	public Model (GL gl)
	{
		this.gl = gl;
		glu = new GLU ();
		glut = new GLUT ();
		red = new Material (gl);
		red.setDiffuse (1, 0, 0, 1);
		orange = new Material (gl);
		orange.setDiffuse (1, 0.5f, 0, 1);
		yellow = new Material (gl);
		yellow.setDiffuse (1, 1, 0, 1);
		green = new Material (gl);
		green.setDiffuse (0, 1, 0, 1);
		cyan = new Material (gl);
		cyan.setDiffuse (0, 1, 1, 1);
		blue = new Material (gl);
		blue.setDiffuse (0, 0, 1, 1);
		purple = new Material (gl);
		purple.setDiffuse (1, 0, 0.5f, 1);
		magenta = new Material (gl);
		magenta.setDiffuse (1, 0, 1, 1);
		white = new Material (gl);
		white.setDiffuse (1, 1, 1, 1);
		black = new Material (gl);
		black.setDiffuse (0, 0, 0, 1);
	}

	public Model (Model other)
	{
		this.gl = other.gl;
		this.glu = other.glu;
		this.glut = other.glut;
		this.red = new Material (other.red);
		this.orange = new Material (other.orange);
		this.yellow = new Material (other.yellow);
		this.green = new Material (other.green);
		this.cyan = new Material (other.cyan);
		this.blue = new Material (other.blue);
		this.purple = new Material (other.purple);
		this.magenta = new Material (other.magenta);
		this.white = new Material (other.white);
		this.black = new Material (other.black);
	}

	public abstract void draw ();
}
