package simplerjogl;

import java.util.*;
import javax.media.opengl.*;

public class Face extends SimplerJOGLObject {
	private List<Vertex> vertices;

	public Face(GL gl) {
		super(gl);
		vertices = new LinkedList<Vertex>();
	}

	public Face(GL gl, Vertex v) {
		this(gl);
		add(v);
	}

	public Face(GL gl, List<Vertex> l) {
		this(gl);
		addAll(l);
	}

	public Face(Face other) {
		this(other.gl);
		Iterator<Vertex> i = other.vertices.iterator();
		while (i.hasNext()) {
			Vertex v = i.next();
			add(v);
		}
	}

	public void add(Vertex v) {
		vertices.add(new Vertex(v));
	}

	public void addAll(List<Vertex> l) {
		Iterator<Vertex> i = l.iterator();
		while (i.hasNext()) {
			Vertex v = i.next();
			add(v);
		}
	}

	public void draw() {
		if (vertices.size() == 3) {
			gl.glBegin(GL2.GL_TRIANGLES);
		} else if (vertices.size() == 4) {
			gl.glBegin(GL2.GL_QUADS);
		} else {
			gl.glBegin(GL2.GL_POLYGON);
		}

		Iterator<Vertex> i = vertices.iterator();
		while (i.hasNext()) {
			Vertex v = i.next();
			gl.glVertex4fv(v.getXYZWf(), 0);
		}

		gl.glEnd();
	}

}