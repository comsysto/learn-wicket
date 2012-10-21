package com.comsysto.pages.eventhandling;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * This page demonstrates the loose coupling of components via Events.
 * 
 * @author Sekib Omazic
 */
public class EventPage extends WebPage {

    public EventPage(final PageParameters parameters) {

        //////////////////////////////////////////////
        // 1. Tightly coupled
        //////////////////////////////////////////////
        final Label notCoolCounter = new Label("not_cool_counter", new CounterModel());
        notCoolCounter.setOutputMarkupId(true);
        add(notCoolCounter);

        // the link to refresh the not_cool_counter
        AjaxLink<Void> notCoolRefreshLink = new AjaxLink<Void>("not_cool_refresh_link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(notCoolCounter);
            }
        };
        add(notCoolRefreshLink);




        //////////////////////////////////////////////
        // 2. Decoupled
        //////////////////////////////////////////////

        Label coolCounter = new Label("cool_counter", new CounterModel()) {
            @Override
            public void onEvent(IEvent<?> event) {
                // react only on RefreshClick event
                if (event.getPayload() != null && event.getPayload() instanceof RefreshClick) {
                    ((RefreshClick) event.getPayload()).refresh(this);
                }
            }
        };
        coolCounter.setOutputMarkupId(true);
        add(coolCounter);

        // the link to refresh the counter
        AjaxLink<Void> coolRefreshLink = new AjaxLink<Void>("cool_refresh_link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                // send RefreshClick event
                send(getParent(), Broadcast.DEPTH, new RefreshClick(target));
            }
        };
        add(coolRefreshLink);



        //////////////////////////////////////////////
        // 3. Decoupled but without ugly instanceof
        //////////////////////////////////////////////

        // this label reacts only on CustomEvent
        CustomLabel l = new CustomLabel("super_cool_counter", new CounterModel());
        add(l);

        // custom link (fires CustomEvent)
        add(new CustomEventLink("super_cool_refresh_link"));
    }

}