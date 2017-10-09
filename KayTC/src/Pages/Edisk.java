package Pages;

import Elements.Button;
import Enums.Variables;
import MainSettings.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by serhii.kaihorodov on 1/5/2016.
 */
public class Edisk extends Settings {
    private Button upload_files_little_button = new Button(By.xpath(Variables.UPLOAD_FILES_LITTLE_BUTTON.toString()));
    private Button upload_files_big_button = new Button(By.xpath(Variables.UPLOAD_FILES_BUTTON.toString()));
    private Button simple_version_of_files_uploading = new Button(By.xpath(Variables.SIMPLE_VERSION_OF_FILES_UPLOADING.toString()));
    private Button select_files_button = new Button(By.xpath(Variables.SELECT_FILES_BUTTON.toString()));
    private Button close_upload_files_pop_up = new Button(By.cssSelector(Variables.CLOSE_UPLOAD_FILES_POP_UP.toString()));
    private List<WebElement> list_of_uploaded_files = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));
    private List<WebElement> list_of_check_boxed_for_uploaded_files = getDriver().findElements(By.xpath(Variables.CHECK_BOXES_FOR_UPLOADED_FILES.toString()));
    private Button delete_button = new Button(By.xpath(Variables.DELETE_BUTTON.toString()));

    public Edisk upload_file_to_Edisk() {
        if (upload_files_big_button.isPresent()) {
            upload_files_big_button.click();
        } else {
            upload_files_little_button.click();
        }
        simple_version_of_files_uploading.waitForElementIsPresent();
        simple_version_of_files_uploading.click();

        select_files_button.waitForElementIsPresent();
        select_files_button.click();
        run_script_for_file_uploading();
        close_upload_files_pop_up.waitForElementIsPresent();
        close_upload_files_pop_up.click();

        List<WebElement> list_of_uploaded_files1 = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));

        assertFalse(list_of_uploaded_files1.isEmpty(), "TC is failed - there is no expected uploaded file");

        return new Edisk();
    }

    public Edisk delete_uploaded_files() {
        if (list_of_check_boxed_for_uploaded_files.isEmpty()) {
            return new Edisk();
        } else {
            for (WebElement ell : list_of_check_boxed_for_uploaded_files) {
                ell.click();
            }
        }
        sleep(4);
        delete_button.click();
        sleep(4);
// How to handle javascript alerts - please see "http://www.seleniumeasy.com/selenium-tutorials/how-to-handle-javascript-alerts-confirmation-prompts" link
        org.openqa.selenium.Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        sleep(4);
        List<WebElement> list_of_uploaded_files2 = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));
        assertTrue(list_of_uploaded_files2.isEmpty(), "TC is Failed - uploaded files were not deleted from Edisk");
        return new Edisk();
    }

    public Edisk upload_files_many_times(int times) {
        for (int i = 0; i < times; i++) {
            upload_file_to_Edisk();
        }
        return new Edisk();
    }

    public void run_script_for_file_uploading() {
        String path_toFile = System.getProperty("user.dir").replace("KayTC", "") + "AutoIt_files\\";
        System.out.println("path_toFile is: " + path_toFile);
        try {
            if (Settings.env == "chrome") {
                Runtime.getRuntime().exec("D:\\Projects\\" + "Upload_Files_For_ukr_net_Chrome_Browser.exe");
//                    Runtime.getRuntime().exec(path_toFile + "Upload_Files_For_ukr_net_Chrome_Browser.exe");
            } else if (Settings.env == "firefox") {
                Runtime.getRuntime().exec("D:\\Projects\\" + "Upload_Files_For_ukr_net_FF_Browser.exe");
//                    Runtime.getRuntime().exec(path_toFile + "Upload_Files_For_ukr_net_FF_Browser.exe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleep(10);
    }
}
