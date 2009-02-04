
package simplerjogl.shell;

import java.util.*;

@SuppressWarnings ("serial")
public class ShellEvent extends EventObject
{
	protected String command;
	protected String[] parameters;

	public ShellEvent (Shell source)
	{
		super (source);
		command = new String ();
		parameters = new String[0];
	}

	public ShellEvent (ShellEvent other)
	{
		super (other);
		setCommand (other.command);
		setParameters (other.parameters);
	}

	public String getCommand ()
	{
		return new String (command);
	}

	public String[] getParameters ()
	{
		String[] a = new String[parameters.length];
		System.arraycopy (parameters, 0, a, 0, parameters.length);
		return a;
	}

	public String getString ()
	{
		String s = new String (command);
		for (String p : parameters)
		{
			s += " " + p;
		}
		return s;
	}

	public String toString ()
	{
		String s = new String (command + " (");
		for (String p : parameters)
		{
			s = s + p + ", ";
		}
		if (parameters.length > 0)
		{
			s = s.substring (0, s.length () - 2);
		}
		s = s.concat (")");
		return s;
	}

	public void setCommand (String s)
	{
		command = new String (s);
	}

	public void setParameters (String[] a)
	{
		parameters = new String[a.length];
		System.arraycopy (a, 0, parameters, 0, a.length);
	}

	public void addParameter (String s)
	{
		String[] newParam = new String[parameters.length + 1];
		System.arraycopy (parameters, 0, newParam, 0, parameters.length);
		newParam[parameters.length] = new String (s);
		parameters = newParam;
	}
}
