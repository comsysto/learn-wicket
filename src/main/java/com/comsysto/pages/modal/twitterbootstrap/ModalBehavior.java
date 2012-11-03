package com.comsysto.pages.modal.twitterbootstrap;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;

/**
 * @author sekibomazic
 */
public class ModalBehavior extends Behavior {
    private String modalWindowId;

    public ModalBehavior(String modalWindowId) {
        this.modalWindowId = modalWindowId;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(JavaScriptReferenceHeaderItem.forScript("$('#" + modalWindowId + "').modal()", "bootstrap-modal"));
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        tag.put("data-toggle", "modal");
        tag.put("href", "#" + modalWindowId);

        super.onComponentTag(component, tag);
    }

}