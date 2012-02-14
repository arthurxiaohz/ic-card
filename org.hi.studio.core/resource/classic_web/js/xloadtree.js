
/*----------------------------------------------------------------------------
|                               XLoadTree 1.11                                |
|-----------------------------------------------------------------------------|
|                         Created by Erik Arvidsson                           |
|                  (http://webfx.eae.net/contact.html#erik)                   |
|                      For WebFX (http://webfx.eae.net/)                      |
|-----------------------------------------------------------------------------|
| An extension to xTree that allows sub trees to be loaded at runtime by      |
| reading XML files from the server. Works with IE5+ and Mozilla 1.0+         |
|-----------------------------------------------------------------------------|
|                   Copyright (c) 1999 - 2002 Erik Arvidsson                  |
|-----------------------------------------------------------------------------|
| This software is provided "as is", without warranty of any kind, express or |
| implied, including  but not limited  to the warranties of  merchantability, |
| fitness for a particular purpose and noninfringement. In no event shall the |
| authors or  copyright  holders be  liable for any claim,  damages or  other |
| liability, whether  in an  action of  contract, tort  or otherwise, arising |
| from,  out of  or in  connection with  the software or  the  use  or  other |
| dealings in the software.                                                   |
| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
| This  software is  available under the  three different licenses  mentioned |
| below.  To use this software you must chose, and qualify, for one of those. |
| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
| The WebFX Non-Commercial License          http://webfx.eae.net/license.html |
| Permits  anyone the right to use the  software in a  non-commercial context |
| free of charge.                                                             |
| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
| The WebFX Commercial license           http://webfx.eae.net/commercial.html |
| Permits the  license holder the right to use  the software in a  commercial |
| context. Such license must be specifically obtained, however it's valid for |
| any number of  implementations of the licensed software.                    |
| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
| GPL - The GNU General Public License    http://www.gnu.org/licenses/gpl.txt |
| Permits anyone the right to use and modify the software without limitations |
| as long as proper  credits are given  and the original  and modified source |
| code are included. Requires  that the final product, software derivate from |
| the original  source or any  software  utilizing a GPL  component, such  as |
| this, is also licensed under the GPL license.                               |
|-----------------------------------------------------------------------------|
| 2001-09-27 | Original Version Posted.                                       |
| 2002-01-19 | Added some simple error handling and string templates for      |
|            | reporting the errors.                                          |
| 2002-01-28 | Fixed loading issues in IE50 and IE55 that made the tree load  |
|            | twice.                                                         |
| 2002-10-10 | (1.1) Added reload method that reloads the XML file from the   |
|            | server.                                                        |
/ 2003-05-06 | Added support for target attribute                             |
|-----------------------------------------------------------------------------|
| Dependencies: xtree.js - original xtree library                             |
|               xtree.css - simple css styling of xtree                       |
|               xmlextras.js - provides xml http objects and xml document     |
|                              objects                                        |
|-----------------------------------------------------------------------------|
| Created 2001-09-27 | All changes are in the log above. | Updated 2003-05-06 |
----------------------------------------------------------------------------*/
webFXTreeConfig.loadingText = "Loading...";
webFXTreeConfig.loadErrorTextTemplate = "Error loading \"%1%\"";
webFXTreeConfig.emptyErrorTextTemplate = "Error \"%1%\" does not contain any tree items";
/*
 * WebFXLoadTree class
 */
function WebFXLoadTree(sText, sXmlSrc, sAction, sTarget, sCheckbox, sIconarr, sLeaf, sBehavior, sIcon, sOpenIcon) {
	// call super

	this.WebFXTree = WebFXTree;
	this.WebFXTree(sText, sAction, sTarget, sCheckbox, sIconarr, sBehavior, sIcon, sOpenIcon);
	// setup default property values
	this.src = sXmlSrc;
	this.loading = false;
	this.loaded = false;
	this.errorText = "";
	// check start state and load if open
	if (this.open) {
		_startLoadXmlTree(this.src, this);
	} else {
		// and create loading item if not
		this._loadingItem = new WebFXTreeItem(webFXTreeConfig.loadingText);
		if (!sLeaf || sLeaf == "false") {
			this.add(this._loadingItem);
		}
	}
}
WebFXLoadTree.prototype = new WebFXTree;

// override the expand method to load the xml file
WebFXLoadTree.prototype._webfxtree_expand = WebFXTree.prototype.expand;
WebFXLoadTree.prototype.expand = function () {
	if (!this.loaded && !this.loading) {
		// load
		_startLoadXmlTree(this.src, this);
	}
	this._webfxtree_expand();
};
/*
 * WebFXLoadTreeItem class
 */
function WebFXLoadTreeItem(sText, sXmlSrc, sAction, sTarget, sCheckbox, sIconarr, sLeaf, eParent, sIcon, sOpenIcon) {
	// call super

	this.WebFXTreeItem = WebFXTreeItem;
	this.WebFXTreeItem(sText, sAction, sTarget, sCheckbox, sIconarr);
	// setup default property values
	this.src = sXmlSrc;
	this.loading = false;
	this.loaded = false;
	this.errorText = "";

	// check start state and load if open
	if (this.open) {
		_startLoadXmlTree(this.src, this);
	} else {
		// and create loading item if not
		this._loadingItem = new WebFXTreeItem(webFXTreeConfig.loadingText);
		if (!sLeaf || sLeaf == "false" ) {
			this.add(this._loadingItem);
		}
	}
}
WebFXLoadTreeItem.prototype = new WebFXTreeItem;

// override the expand method to load the xml file
WebFXLoadTreeItem.prototype._webfxtreeitem_expand = WebFXTreeItem.prototype.expand;
WebFXLoadTreeItem.prototype.expand = function () {
	if (!this.loaded && !this.loading) {
		// load
		_startLoadXmlTree(this.src, this);
	}
	this._webfxtreeitem_expand();
};

// reloads the src file if already loaded
WebFXLoadTree.prototype.reload = WebFXLoadTreeItem.prototype.reload = function () {
	// if loading do nothing
	if (this.loaded) {
		var open = this.open;
		// remove
		while (this.childNodes.length > 0) {
			this.childNodes[this.childNodes.length - 1].remove();
		}
		this.loaded = false;
		this._loadingItem = new WebFXTreeItem(webFXTreeConfig.loadingText);
		this.add(this._loadingItem);
		if (open) {
			this.expand();
		}
	} else {
		if (this.open && !this.loading) {
			_startLoadXmlTree(this.src, this);
		}
	}
};
/*
 * Helper functions
 */

// creates the xmlhttp object and starts the load of the xml document
function _startLoadXmlTree(sSrc, jsNode) {

	if (jsNode.loading || jsNode.loaded) {
		return;
	}
	jsNode.loading = true;
	var xmlHttp = XmlHttp.create();
	xmlHttp.open("GET", sSrc, true);	// async
	xmlHttp.onreadystatechange = function () {
		if (xmlHttp.readyState == 4) {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.async = "false";
			xmlDoc.loadXML(xmlHttp.responseText);
			_xmlFileLoaded(xmlDoc, jsNode);
		}
	};
	// call in new thread to allow ui to update
	window.setTimeout(function () {
		xmlHttp.send(null);
	}, 10);
}


// Converts an xml tree to a js tree. See article about xml tree format
function _xmlTreeToJsTree(oNode) {
	// retreive attributes
 //debugger;
   // var text = oNode.getElementsByTagName("text")[0].firstChild.nodeValue;
	var tilte = nullObject(oNode, "tilte");
	var action = nullObject(oNode, "action");
	var icon = nullObject(oNode, "icon");
	var src = nullObject(oNode, "src");
	var target = nullObject(oNode, "target");
	var checkbox = nullObject(oNode, "checkbox");
	var iconarr = nullObject(oNode, "iconarr");
	var leaf = nullObject(oNode, "leaf");
	var openIcon = null;
	var parent = null;
	
	// create jsNode
	var jsNode;
	
	if (src != null && src != "") {
		jsNode = new WebFXLoadTreeItem(tilte, src, action, target, checkbox, iconarr, leaf, parent, icon, openIcon);
	} else {
		jsNode = new WebFXTreeItem(tilte, action, target, checkbox, iconarr, parent, icon, openIcon, leaf);
	}
	if (target != "") {
		jsNode.target = target;
	}
	var oNodes = oNode.getElementsByTagName("tree");
	for (var i = 0; i < oNodes.length; i++) {
		if (oNodes[0].nodeName == "tree") {
			bAnyChildren = true;
			bIndent = true;
			jsParentNode.add(_xmlTreeToJsTree(oNodes[i]), true);
		}
	}
	// go through childNOdes
	//var cs = oNode.childNodes;
	//var l = cs.length;
	//for (var i = 0; i < l; i++) {
		//if (cs[i].tagName == "tree")
		//	jsNode.add( _xmlTreeToJsTree(cs[i]), true );
	//}
	return jsNode;
}
function nullObject(oNode, subElement) {
	if (oNode.getElementsByTagName(subElement) == null) {
		return null;
	}
	if (oNode.getElementsByTagName(subElement)[0] == null) {
		return null;
	}
	if (oNode.getElementsByTagName(subElement)[0].firstChild == null) {
		return null;
	}
	var result = oNode.getElementsByTagName(subElement)[0].text;
	return result.replace(/\\\'/gi, "'").replace(/\\\"/gi, "\"");
}
// Inserts an xml document as a subtree to the provided node
function _xmlFileLoaded(oXmlDoc, jsParentNode) {
	if (jsParentNode.loaded) {
		return;
	}
	var bIndent = false;
	var bAnyChildren = false;
	jsParentNode.loaded = true;
	jsParentNode.loading = false;

	// check that the load of the xml file went well
	if (oXmlDoc == null || oXmlDoc.documentElement == null) {
		alert(oXmlDoc.xml);
		jsParentNode.errorText = parseTemplateString(webFXTreeConfig.loadErrorTextTemplate, jsParentNode.src);
	} else {
		// there is one extra level of tree elements
		//var root = oXmlDoc.documentElement;
		// loop through all tree children  var oNode = xmlDoc.getElementsByTagName("tree")[0];
		var oNodes = oXmlDoc.getElementsByTagName("tree");
		for (var i = 0; i < oNodes.length; i++) {
			if (oNodes[0].nodeName == "tree") {
				bAnyChildren = true;
				bIndent = true;
				jsParentNode.add(_xmlTreeToJsTree(oNodes[i]), true);
			}
		}
		//var cs = root.childNodes;
		//var l = cs.length;
		//for (var i = 0; i < l; i++) {
		//	if (cs[i].tagName == "tree") {
			//	bAnyChildren = true;
				//bIndent = true;
				//jsParentNode.add( _xmlTreeToJsTree(cs[i]), true);
			//}
		//}

		// if no children we got an error
		if (!bAnyChildren) {
			jsParentNode.errorText = parseTemplateString(webFXTreeConfig.emptyErrorTextTemplate, jsParentNode.src);
		}
	}

	// remove dummy
	if (jsParentNode._loadingItem != null) {
		jsParentNode._loadingItem.remove();
		bIndent = true;
	}
	if (bIndent) {
		// indent now that all items are added
		jsParentNode.indent();
	}

	// show error in status bar
	if (jsParentNode.errorText != "") {
		window.status = jsParentNode.errorText;
	}
}

// parses a string and replaces %n% with argument nr n
function parseTemplateString(sTemplate) {
	var args = arguments;
	var s = sTemplate;
	s = s.replace(/\%\%/g, "%");
	for (var i = 1; i < args.length; i++) {
		s = s.replace(new RegExp("%" + i + "%", "g"), args[i]);
	}
	return s;
}

