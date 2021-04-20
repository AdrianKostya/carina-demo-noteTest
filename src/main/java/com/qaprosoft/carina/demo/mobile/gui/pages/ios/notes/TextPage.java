package com.qaprosoft.carina.demo.mobile.gui.pages.ios.notes;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.TextPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.constant.ProjectConstant;
import org.openqa.selenium.WebDriver;

public class TextPage extends TextPageBase {

    public TextPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
       throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }
}
