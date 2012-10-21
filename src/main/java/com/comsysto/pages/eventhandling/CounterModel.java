package com.comsysto.pages.eventhandling;

import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author sekibomazic
 */
public class CounterModel extends AbstractReadOnlyModel<String> {

    private int counter = 0;

    @Override
    public String getObject() {
        return String.valueOf(counter++);
    }

}