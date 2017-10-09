package Enums;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
public enum Variables
{
    //MainPage
    LOGIN_BUTTON (".//*[@id='user-login-form']/div[2]/div/button"),
    LOGIN (".//*[@id='user-login-form']/input[2]"),
    PASSWORD (".//*[@id='user-login-form']/input[3]"),
    SELECTED_RIGHT_COLUMN ("//div[@class='col-right']/a"),
    AUTOSALE_LINK ("//a[text()='AVTOSALE']"),
    JOB_LINK ("//a[text()='WORK.ua']"),
    SINOPTIK_LINK ("//a[text()='Sinoptik']"),
    EDISK_LINK ("//a[text()='eDisk']"),

    //Edisk
    DELETE_BUTTON ("//input[@onclick='DeleteSelected();']"),
    CHECK_BOXES_FOR_UPLOADED_FILES ("//tr[@id[contains(., 'viewfile_')]]/td[@class='f shared']/input[@type='checkbox']"),
    CLOSE_UPLOAD_FILES_POP_UP ("#modal-htmlupload-close"),
    SELECT_FILES_BUTTON ("//input[@id='htmluploadfile']"),
    SIMPLE_VERSION_OF_FILES_UPLOADING ("//div[@class='light_upload_desc']/a"),
    UPLOAD_FILES_LITTLE_BUTTON ("//a[@id='user_upload_bt']"),
    UPLOAD_FILES_BUTTON ("//a[@id='user_upload_bt']"),

    //Emails
    DISABLED_NEX_BUTTON ("//a[@class='pager__right disabled']"),
    WRITE_LETTER_BUTTON ("//*[@id='content']/aside/button"),
    NEXT_PAGE ("//*[@id='msglist']/div[4]/div/a[1]/span"),
    EMAILS_SENDER_FIELD ("//span[@class=\"msglist__row-address-wrap\"]"),
    EMAILS_FROM_FACEBOOK ("//tr/td/a/span[contains(., 'Facebook')]"),
    CHECK_BOXES_OF_EMAILS ("//tr/td/label[@class='checkbox noselect']"),
    EMAILS_LINK (".l"),
    CLOSE_POP_UP_FOR_IMPORT_FROM_OTHER_EMAILS ("//div[@class=\"import-hint__step is-step-1 is-visible\"]/div//button[@class=\"import-hint__close-button js-close\"]");

    private String text;
    private Variables (String text)
    {
        this.text=text;
    }

    public String toString()
    {
        return this.text;
    }
}
