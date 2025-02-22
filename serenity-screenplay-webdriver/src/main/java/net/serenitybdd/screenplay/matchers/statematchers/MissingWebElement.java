package net.serenitybdd.screenplay.matchers.statematchers;

import net.serenitybdd.core.pages.WebElementState;

import java.util.List;
import java.util.Optional;

public class MissingWebElement implements WebElementState {

    private final String elementName;
    private String expectedErrorMessage;

    public MissingWebElement(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isCurrentlyVisible() {
        return false;
    }

    @Override
    public boolean isCurrentlyEnabled() {
        return false;
    }

    @Override
    public WebElementState shouldBeVisible() {
        failWithMessage("Element should be visible");
        return this;
    }

    @Override
    public WebElementState shouldBeCurrentlyVisible() {
        failWithMessage("Element should be visible");
        return this;
    }

    @Override
    public WebElementState shouldNotBeVisible() {
        return this;
    }

    @Override
    public WebElementState shouldNotBeCurrentlyVisible() {
        return this;
    }

    @Override
    public boolean hasFocus() {
        return false;
    }

    @Override
    public boolean containsText(String value) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public boolean containsOnlyText(String value) {
        return false;
    }

    @Override
    public boolean containsSelectOption(String value) {
        return false;
    }

    @Override
    public WebElementState shouldContainText(String textValue) {
        String errorMessage = String.format(
                "The text '%s' was not found in the web element. Element text '%s'.", textValue, elementName);
        failWithMessage(errorMessage);
        return this;
    }

    @Override
    public WebElementState shouldContainOnlyText(String textValue) {
        String errorMessage = String.format(
                "The text '%s' does not match the elements text '%s'.", textValue, elementName);
        failWithMessage(errorMessage);
        return this;
    }

    @Override
    public WebElementState shouldContainSelectedOption(String textValue) {
        failWithMessage(String.format("The list element '%s' was not found in the web element %s", textValue, elementName));
        return this;
    }

    @Override
    public WebElementState shouldNotContainText(String textValue) {
        return this;
    }

    @Override
    public WebElementState shouldBeEnabled() {
        failWithMessage(String.format("Field '%s' should be enabled", elementName));
        return this;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public WebElementState shouldNotBeEnabled() {
        return this;
    }

    @Override
    public String getSelectedVisibleTextValue() {
        return null;
    }

    @Override
    public String getSelectedValue() {
        return null;
    }

    @Override
    public List<String> getSelectOptions() {
        return null;
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public WebElementState shouldBePresent() {
        failWithMessage(String.format("Field '%s' should be present", elementName));
        return this;
    }

    @Override
    public WebElementState shouldNotBePresent() {
        return this;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public String getTextValue() {
        return null;
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public String getAttribute(String name) {
        return "";
    }

    @Override
    public WebElementState expect(String errorMessage) {
        this.expectedErrorMessage = errorMessage;
        return this;
    }

    @Override
    public boolean isClickable() {
        return false;
    }

    private void failWithMessage(String errorMessage) {
        throw new AssertionError(getErrorMessage(errorMessage));
    }

    protected String getErrorMessage(String defaultErrorMessage) {
        return Optional.ofNullable(expectedErrorMessage).orElse(defaultErrorMessage);
    }
}
