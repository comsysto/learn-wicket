package com.comsysto.pages.blog.component;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;

/**
 * @author sekibomazic
 */
public class BootstrapAjaxPagingNavigator extends AjaxPagingNavigator {


    public BootstrapAjaxPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
    }

}