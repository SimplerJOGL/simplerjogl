package objloader;

import java.io.*;
import simplerjogl.*;
import simplerjogl.loader.LoadedModel;
import simplerjogl.loader.obj.*;

/**
 * Demonstrate the use of an OBJ Loader to import Wavefront OBJ files into
 * SimplerJOGL.
 * 
 * @author <a href="mailto:seth@battis.net">Seth Battis</a>
 * 
 */
public class JOGLRenderer extends Renderer {

	/* a model that will be loaded from a Wavefront OBJ file */
	private LoadedModel objModel;

	private int degreesOfRotation;
	private Light basicLight;

	public void init() {
		/*
		 * load the OBJ file from the model directory as a model. Note that,
		 * since we are dealing with file I/O, IOExceptions may be thrown so we
		 * either need to throw them ourselves or catch them.
		 */
		try {
			objModel = new ObjLoader(gl).load("model/head/head.OBJ");
		} catch (IOException e) {
			e.printStackTrace();
		}

		degreesOfRotation = 0;
		basicLight = new Light(gl);
		basicLight.enable();
	}

	public void display() {
		glu.gluLookAt(0, 0, 5, 0, 0, 0, 0, 1, 0);
		gl.glRotatef(degreesOfRotation++, 0, 1, 0);
		objModel.draw();
	}
}