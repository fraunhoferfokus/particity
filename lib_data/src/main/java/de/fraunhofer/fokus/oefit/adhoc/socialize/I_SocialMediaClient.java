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

import java.net.URL;

/**
 * An interface for social media clients that allow posting of short messages and URLs
 */
public interface I_SocialMediaClient {

	/**
	 * Check whether this client is actually enabled
	 * 
	 * There is no hard definition, what enabled means. A service could be 
	 * disabled, because no API is available, or (usually) because it
	 * depends upon a global configuration settings that can be set by the
	 * user at some point
	 * 
	 * @return true, if enabled, false otherwise
	 */
	public boolean isEnabled();
	
	/**
	 * Checks if the client is connected
	 *
	 * @return true, if is connected
	 */
	public boolean isConnected();

	/**
	 * Publish an offer 
	 *
	 * @param permalink a permalink to the frontend-view of the offer
	 * @param offerId the offer ID
	 * @return true, if successfully published, false otherwise
	 */
	public boolean publishOffer(URL permalink, Long offerId);

	/**
	 * Reconnect the client. Important: The client may need to re-read its configuration, as this method will be called on reconfiguration.
	 *
	 * @return true, if successful, false otherwise
	 */
	public boolean reconnect();

	/**
	 * Send a message
	 *
	 * @param url Any URL for further information about the message
	 * @param message the message itself
	 * @return true, if successful, false otherwise
	 */
	public boolean send(URL url, String message);

	/**
	 * Returns a CSS class that represents this plugin. Usually this CSS 
	 * contains some sort of logo for representing the provider
	 * 
	 * @return The CSS class representing this implementation
	 */
	public String getCssClass();
}