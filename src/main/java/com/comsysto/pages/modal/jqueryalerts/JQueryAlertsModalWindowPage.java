package com.comsysto.pages.modal.jqueryalerts;

import com.comsysto.pages.eventhandling.eventdispatcher.EventHandler;
import com.comsysto.pages.modal.twitterbootstrap.UpdateLabelEvent;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.Date;

/**
 * @author sekibomazic
 */
public class JQueryAlertsModalWindowPage extends WebPage {

    public JQueryAlertsModalWindowPage() {

        label();

        link();
    }

    private void label() {
        Label label = new Label("label", new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                return new Date().toString();
            }
        });

        label.setOutputMarkupId(true);
        add(label);
    }


    private void link() {

        AjaxLink<Void> link = new AjaxLink<Void>("link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                send(getPage(), Broadcast.BREADTH, new UpdateLabelEvent(target));
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                super.updateAjaxAttributes(attributes);

                // register the onSuccess listener that will execute Handlebars logic
                AjaxCallListener listener = new AjaxCallListener();

                StringBuffer sb = new StringBuffer();
                sb.append("jConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {\n");
                sb.append("if (r) { return true; } \n");
                sb.append("return false; \n");
                sb.append("}\n");
                sb.append(");");

                listener.onPrecondition(sb.toString());

                attributes.getAjaxCallListeners().add(listener);
            }

        };

        link .add(new JQueryAlertsBehavior());

        add(link);

    }


    @EventHandler
    public void onUpdateLabel(UpdateLabelEvent event) {
        event.refresh(get("label"));
    }


}