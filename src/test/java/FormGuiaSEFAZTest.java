
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @see https://github.com/s2b-teste-2018-2/webdrivermanager-examples/blob/master/src/test/java/io/github/bonigarcia/wdm/test/ChromeTest.java
 * @author Jurley Colares Ribeiro
 *
 */
public class FormGuiaSEFAZTest {

    private WebDriver driver;
    WebDriverWait wait;
    private FormGuiaSEFAZPage page;

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\User\\Download\\Selenium\\chromedriver.exe");
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver, 5);
        String initialPage = "https://bit.ly/2IogiOY";
        driver.get(initialPage);
        driver.manage().window().maximize();
        page = PageFactory.initElements(driver, FormGuiaSEFAZPage.class);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void afterFillOutFormThenChecksToSeeIfTheNameFieldContainsNumericValue() {

        page.selectOption();
        page.selectButton();
        page.dtPagamento();
        page.cpf();
        page.referencia();
        page.vencimento();
        page.nome();
        page.selectButton2();
        page.nomeContribuinte();

        //---------- Test ---------

        Assert.assertThat(page.nomeContribuinte.getText(), CoreMatchers.containsString("0"));
//        Assert.assertThat(page.nomeContribuinte.getText(), CoreMatchers.containsString(page.));
        Assert.assertEquals("0joao Ninguem", page.nomeContribuinte.getText());
    }


    @Test
    public void givenFormThenVerifiesIfItGeneratedPaymentSlip() throws InterruptedException {

        page.selectOption();
        page.selectButton();
        page.dtPagamento();
        page.cpf();
        page.referencia();
        page.vencimento();
        page.nome();
        page.selectButton2();
        page.nomeContribuinte();

        //---------- Test ---------
        Assert.assertTrue("Boleto gerado com sucesso",page.pdf.isEnabled());
        page.downloadPdf();

        Thread.sleep(8000);

        //Verifica se download foi realizado.
        page.checkDonwload();
    }

    @Test
    public void checkIfPopUpAlertPresentAndTextContentInAlert () throws InterruptedException {

        page.selectOption();
        page.selectButton();
        page.generatoRandomDateWith2018();
        page.cpf();
        page.referencia();
        page.vencimento();
        page.nome();
        page.selectButton2();

        //---------- Test ---------
        wait.until(ExpectedConditions.alertIsPresent());
        //Assert.assertEquals(driver.switchTo().alert().getText(), "Data Progr p/ Pagamento Nao deve ser Menor que Data Atual");
        Assert.assertEquals(driver.switchTo().alert().getText(), "Data inv�lida! (Informe:ddmmaaaa)");

        Thread.sleep(5000);
    }

    @Test
    public void givenFieldExpirationDateWithStringThenChecksIfPopupAlertAppears () throws IOException {

        page.selectOption();
        page.selectButton();
        page.dtPagamento();
        page.cpf();
        page.referencia();
        page.generatoAsciiRandomNameVencimento();
        page.nome();
        page.selectButton2();

        //---------- Test ---------
        wait.until(ExpectedConditions.alertIsPresent());
        driver.getCurrentUrl();
        File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrShot, new File("C:\\Users\\jurle\\Downloads\\screenshot.png"));
    }
}
