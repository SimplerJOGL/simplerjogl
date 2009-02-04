
package simplerjogl.shell;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Shell implements KeyListener
{
	protected final static String PROMPT = "> ";
	protected final static char WORD_BREAK = ' ';
	protected final static char LINE_BREAK = '\n';
	protected EventListenerList shellListeners;
	protected JTextArea shell;
	protected JScrollPane pane;
	protected String wordBuffer;
	protected ShellEvent eventBuffer;
	private boolean haveCommand; // has a command
	// been received?
	private boolean isMidRead; // are we currently
	// reading input?
	private boolean isMidPrint; // are we in the

	// middle of
	// printing a line?
	public Shell (JFrame frame)
	{
		shellListeners = new EventListenerList ();
		shell = new JTextArea ();
		shell.setColumns (20);
		pane = new JScrollPane (shell);
		frame.getContentPane ().add (pane, BorderLayout.EAST);
		isMidRead = false;
		isMidPrint = false;
	}

	public void addShellListener (ShellListener t)
	{
		shellListeners.add (ShellListener.class, t);
		t.registerShell (this);
	}

	public void removeShellListener (ShellListener t)
	{
		shellListeners.remove (ShellListener.class, t);
	}

	public void keyPressed (KeyEvent e)
	{}

	public void keyReleased (KeyEvent e)
	{}

	public void keyTyped (KeyEvent e)
	{
		if (isMidRead)
		{
			if ( (e.getKeyChar () == WORD_BREAK) || (e.getKeyChar () == LINE_BREAK))
			{
				if (haveCommand)
				{
					eventBuffer.addParameter (wordBuffer);
				}
				else
				{
					eventBuffer.setCommand (wordBuffer);
					haveCommand = true;
				}
				print (String.valueOf (e.getKeyChar ()));
				clearWordBuffer ();
				if (e.getKeyChar () == LINE_BREAK)
				{
					isMidRead = false;
					ShellListener[] listeners = shellListeners.getListeners (ShellListener.class);
					for (ShellListener l : listeners)
					{
						l.commandComplete (new ShellEvent (eventBuffer));
					}
				}
			}
			else
			{
				wordBuffer = wordBuffer + e.getKeyChar ();
				print (String.valueOf (e.getKeyChar ()));
			}
		}
	}

	public void print (String s)
	{
		shell.setText (shell.getText ().concat (s));
		isMidPrint = !s.endsWith ("\n");
	}

	public void println (String s)
	{
		print (s + "\n");
	}

	public void readln ()
	{
		if (isMidPrint)
		{
			println ("\n");
		}
		print (PROMPT);
		clearEventBuffer ();
		isMidRead = true;
	}

	public boolean isMidRead ()
	{
		return isMidRead;
	}

	protected void clearWordBuffer ()
	{
		wordBuffer = new String ();
	}

	protected void clearEventBuffer ()
	{
		eventBuffer = new ShellEvent (this);
		clearWordBuffer ();
		haveCommand = false;
	}
}