
package simplerjogl.sprites;

import javax.media.opengl.*;

public abstract class Bouncer extends Sprite
{
	protected double dx, dy, dz;
	protected double left, top, front, right, bottom, back;

	public Bouncer (GL gl, double left, double top, double front, double right, double bottom, double back)
	{
		this (gl, 0, 0, 0, Math.random (), Math.random (), Math.random (), left, top, front, right, bottom, back);
	}

	public Bouncer (GL gl, double x, double y, double z, double dx, double dy, double dz, double left, double top, double front, double right, double bottom, double back)
	{
		super (gl);
		this.x = Math.max (left, Math.min (x, right));
		this.y = Math.max (bottom, Math.min (y, top));
		this.z = Math.max (back, Math.min (z, front));
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
		this.left = left;
		this.top = top;
		this.front = front;
		this.right = right;
		this.bottom = bottom;
		this.back = back;
	}

	public void draw ()
	{
		move ();
		gl.glPushMatrix ();
		{
			gl.glTranslated (x, y, z);
			spriteDraw ();
		}
		gl.glPopMatrix ();
	}

	public void move ()
	{
		if ( (x <= left) || (x >= right))
		{
			dx *= -1;
		}
		if ( (y <= bottom) || (y >= top))
		{
			dy *= -1;
		}
		if ( (z <= back) || (z >= front))
		{
			dz *= -1;
		}
		x += dx;
		y += dy;
		z += dz;
	}
}