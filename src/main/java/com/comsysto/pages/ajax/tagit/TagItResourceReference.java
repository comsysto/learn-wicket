package com.comsysto.pages.ajax.tagit;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.ArrayList;
import java.util.List;

public class TagItResourceReference extends JavaScriptResourceReference {

	public TagItResourceReference() {
		super(TagItResourceReference.class, "js/tag-it.js");
	}
 
	public Iterable<? extends HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = new ArrayList<HeaderItem>();

        // add css
        dependencies.add(CssHeaderItem.forReference(new CssResourceReference(TagItResourceReference.class, "css/jquery.tagit.css")));

        // add jQuery
        dependencies.add(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));

        // add jQueryUI from Google CDN
		Url jQueryUI = Url.parse("https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js");
		UrlResourceReference externalUrlResourceReference = new UrlResourceReference(jQueryUI);
		dependencies.add(JavaScriptHeaderItem.forReference(externalUrlResourceReference));
 
		return dependencies;
	}


}