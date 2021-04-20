package com.qaprosoft.carina.demo.mobile.gui.pages.common.notes;

import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal.TypeOfDocPageBase;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends AbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TypeOfDocPageBase createNewDoc();

    public abstract boolean isPageOpened();

}
