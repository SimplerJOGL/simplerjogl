
package simplerjogl.shell;

import java.util.EventListener;

public interface ShellListener extends EventListener
{
	public void registerShell (Shell t);

	public abstract void commandComplete (ShellEvent e);
}