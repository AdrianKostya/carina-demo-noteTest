package com.qaprosoft.carina.demo.mobile.gui.pages.ios.notes;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.MainPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal.TypeOfDocPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.constant.ProjectConstant;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainPageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TypeOfDocPageBase createNewDoc() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isPageOpened() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }
}
