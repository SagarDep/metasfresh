package org.adempiere.exceptions;

import de.metas.util.Check;

/**
 * Exception thrown when a standard adempiere window (AD_Window) failed to load because of:
 * <ul>
 * <li>no user/role access
 * <li>no tabs
 * <li>etc
 * </ul>
 * 
 * @author tsa
 * @task http://dewiki908/mediawiki/index.php/08508_NPE_when_opening_Warenbewegung_-_%C3%9Cbersicht_with_role_Handel_%28109844897323%29
 */
public class WindowLoadException extends AdempiereException
{
	/**
	 *
	 */
	private static final long serialVersionUID = -5396156685197179469L;

	public WindowLoadException(final String message, final String roleName, final String windowName, final int adWindowId)
	{
		super(buildMsg(message, roleName, windowName, adWindowId));
	}

	private static String buildMsg(final String message, final String roleName, final String windowName, final int adWindowId)
	{
		final StringBuilder messageFinal = new StringBuilder("@AccessTableNoView@");
		if (!Check.isEmpty(message, true))
		{
			messageFinal.append(" (").append(message.trim()).append(")");
		}

		messageFinal.append("\n @AD_Role_ID@: ").append(roleName);
		messageFinal.append("\n @AD_Window_ID@: ").append(windowName).append(" (ID=").append(adWindowId).append(")");

		return messageFinal.toString();
	}
}
