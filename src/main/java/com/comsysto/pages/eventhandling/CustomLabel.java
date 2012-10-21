package com.comsysto.pages.eventhandling;

import com.comsysto.pages.eventhandling.eventdispatcher.EventHandler;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * @author sekibomazic
 */
public class CustomLabel extends Label {

    public CustomLabel(String id, IModel<?> model) {
        super(id, model);
        setOutputMarkupId(true);
    }

    @Override
    public void onEvent(IEvent<?> event) {
        if (event.getPayload() != null && event.getPayload() instanceof CustomEvent) {
            System.out.println("onEvent of Label called");
            //((CustomEvent) event.getPayload()).refresh(this);
        }
    }

    @EventHandler
    public void onCustomEvent(CustomEvent customEvent) {
        System.out.println("onCustomEvent of Label called");
        customEvent.refresh(this);
    }

}