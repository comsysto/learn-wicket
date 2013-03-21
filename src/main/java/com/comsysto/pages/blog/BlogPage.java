package com.comsysto.pages.blog;

import com.comsysto.WicketApplication;
import com.comsysto.domain.Post;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Locale;

/**
 * @author sekibomazic
 */
public abstract class BlogPage extends WebPage {

    public BlogPage() {
        initPage();
    }

    public BlogPage(PageParameters parameters) {
        super(parameters);
        checkParameters(parameters);
        initPage();
    }

    @Override
    public void onInitialize() {
        super.onInitialize();

        add(getContent("content"));
    }

    private void initPage() {
        getSession().setLocale(Locale.UK);

        germanLink();
        englishLink();
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

    protected void checkParameters(PageParameters params) {
        // there must at least be one parameter denoting the blog
        if (params.isEmpty()) {
            throw new RestartResponseException(WicketApplication.get().getHomePage());
        }
    }

    public static PageParameters constructPostEntryPageParameters(Post post) {
        PageParameters params = new PageParameters();

        if (post != null) {
            params.add("id", post.getId());
        }

        return params;
    }

    public abstract Component getContent(String id);

}