<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/wiki/init.jsp" %>

<h4>
	<liferay-ui:message key="text-styles" />
</h4>

<pre>
''italics''
'''bold'''
</pre>

<h4>
	<liferay-ui:message key="headers" />
</h4>

<pre>
== Large heading ==
=== Medium heading ===
==== Small heading ====
</pre>

<h4>
	<liferay-ui:message key="links" />
</h4>

<pre>
[[Internal Link | Optional Label]]
[http://example.com External Link]
</pre>

<h4>
	<liferay-ui:message key="lists" />
</h4>

<pre>
* Item
** Subitem
# Ordered Item
## Ordered Subitem
</pre>

<h4>
	<liferay-ui:message key="images" />
</h4>

<pre>
[[Image:attached-image.png]]
[[Image:Page Name/image.jpg]]
</pre>

<h4>
	<liferay-ui:message key="other" />
</h4>

<pre>
Table of contents:
	Added automatically
Code block:
	Start each line with a space
Inline code:
	&lt;code&gt;Test.java&lt;/code&gt;
</pre>