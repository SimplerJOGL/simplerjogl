
package simplerjogl.shell;

import java.awt.*;

import javax.swing.JOptionPane;

import simplerjogl.Frame;

public class ShellFrame extends Frame
{
	protected Shell shell;

	public Shell getShell ()
	{
		return shell;
	}

	/**
	 * Statically create an instance of a GLFrame
	 * 
	 * @param title
	 *            the title of the window
	 * @param fullscreen
	 *            true to ask to run fullscreen, false to just run windowed
	 */
	public static ShellFrame createFrame (String title, boolean fullscreen)
	{
		/*
		 * get some information about the physical display system that
		 * we're using
		 */
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment ().getDefaultScreenDevice ();
		if (fullscreen)
		{
			/* ask if we should run fullscreen */
			if (device.isFullScreenSupported ())
			{
				/*
				 * throw up a generic dialog box to ask if we should run
				 * windowed or fullscreen
				 */
				int selectedOption = JOptionPane.showOptionDialog (null, "How would you like to run this program?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Fullscreen", "Windowed" }, "Windowed");
				fullscreen = (selectedOption == 0);
			}
		}
		/* create the desired window and return a reference to it */
		return new ShellFrame (title, DEFAULT_WIDTH, DEFAULT_HEIGHT, fullscreen);
	}

	protected ShellFrame (String title, int width, int height, boolean fullscreen)
	{
		super (title, width, height, fullscreen);
		shell = new Shell (frame);
		addKeyListener (shell);
	}

	public void addShellListener (ShellListener t)
	{
		shell.addShellListener (t);
	}

	public void removeShellListener (ShellListener t)
	{
		shell.removeShellListener (t);
	}
}
