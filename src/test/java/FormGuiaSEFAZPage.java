import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormGuiaSEFAZPage {

    private List<String> arrayName;

    @FindBy(xpath = "//select[@name = 'CodDescTaxa']")
    @CacheLookup WebElement element;

    @FindBy(className = "botaoMed")
    @CacheLookup WebElement button;

    @FindBy(name = "DtLimite")
    @CacheLookup WebElement formDtPagamento;

    @FindBy(name = "DtLimite")
    @CacheLookup WebElement formDtPagamentoRandom;

    @FindBy(name = "Identificacao")
    @CacheLookup WebElement formCpf;

    @FindBy(name = "Referencia")
        @CacheLookup WebElement formReferencia;

    @FindBy(name = "Vencimento")
        @CacheLookup WebElement formVencimento;

    @FindBy(name = "NomeContribuinte")
        @CacheLookup WebElement formNome;

    @FindBy(className = "botaoMed")
        @CacheLookup WebElement button2;

    @FindBy(xpath = "//*[@id='painelConteudo']/table/tbody/tr[15]/td/table/tbody/tr/td[2]/a")
        @CacheLookup WebElement pdf;

    @FindBy(xpath = "//*[@id='painelConteudo']/table/tbody/tr[11]/td[2]")
            @CacheLookup WebElement nomeContribuinte;

    //Methods
    void selectOption () {
        Select select = new Select(element);
        select.selectByValue("2801EMISSÃO DA 2A CARTEIRA DE ARTESÃO");
    }

    void selectButton () {
        button.click();
    }

    void dtPagamento(){
        formDtPagamento.sendKeys("10112018");
        formDtPagamento.click();
    }

    void cpf(){
        formCpf.sendKeys("68772148209");
        formCpf.click();
    }

    void referencia() {
        formReferencia.sendKeys("02");
        formReferencia.click();
    }

    void vencimento() {
        formVencimento.sendKeys("11112018");
        formVencimento.click();
    }

    void nome() {
        formNome.sendKeys("0joao Ninguem");
        formNome.click();
    }

    void selectButton2 () {
        button2.click();
    }

    void downloadPdf(){
        pdf.click();
    }

    void nomeContribuinte(){
        nomeContribuinte.getText();
        System.out.println("Nome do Contribuinte: " + nomeContribuinte.getText());
    }

    public void generatoAsciiRandomName() {
    // Creates a 10 chars length of random ascii string.
        String randomAsciiName = org.apache.commons.lang3.RandomStringUtils.randomAscii(10);
        System.out.println("Random Name = " + randomAsciiName);
    }

    public void generatoAsciiRandomNameVencimento() {
        // Creates a 10 chars length of random ascii string.
        String randomAsciiName = org.apache.commons.lang3.RandomStringUtils.randomAscii(10);
        formVencimento.sendKeys(randomAsciiName);
        formVencimento.click();
    }

    public void generatoAsciiRandomDate(){
        // Creates a 10 chars length of random ascii string.
        //String randomDate = org.apache.commons.lang3.RandomUtils.nextInt(9);
        //System.out.println("Random Date = " + randomDate);
        Random rand = new Random();
        int num = rand.nextInt(9000) + 1000;
        System.out.println("Random Date = " + num);
    }

    public void generatoRandomDateWith2018(){
        // Creates a 10 chars length of random ascii string.
        Random rand = new Random();
        int num = rand.nextInt(9000) + 1000;
        String numAno = num + "2018";
        formDtPagamentoRandom.sendKeys(numAno);
        formDtPagamentoRandom.click();
    }

    public ArrayList[] arrayNumber(){
        ArrayList[] listNumber = new ArrayList[9];
        for ( int i = 0; i < listNumber.length; i++ ) {
            listNumber[i] = new ArrayList<Integer>();
        }
        // exibe os valores da lista
        for(int i = 0; i < listNumber.length; i++) {
            System.out.println(i);
            System.out.println(listNumber.length);
            //System.exit(0);

        }

        return listNumber;
    }

    //verifies that the download is complete
    void checkDonwload(){
        File pdfFile = new File("C:\\Users\\jurle\\Downloads\\GA_SEFAZRS.pdf");
        if (pdfFile.exists()) {
            System.out.println("Arquivo existe!");
        }else {
            System.out.println("Arquivo Não existe!");
        }
    }
}
