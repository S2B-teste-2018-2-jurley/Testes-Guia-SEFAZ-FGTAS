import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/**
 * @see https://github.com/s2b-teste-2018-2/webdrivermanager-examples/blob/master/src/test/java/io/github/bonigarcia/wdm/test/ChromeTest.java
 * @author teste
 *
 */
public class FormGuiaSEFAZTest {

    private WebDriver driver;
    //private FormGuiaSEFAZPage page;

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\User\\Download\\Selenium\\chromedriver.exe");
    }


    @Before
    public void setupTest() {
        driver = new ChromeDriver();

        String initialPage = "https://bit.ly/2IogiOY";
        driver.get(initialPage);

        //Create a wait. All test and page classes use this wait.
        //wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Maximize Window
        driver.manage().window().maximize();
        //page = PageFactory.initElements(driver, FormGuiaSEFAZPage.class);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void givenGooglePageWhenSearchingForWikipediaThenAWikipediaSearchBoxAppears() {

        WebElement element = driver.findElement(By.xpath("//*[@id='painelConteudo']/table/tbody/tr[4]/td[2]/select/option[3]"));
        element.click();
        WebElement button = driver.findElement(By.className("botaoMed")); //Botão avançar
        button.click();

        WebElement formDtPagamento = driver.findElement(By.name("DtLimite"));
        formDtPagamento.sendKeys("10112018");
        formDtPagamento.click();

        WebElement formCpf = driver.findElement(By.name("Identificacao"));
        formCpf.sendKeys("68772148209");
        formCpf.click();

        WebElement formReferencia = driver.findElement(By.name("Referencia"));
        formReferencia.sendKeys("02");
        formReferencia.click();

        WebElement formVencimento = driver.findElement(By.name("Vencimento"));
        formVencimento.sendKeys("11112018");
        formVencimento.click();

        WebElement formNome = driver.findElement(By.name("NomeContribuinte"));
        formNome.sendKeys("0joao Ninguem");
        formNome.click();

        WebElement button2 = driver.findElement(By.className("botaoMed")); //Botão avançar
        button2.click();

        WebElement pdf = driver.findElement(By.xpath("//*[@id='painelConteudo']/table/tbody/tr[15]/td/table/tbody/tr/td[2]/a"));
        WebElement nomeContribuinte = driver.findElement(By.xpath("//*[@id='painelConteudo']/table/tbody/tr[11]/td[2]"));


        System.out.println(nomeContribuinte.getText());
        System.out.println("Sucesso");
        Assert.assertTrue("Boleto gerado com sucesso",pdf.isEnabled());
        Assert.assertEquals("0joao Ninguem", nomeContribuinte.getText());
        //WebElement pdf = driver.findElement(By.xpath("//*[@id='painelConteudo']/table/tbody/tr[15]/td/table/tbody/tr/td[2]/a"));
        //pdf.click();
        //element.sendKeys("wikipedia");
        //element.submit();

            /*
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement messageElement = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("nqsbq"))
            );

            assertNotNull(messageElement);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.quit();
            */
    }
}
