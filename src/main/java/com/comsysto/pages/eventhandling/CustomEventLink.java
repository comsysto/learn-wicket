package com.comsysto.pages.eventhandling;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.model.IModel;

/**
 * @author sekibomazic
 */
public class CustomEventLink extends AjaxLink<Void> {

    public CustomEventLink(String id, IModel<Void> model) {
        super(id, model);
    }

    public CustomEventLink(String id) {
        super(id);
    }

    @Override
    public void onClick(AjaxRequestTarget target) {
        send(getPage(), Broadcast.DEPTH, new CustomEvent(target));
    }

}