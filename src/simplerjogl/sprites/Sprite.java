
package simplerjogl.sprites;

import javax.media.opengl.*;

import simplerjogl.*;

public abstract class Sprite extends Model
{
	protected double x, y, z;

	public Sprite (GL gl)
	{
		this (gl, 0, 0, 0);
	}

	public Sprite (GL gl, double x, double y, double z)
	{
		super (gl);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void draw ()
	{
		spriteDraw ();
	}

	public double getX ()
	{
		return x;
	}

	public double getY ()
	{
		return y;
	}

	public double getZ ()
	{
		return z;
	}

	public double setX (double newX)
	{
		double oldX = x;
		x = newX;
		return oldX;
	}

	public double setY (double newY)
	{
		double oldY = y;
		y = newY;
		return oldY;
	}

	public double setZ (double newZ)
	{
		double oldZ = z;
		z = newZ;
		return oldZ;
	}

	public abstract void move ();

	public abstract void spriteDraw ();
}
