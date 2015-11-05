/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.adhoc.socialize;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins;

/**
 * A factory for creating I_SocialMediaClient objects.
 */
public class SocialMediaFactory {

	/**
	 * Gets a client.
	 *
	 * @param type the type of the client
	 * @return the default implementation, or null if not available
	 */
	public static I_SocialMediaClient getClient(final E_SocialMediaPlugins type) {
		I_SocialMediaClient result = null;

		switch (type) {
			case FACEBOOK:
				result = getFacebookClient();
				break;
			case TWITTER:
				result = getTwitterClient();
				break;
		}

		return result;
	}

	/**
	 * Gets the facebook client.
	 *
	 * @return the facebook client
	 */
	public static I_SocialMediaClient getFacebookClient() {
		return FacebookClient.getInstance();
	}

	/**
	 * Gets the twitter client.
	 *
	 * @return the twitter client
	 */
	public static I_SocialMediaClient getTwitterClient() {
		return TwitterClient.getInstance();
	}

	/**
	 * Refresh the configuration of all clients. That is: call the client implementation to reconnect
	 */
	public static void refreshCfg() {
		for (final E_SocialMediaPlugins sm : E_SocialMediaPlugins.values()) {
			final I_SocialMediaClient client = getClient(sm);
			if (client != null) {
				client.reconnect();
			}
		}
	}

}
