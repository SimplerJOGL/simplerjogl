package simplerjogl.loader.obj;

import java.util.*;

import javax.media.opengl.GL;

import simplerjogl.*;
import simplerjogl.loader.*;

public class LoadedObjModel extends LoadedModel {

	private List<Face> faces;
	
	public LoadedObjModel(GL gl) {
		super(gl);
		faces = new LinkedList<Face>();
	}
	
	public LoadedObjModel(GL gl, List<Face> l) {
		this(gl);
		addAll(l);
	}

	public void add(Face f) {
		faces.add(new Face(f));
	}
	
	public void addAll(List<Face> l) {
		Iterator<Face> i = l.iterator();
		while (i.hasNext()) {
			Face f = i.next();
			add(f);
		}
	}

	public void draw(boolean wireframe) {
		Iterator<Face> i = faces.iterator();
		while (i.hasNext()) {
			Face f = i.next();
			f.draw(wireframe);
		}
	}

	public void draw() {
		draw(false);
	}
}
