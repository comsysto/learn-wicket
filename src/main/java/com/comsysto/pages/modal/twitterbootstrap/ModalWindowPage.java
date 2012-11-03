package com.comsysto.pages.modal.twitterbootstrap;

import com.comsysto.pages.eventhandling.eventdispatcher.EventHandler;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.Date;

/**
 * @author sekibomazic
 */
public class ModalWindowPage extends WebPage {

    ModalWindow modalWindow;

    public ModalWindowPage() {

        label();

        modalWindow();

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

    private void modalWindow() {
        modalWindow = new ModalWindow("modal");
        add(modalWindow);
    }


    private void link() {
        WebMarkupContainer link = new WebMarkupContainer("link");
        link.add(new ModalBehavior(modalWindow.getModalWindowId()));
        add(link);
    }


    @EventHandler
    public void onUpdateLabel(UpdateLabelEvent event) {
        event.refresh(get("label"));
    }


}