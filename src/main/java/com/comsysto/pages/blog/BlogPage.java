package com.comsysto.pages.blog;

import com.comsysto.pages.blog.panel.RecentPostsPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import java.util.Locale;

/**
 * @author sekibomazic
 */
public class BlogPage extends WebPage {

    public BlogPage() {

        getSession().setLocale(Locale.UK);

        germanLink();
        englishLink();

        content();
    }

    private void englishLink() {
        add(new Link("english") {

            @Override
            public void onClick() {
                getSession().setLocale(Locale.UK);
            }
        });

    }

    private void germanLink() {
        add(new Link("german") {

            @Override
            public void onClick() {
                getSession().setLocale(Locale.GERMANY);
            }
        });
    }

    private void content() {
        add(new RecentPostsPanel("content"));
    }


}