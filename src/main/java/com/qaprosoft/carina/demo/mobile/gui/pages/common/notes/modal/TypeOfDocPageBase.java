package com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.TextPageBase;
import org.openqa.selenium.WebDriver;

public abstract class TypeOfDocPageBase extends AbstractPage {

    public TypeOfDocPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TextPageBase choseTextTypeOfDoc();

    public abstract boolean isPageOpened();

}
