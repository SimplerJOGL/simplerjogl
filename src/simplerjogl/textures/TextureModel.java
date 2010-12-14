
package simplerjogl.textures;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.sun.opengl.util.texture.Texture;

import simplerjogl.Model;
import simplerjogl.TextureLoader;

public class TextureModel extends Model
{
	protected Texture texture;

	public TextureModel (GL2 gl, String fileName)
	{
		super (gl);
		texture = TextureLoader.load (fileName);
		if (texture != null && !gl.glIsEnabled (GL.GL_TEXTURE_2D))
		{
			gl.glEnable (GL.GL_TEXTURE_2D);
		}
	}

	protected boolean textureLoaded ()
	{
		return (texture != null);
	}

	public void draw ()
	{
		if (texture != null)
		{
			texture.bind ();
		}
	}
}
