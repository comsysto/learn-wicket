package com.comsysto.pages.modal.jqueryalerts;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

/**
 * @author sekibomazic
 */
public class JQueryAlertsBehavior extends Behavior {

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(JavaScriptHeaderItem.forReference(new JQueryAlertsResourceReference()));
    }

}