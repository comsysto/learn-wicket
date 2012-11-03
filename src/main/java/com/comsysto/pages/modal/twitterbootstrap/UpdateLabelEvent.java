package com.comsysto.pages.modal.twitterbootstrap;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author sekibomazic
 */
public class UpdateLabelEvent {

    private final AjaxRequestTarget target;

    public UpdateLabelEvent(AjaxRequestTarget target) {
        this.target = target;
    }

    public final void refresh(Component... components) {
        target.add(components);
    }

}