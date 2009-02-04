
package simplerjogl.simplerjogl2d;

import javax.media.opengl.*;

import simplerjogl.*;

public class Renderer2D extends Renderer
{
	/**
	 * Called by the GL canvas during the first repaint after the canvas
	 * has been resized. This is an opportunity to update the viewport and
	 * view volumes of the canvas to match the new size of the canvas. For
	 * convenience, the canvas has already called the GL.glViewport()
	 * method before this method is called, so we may not have to do
	 * anything!
	 * 
	 * @param glDrawable
	 *            the GL object in which we are drawing
	 * @param x
	 *            the x-coordinate of the viewport rectangle
	 * @param y
	 *            the y-coordinate of the viewport rectangle
	 * @param width
	 *            the new width of the canvas
	 * @param height
	 *            the new height of the canvas
	 */
	public void reshape (GLAutoDrawable glDrawable, int x, int y, int width, int height)
	{
		updateGL (glDrawable);
		/* continue to use 3-D projection to calculate our view volume */
		gl.glMatrixMode (GL.GL_PROJECTION);
		gl.glLoadIdentity ();
		gl.glOrtho ((float) width / -2f, (float) width / 2f, (float) height / -2f, (float) height / 2f, 100, -100);
		/* we'd like to our transformations to be applied to our model */
		gl.glMatrixMode (GL.GL_MODELVIEW);
		gl.glLoadIdentity ();
		gl.glTranslatef ((float) width / 2f, (float) height / 2f, 0);
	}
}
