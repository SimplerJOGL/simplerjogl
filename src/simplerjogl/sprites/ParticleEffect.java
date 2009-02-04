
package simplerjogl.sprites;

import javax.media.opengl.*;

public class ParticleEffect extends Sprite
{
	protected Particle particles[];

	public ParticleEffect (GL gl, int numParticles, double left, double top, double front, double right, double bottom, double back)
	{
		super (gl);
		particles = new Particle[numParticles];
		for (int i = 0; i < particles.length; i++ )
		{
			particles[i] = new Particle (gl, left, top, front, right, bottom, back);
		}
	}

	public void move ()
	{
		for (int i = 0; i < particles.length; i++ )
		{
			particles[i].move ();
		}
	}

	public void draw ()
	{
		super.draw ();
		move ();
	}

	public void spriteDraw ()
	{
		for (int i = 0; i < particles.length; i++ )
		{
			particles[i].draw ();
		}
	}
}
