package com.test.etsy.tests;

import com.beust.jcommander.Parameter;
import com.test.etsy.pages.EtsyHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsySearchTest extends EtsyTestBase{
    @Parameters({"searchItem","word1","word2","word3"})
    @Test
    public void validateSearchBarFunctionality(String searchItem,String word1,String word2,String word3) {
            EtsyHomePage etsyHomePage = new EtsyHomePage(driver);
            etsyHomePage.clickSearchBar(searchItem);
            etsyHomePage.searchFunctionality(word1,word2,word3);

        }

    }

