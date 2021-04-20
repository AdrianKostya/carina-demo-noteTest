package com.qaprosoft.carina.demo.mobile.gui.pages.common.notes;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LearnPageBase extends AbstractPage {

    public LearnPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isWelcomeArrowPresent();

    public abstract void clickWelcomeArrow();

    public abstract boolean isAllowAcesPhotosBtnPresent();

    public abstract void choseAllowAccessPhotos();

    public abstract boolean isWelcomeSkipBtnPresent();

    public abstract void clickWelcomeSkipBtn();

    public abstract  void skipToMainPage();

    public abstract boolean isPageOpened();

}
