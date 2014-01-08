
package particle_effect;

import simplerjogl.*;

public class JOGLRenderer extends Renderer
{
	private Rain shower;
	private Light l;

	public void init ()
	{
		shower = new Rain (gl);
		l = new Light (gl);
		l.enable ();
	}

	public void display ()
	{
		glu.gluLookAt (0, 0, 20, 0, 0, 0, 0, 1, 0);
		shower.draw ();
		gl.glTranslated (0, 5, 0);
		gl.glRotated (90, 1, 0, 0);
		glut.glutSolidCylinder (2, 10, 100, 2);
	}
}