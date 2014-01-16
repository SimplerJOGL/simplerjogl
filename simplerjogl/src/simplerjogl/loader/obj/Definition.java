package simplerjogl.loader.obj;

import java.io.*;

public class Definition {
	private String type;
	private String[] parameter;

	public Definition(String text) throws IOException {
		this(text, 3);
	}

	public Definition(String text, int minimumParameterCount)
			throws IOException {
		this(text, minimumParameterCount, Integer.MAX_VALUE - 1);
	}

	public Definition(String text, int minimumParameterCount,
			int maximumParameterCount) throws IOException {
		String[] token = text.split("\\s");

		if (token.length < minimumParameterCount + 1) {
			throw new IOException("Invalid definition: " + (token.length - 1)
					+ " parameters, minimum of " + minimumParameterCount
					+ " expected: \"" + text + "\"");
		}

		if (token.length > maximumParameterCount + 1) {
			throw new IOException("Invalid definition: " + (token.length - 1)
					+ " parameters, maximum of " + maximumParameterCount
					+ " expected: \"" + text + "\"");
		}

		type = token[0];
		parameter = new String[token.length - 1];
		for (int i = 0; i < parameter.length; i++) {
			parameter[i] = token[i + 1];
		}
	}

	public String getType() {
		return type;
	}

	public int getParameterCount() {
		return parameter.length;
	}

	public String getParameter(int i) {
		return parameter[i];
	}
}
