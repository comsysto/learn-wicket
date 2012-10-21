package com.comsysto.pages.eventhandling;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * Components which shall be refreshed can be added
 * via {@link com.comsysto.pages.eventhandling.RefreshClick#refresh(org.apache.wicket.Component...)}.
 * They will be added to the current AjaxRequestTarget.
 * 
 * @author Sekib Omazic
 */
public class RefreshClick {

    private final AjaxRequestTarget target;

    public RefreshClick(AjaxRequestTarget target) {
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