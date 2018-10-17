
import java.io.File;

import org.hamcrest.CoreMatchers;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Alert;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
    public void afterFillOutFormThenChecksToSeeIfTheNameFieldContainsNumericValue() {

        WebElement element = driver.findElement(By.xpath("//select[@name = 'CodDescTaxa']"));

        Select select = new Select(element);
        select.selectByValue("2801EMISSÃO DA 2A CARTEIRA DE ARTESÃO");
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

        //wait(driver,10);
        Assert.assertThat(nomeContribuinte.getText(), CoreMatchers.containsString("0"));
        //Assert.assertTrue("Boleto gerado com sucesso",pdf.isEnabled());
        //Assert.assertEquals("0joao Ninguem", nomeContribuinte.getText());
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

    @Test
    public void givenFormThenVerifiesIfItGeneratedPaymentSlip() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//select[@name = 'CodDescTaxa']"));

        Select select = new Select(element);
        select.selectByValue("2801EMISSÃO DA 2A CARTEIRA DE ARTESÃO");
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
        Thread.sleep(8000);
        Assert.assertTrue("Boleto gerado com sucesso",pdf.isEnabled());
        pdf.click();

        Thread.sleep(10000);

        //Verifica se download foi realizado.
        File pdfFile = new File("C:\\Users\\jurle\\Downloads\\GA_SEFAZRS.pdf");
        if (pdfFile.exists()) {
            System.out.println("Arquivo existe!");
        }else {
            System.out.println("Arquivo Não existe!");
            }

    }

    @Test
    public void checkPopUp () throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//select[@name = 'CodDescTaxa']"));

        Select select = new Select(element);
        select.selectByValue("2801EMISSÃO DA 2A CARTEIRA DE ARTESÃO");
        WebElement button = driver.findElement(By.className("botaoMed")); //Botão avançar
        button.click();

        WebElement formDtPagamento = driver.findElement(By.name("DtLimite"));
        formDtPagamento.sendKeys("10102018");
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

/*
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
*/
        Thread.sleep(2000);
        //Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent()));
        //wait.until(ExpectedConditions.alertIsPresent());
        // true, ExpectedConditions.alertIsPresent());
        Assert.assertTrue(ExpectedConditions.alertIsPresent());
        //Assert.assertEquals(driver.switchTo().alert().getText(), "Data Progr p/ Pagamento Nao deve ser Menor que Data Atual");

        Thread.sleep(10000);
    }
}
