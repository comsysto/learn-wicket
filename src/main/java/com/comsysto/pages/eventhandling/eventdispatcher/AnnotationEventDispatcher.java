package com.comsysto.pages.eventhandling.eventdispatcher;

import org.apache.wicket.Component;
import org.apache.wicket.IEventDispatcher;
import org.apache.wicket.event.IEvent;

import java.lang.reflect.Method;

/**
 *
 * @author Sekib Omazic
 */
public class AnnotationEventDispatcher implements IEventDispatcher {

    @Override
    public void dispatchEvent(Object sink, IEvent<?> event, Component component) {
        Object payload = event.getPayload();
        Class<?> payloadClass = payload.getClass();

        // get all public methods of the target class
        Method[] sinkMethods = sink.getClass().getMethods();

        for (Method sinkMethod : sinkMethods) {

            // use only annotated method
            if (sinkMethod.isAnnotationPresent(EventHandler.class)) {
                Class<?>[] paramTypes = sinkMethod.getParameterTypes();

                // with exactly one parameter
                if (paramTypes.length == 1 && paramTypes[0].isAssignableFrom(payloadClass)) {
                    try {
                        sinkMethod.invoke(sink, payload);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }

    }

}