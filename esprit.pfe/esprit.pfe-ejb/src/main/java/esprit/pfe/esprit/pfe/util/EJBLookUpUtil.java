package esprit.pfe.esprit.pfe.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBLookUpUtil {
	

		private static Context ctx;

		public static Object doLookup(String jndiName)

		{
			Object proxy = null;

			if (null == ctx)

			{

				try {
					ctx = new InitialContext();
				} catch (NamingException e) {
				}

			}

			try {
				proxy= ctx.lookup(jndiName);
			} catch (NamingException e) {
			}
			return proxy;

		}

	}
