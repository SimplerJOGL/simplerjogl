package objloader;

import java.io.IOException;

import javax.media.opengl.GLArrayData;
import simplerjogl.*;
import simplerjogl.loader.obj.*;

public class JOGLRenderer extends Renderer
{
	private LoadedObjModel suzanne;
	private float rot;
	
	public void init ()
	{
		try {
			suzanne = (LoadedObjModel) new ObjLoader(gl).load("model/suzanne.obj");
		} catch (IOException e) {
			e.printStackTrace();
		}

		rot = 0;
	}

	public void display ()
	{
		glu.gluLookAt (0, 0, 5, 0, 0, 0, 0, 1, 0);
		gl.glRotatef(rot++, 0, 1, 0);
		suzanne.wireframe();
	}
}