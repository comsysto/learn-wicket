package com.comsysto.pages.iterators;

import com.comsysto.domain.Account;
import com.comsysto.repositories.AccountRepository;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * @author sekibomazic
 */
public class AccountsPage extends WebPage {

    @SpringBean
    private AccountRepository accountRepository;


    public AccountsPage() {
        accountList();
    }

    private void accountList() {
        IModel<List<Account>> accountListModel = new AbstractReadOnlyModel<List<Account>>() {
            @Override
            public List<Account> getObject() {
                return accountRepository.findAll();
            }
        };

        ListView<Account> accountListView = new ListView<Account>("accountList", accountListModel) {
            @Override
            protected void populateItem(ListItem<Account> item) {
                item.add(new Label("account_id", new PropertyModel<String>(item.getModel(), "idFrontend")));
                item.add(new Label("account_name", new PropertyModel<String>(item.getModel(), "name")));
                item.add(new Label("account_balance", new PropertyModel<String>(item.getModel(), "cashBalanceFrontend")));
            }

        };

        add(accountListView);
    }

}