package com.comsysto.pages.ajax.tagitexample;

import com.comsysto.pages.ajax.tagit.TagItTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;

/**
 * @author sekibomazic
 */
public class TagitExamplePage extends WebPage {

    public TagitExamplePage(PageParameters parameters) {
        super(parameters);


        Form<Void> form = new Form<Void>("form") {

            @Override
            protected void onSubmit() {
                super.onSubmit();

                System.err.println("submitted values: " + get("tagit").getDefaultModelObjectAsString());
            }

        };
        add(form);

        form.add(new TagItTextField<String>("tagit", Model.of("a1, a4")) {

            @Override
            protected Iterable<String> getChoices(final String term) {

                System.err.println("term> " + term);

                return Arrays.asList("a1", "a2", "a3", "a4");
            }

        });
    }

}