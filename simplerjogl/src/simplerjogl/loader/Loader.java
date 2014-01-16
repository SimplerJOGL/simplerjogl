package simplerjogl.loader;

import java.io.*;
import javax.media.opengl.*;
import simplerjogl.*;

public abstract class Loader {

	protected GL gl;

	public Loader(GL gl) {
		this.gl = gl;
	}

	public LoadedModel load(String filename) throws IOException {
		return load(new File(filename));
	}

	public LoadedModel load(InputStream in) throws IOException {
		return load(new InputStreamReader(in));
	}

	public LoadedModel load(File file) throws IOException {
		return load(new FileReader(file));
	}

	public abstract LoadedModel load(Reader r) throws IOException;
}
