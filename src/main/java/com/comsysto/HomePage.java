package com.comsysto;

import com.comsysto.pages.ajax.tagitexample.TagitExamplePage;
import com.comsysto.pages.eventhandling.EventPage;
import com.comsysto.pages.iterators.AccountsPage;
import com.comsysto.pages.modal.jqueryalerts.JQueryAlertsModalWindowPage;
import com.comsysto.pages.modal.twitterbootstrap.ModalWindowPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {

        super(parameters);

	    add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's components here

        // ADDED
        add(new Link<Void>("accounts") {
            @Override
            public void onClick() {
                setResponsePage(AccountsPage.class);
            }
        });

        add(new Link<Void>("events") {
            @Override
            public void onClick() {
                setResponsePage(EventPage.class);
            }
        });

        add(new Link<Void>("tagit") {
            @Override
            public void onClick() {
                setResponsePage(TagitExamplePage.class);
            }
        });

        add(new Link<Void>("modal") {
            @Override
            public void onClick() {
                setResponsePage(ModalWindowPage.class);
            }
        });

        add(new Link<Void>("modal2") {
            @Override
            public void onClick() {
                setResponsePage(JQueryAlertsModalWindowPage.class);
            }
        });
    }

}