package com.comsysto.pages.eventhandling;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author sekibomazic
 */
public class CustomEvent {

    private final AjaxRequestTarget target;


    public CustomEvent(AjaxRequestTarget target) {
        this.target = target;
    }

    /**
     * Adds the given Components to the current AjaxRequestTarget.
     *
     * @param components
     *            the components to refresh
     */
    public void refresh(Component... components) {
        target.add(components);
    }

}