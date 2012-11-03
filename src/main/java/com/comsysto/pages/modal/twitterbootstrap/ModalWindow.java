package com.comsysto.pages.modal.twitterbootstrap;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author sekibomazic
 */
public class ModalWindow extends Panel {

    private WebMarkupContainer wmc;

    public ModalWindow(String id) {
        super(id);

        wmc = new WebMarkupContainer("wmc") {
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                tag.put("id", getMarkupId());
            };
        };

        add(wmc);

        wmc.add(new AjaxLink<Void>("actionLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                send(getPage(), Broadcast.BREADTH, new UpdateLabelEvent(target));
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                super.updateAjaxAttributes(attributes);

                // register the onSuccess listener that will execute Handlebars logic
                AjaxCallListener listener = new AjaxCallListener();

                // For the 'complete' handler it looks like: function(attrs, jqXHR, textStatus){$('#modalWindowId').modal('hide');}
                listener.onComplete("$('#" + getModalWindowId() + "').modal('hide');");

                attributes.getAjaxCallListeners().add(listener);
            }
        });
    }

    public String getModalWindowId() {
        return wmc.getMarkupId();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        Bootstrap.renderHeadResponsive(response);
    }

}