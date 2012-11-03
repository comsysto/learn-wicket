package com.comsysto.pages.modal.jqueryalerts;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.ArrayList;
import java.util.List;

public class JQueryAlertsResourceReference extends JavaScriptResourceReference {

	public JQueryAlertsResourceReference() {
		super(JQueryAlertsResourceReference.class, "resources/jquery.alerts.js");
	}
 
	public Iterable<? extends HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = new ArrayList<HeaderItem>();

        // add css
        dependencies.add(CssHeaderItem.forReference(new CssResourceReference(JQueryAlertsResourceReference.class, "resources/jquery.alerts.css")));

        // add jQuery
        dependencies.add(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));

		return dependencies;
	}

}