package com.comsysto.pages.blog;

import com.comsysto.pages.blog.panel.RecentPostsPanel;
import org.apache.wicket.Component;

/**
 * @author sekibomazic
 */
public class RecentEntriesPage extends BlogPage {

    @Override
    public Component getContent(String id) {
        return new RecentPostsPanel(id);
    }

}