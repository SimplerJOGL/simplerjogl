
package simplerjogl;

import javax.media.opengl.*;

/**
 * A wrapper class for materials
 * 
 * @author Seth Battis
 * @version 2009-01-07
 */
public class Material
{
	/**
	 * OpenGL drawing context in which this material is used
	 */
	protected GL gl;
	protected Color ambient, diffuse, specular, emission;
	protected double shininess;
	protected int face;

	/* color indexes not included */
	/**
	 * Defaults to default OpenGL materials (non-reflective light gray)
	 */
	public Material (GL gl)
	{
		this.gl = gl;
		setFace (GL.GL_FRONT_AND_BACK);
		setAmbient (0.2f, 0.2f, 0.2f, 1);
		setDiffuse (0.8f, 0.8f, 0.8f, 1);
		setSpecular (0, 0, 0, 1);
		setEmission (0, 0, 0, 1);
		setShininess (0);
	}

	/**
	 * Copy constructor, creates a duplicate of other material
	 */
	public Material (Material other)
	{
		this.gl = other.gl;
		setFace (other.face);
		setAmbient (other.ambient);
		setDiffuse (other.diffuse);
		setSpecular (other.specular);
		setEmission (other.emission);
		setShininess (other.shininess);
	}

	public static void enableBlending (GL gl)
	{
		gl.glEnable (GL.GL_BLEND);
		gl.glBlendFunc (GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
	}

	/**
	 * Construct a material
	 */
	public Material (GL gl, Color color)
	{
		this (gl);
		this.diffuse = new Color (color);
	}

	public boolean equals (Material other)
	{
		if (other == null)
		{
			return false;
		}
		return (this.face == other.face) && this.ambient.equals (other.ambient) && this.diffuse.equals (other.diffuse) && this.specular.equals (other.specular) && this.emission.equals (other.emission) && (this.shininess == other.shininess);
	}

	/**
	 * Apply the material to subsequent objects
	 */
	public void use ()
	{
		useOnFace (face);
	}

	/**
	 * Apply the material to a particular face of subsequent objects
	 * 
	 * @param face
	 *            GL_FRONT, GL_BACK or GL_FRONT_AND_BACK
	 */
	public void useOnFace (int face)
	{
		gl.glMaterialfv (face, GL.GL_AMBIENT, ambient.getRGBAf (), 0);
		gl.glMaterialfv (face, GL.GL_DIFFUSE, diffuse.getRGBAf (), 0);
		gl.glMaterialfv (face, GL.GL_SPECULAR, specular.getRGBAf (), 0);
		gl.glMaterialfv (face, GL.GL_EMISSION, emission.getRGBAf (), 0);
		gl.glMaterialf (face, GL.GL_SHININESS, (float) shininess);
		gl.glColor4fv (diffuse.getRGBAf (), 0);
	}

	/**
	 * Change the ambient component of the material (n.b. that the material
	 * must be re-use()ed to apply changes to the model)
	 */
	public Color setAmbient (double red, double green, double blue, double alpha)
	{
		return setAmbient (new Color (red, green, blue, alpha));
	}

	public Color setAmbient (Color c)
	{
		Color oldAmb = ambient;
		ambient = new Color (c);
		return oldAmb;
	}

	/**
	 * Change the diffuse component of the material (n.b. that the material
	 * must be re-use()ed to apply changes to the model)
	 */
	public Color setDiffuse (double red, double green, double blue, double alpha)
	{
		return setDiffuse (new Color (red, green, blue, alpha));
	}

	/**
	 * Change the diffuse component of the material (n.b. that the material
	 * must be re-use()ed to apply changes to the model)
	 */
	public Color setDiffuse (Color c)
	{
		Color oldDiff = diffuse;
		diffuse = new Color (c);
		return oldDiff;
	}

	/**
	 * Change the specular component of the material (n.b. that the
	 * material must be re-use()ed to apply changes to the model)
	 */
	public Color setSpecular (double red, double green, double blue, double alpha)
	{
		return setSpecular (new Color (red, green, blue, alpha));
	}

	/**
	 * Change the specular component of the material (n.b. that the
	 * material must be re-use()ed to apply changes to the model)
	 */
	public Color setSpecular (Color c)
	{
		Color oldSpec = specular;
		specular = new Color (c);
		return oldSpec;
	}

	/**
	 * Change the emission component of the material (n.b. that the
	 * material must be re-use()ed to apply changes to the model)
	 */
	public Color setEmission (double red, double green, double blue, double alpha)
	{
		return setEmission (new Color (red, green, blue, alpha));
	}

	public Color setEmission (Color c)
	{
		Color oldEmis = emission;
		emission = new Color (c);
		return oldEmis;
	}

	/**
	 * Change the shininess component of the material (n.b. that the
	 * material must be re-use()ed to apply changes to the model)
	 * 
	 * @param shininess
	 *            0-128
	 */
	public double setShininess (double shininess)
	{
		double oldShin = this.shininess;
		this.shininess = Math.max (0, Math.min (shininess, 128));
		return oldShin;
	}

	public float setShininess (float shininess)
	{
		return (float) setShininess ((double) shininess);
	}

	/**
	 * Change the face to which to apply the material (n.b. that the
	 * material must be re-use()ed to apply changes to the model)
	 * 
	 * @param face
	 *            GL_FRONT, GL_BACK or GL_FRONT_AND_BACK
	 */
	public int setFace (int face)
	{
		int oldFace = this.face;
		this.face = face;
		return oldFace;
	}
}