package com.comsysto;

import com.comsysto.repositories.AccountRepository;
import org.apache.wicket.mock.MockApplication;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {

	private WicketTester tester;

    @Before
    public void setUp() throws Exception {

        // create mocked appliction
        final ApplicationContextMock ctx = new ApplicationContextMock();

        // register mocked bean (in this case the AccountRepository)
        ctx.putBean(Mockito.mock(AccountRepository.class));

        final WebApplication mockApplication = new MockApplication() {

            @Override
            protected void internalInit() {

                super.internalInit();

                // enable spring injection
                getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));

                // don't trow exception if no resources are found (e.g. <wicket:message key=..." />)
                getResourceSettings().setThrowExceptionOnMissingResource(false);

            }
        };


        tester = new WicketTester(mockApplication);

    }


	@Test
	public void homepageRendersSuccessfully() {
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}

}