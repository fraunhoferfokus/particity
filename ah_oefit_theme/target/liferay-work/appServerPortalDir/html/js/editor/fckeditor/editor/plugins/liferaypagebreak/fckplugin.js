/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

FCKToolbarItems.RegisterItem(
	'LiferayPageBreak',
	new FCKToolbarButton('LiferayPageBreak', FCKLang.Source, null, FCK_TOOLBARITEM_ONLYICON, true, true, 1));

var InsertLiferayPageBreakCommand = function() {
};

InsertLiferayPageBreakCommand.prototype.Execute = function() {
}

InsertLiferayPageBreakCommand.GetState = function() {
	return FCK_TRISTATE_OFF;
}

InsertLiferayPageBreakCommand.Execute = function() {
	FCK.Focus();
	FCK.InsertHtml(_TOKEN_PAGE_BREAK);
}

FCKCommands.RegisterCommand('LiferayPageBreak', InsertLiferayPageBreakCommand);

var oInsertVariables = new FCKToolbarButton('LiferayPageBreak', 'Insert page break');

oInsertVariables.IconPath = FCKConfig.PluginsPath + 'liferaypagebreak/pagebreak.gif';

FCKToolbarItems.RegisterItem('LiferayPageBreak', oInsertVariables);