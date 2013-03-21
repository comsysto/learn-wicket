package com.comsysto;

import com.comsysto.pages.blog.PostEntryPage;
import com.comsysto.pages.blog.RecentEntriesPage;
import com.comsysto.pages.eventhandling.eventdispatcher.AnnotationEventDispatcher;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.comsysto.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    @Autowired
    ApplicationContext applicationContext;

    /**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here
        mountBlogPage();

        // spring
        initSpring();

        // custom event dispatcher
        this.getFrameworkSettings().add(new AnnotationEventDispatcher());
	}

    protected void initSpring() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
    }

    protected void mountBlogPage() {
        mountPage("/entries", RecentEntriesPage.class);
        mountPage("/post", PostEntryPage.class);
    }

}