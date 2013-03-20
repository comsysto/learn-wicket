package com.comsysto.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sekibomazic
 */
public class CategoryRepositoryTest extends RepositoryTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        createTestCategories();
    }

    @Test
    public void storeSomeCategories() {

        Assert.assertEquals(2, categoryRepository.count());

        Assert.assertFalse(categoryRepository.findAll().get(0).isNew());

    }

}